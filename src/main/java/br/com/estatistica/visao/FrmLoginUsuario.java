package br.com.estatistica.visao;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import br.com.estatistica.dao.UsuarioDAO;
import br.com.estatistica.modelos.Usuario;
import br.com.estatistica.util.ConnectionFactory;
import br.com.estatistica.util.Mensagem;
import javax.swing.ImageIcon;

public class FrmLoginUsuario extends JFrame {

	private JPanel contentPane;
	private JTextField txtUsuario;
	private JPasswordField txtSenha;

	private static final UsuarioDAO uDao;
	private Usuario usuario;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmLoginUsuario frame = new FrmLoginUsuario();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	static {
		uDao = new UsuarioDAO(new ConnectionFactory().getConnection());

	}

	/**
	 * Create the frame.
	 */
	public FrmLoginUsuario() {
		initComponents();
	}

	protected void initComponents() {
		setTitle("Autenticação de usuário");

		setResizable(false);

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 500, 400);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);

		JPanel panel = new JPanel();
		panel.setBackground(Color.DARK_GRAY);
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(null);

		JLabel label_1 = new JLabel("");
		label_1.setIcon(new ImageIcon(FrmLoginUsuario.class.getResource("/br/com/estatistica/util/icons/Logo-vers-1(16-09)min3.png")));
		label_1.setBounds(145, 31, 193, 101);
		label_1.setForeground(new Color(220, 220, 220));
		label_1.setFont(new Font("Calibri Light", Font.BOLD, 30));
		panel.add(label_1);

		JLabel lblUsurio = new JLabel("Usuário");
		lblUsurio.setForeground(new Color(220, 220, 220));
		lblUsurio.setFont(new Font("Calibri Light", Font.BOLD, 20));
		lblUsurio.setBounds(208, 143, 68, 26);
		panel.add(lblUsurio);

		txtUsuario = new JTextField();
		txtUsuario.setFont(new Font("Calibri Light", Font.PLAIN, 20));
		txtUsuario.setBounds(101, 168, 282, 20);
		panel.add(txtUsuario);
		txtUsuario.setColumns(10);

		JLabel lblSenha = new JLabel("Senha");
		lblSenha.setForeground(new Color(220, 220, 220));
		lblSenha.setFont(new Font("Calibri Light", Font.BOLD, 20));
		lblSenha.setBounds(215, 207, 53, 20);
		panel.add(lblSenha);

		txtSenha = new JPasswordField();
		txtSenha.setFont(new Font("Calibri Light", Font.PLAIN, 20));
		txtSenha.setBounds(101, 228, 282, 20);
		panel.add(txtSenha);

		JButton btnEntrar = new JButton("Entrar");
		btnEntrar.addActionListener(btnEntrarActionPerformed());
		btnEntrar.setFont(new Font("Calibri Light", Font.PLAIN, 15));
		btnEntrar.setBounds(265, 284, 118, 31);
		panel.add(btnEntrar);

		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(btnCancelarActionPerformed());
		btnCancelar.setFont(new Font("Calibri Light", Font.PLAIN, 15));
		btnCancelar.setBounds(101, 284, 118, 31);
		panel.add(btnCancelar);

		centralizarComponente();
	}

	public void centralizarComponente() {
		Dimension ds = Toolkit.getDefaultToolkit().getScreenSize();
		Dimension dw = getSize();
		setLocation((ds.width - dw.width) / 2, (ds.height - dw.height) / 2);
	}

	protected ActionListener btnCancelarActionPerformed() {
		return new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Mensagem.confirmaSaidaDoPrograma();
			}
		};
	}

	protected ActionListener btnEntrarActionPerformed() {
		return new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				autenticaUsuario();
			}
		};
	}

	protected boolean validaCampos() {
		return (!txtUsuario.getText().isEmpty() && !txtSenha.getText().isEmpty());
	}

	protected void autenticaUsuario() {
		if (validaCampos()) {
			try {
				if (uDao.autentica(txtUsuario.getText(), txtSenha.getText())) {
					this.chamaMenuPrincipal(uDao.get(new Usuario(txtUsuario.getText(), txtSenha.getText())));
				} else {
					JOptionPane.showMessageDialog(null, "Usuário ou senha incorretos.");
				}
			} catch (SQLException e) {
				JOptionPane.showMessageDialog(getParent(), "Algo aconteceu.\nDetalhes: " + e.getMessage());
			}
		} else {
			JOptionPane.showMessageDialog(null, "Preencha os campos obrigatórios antes de continuar.");
		}
	}

	protected void chamaMenuPrincipal(Usuario usuario) throws SQLException {
		ConnectionFactory.setUsuarioConectado(usuario);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		FrmMenuPrincipal menuPrincipal = new FrmMenuPrincipal();
		menuPrincipal.configPermissoes(usuario);
		menuPrincipal.setVisible(true);
		dispose();
	}
}
