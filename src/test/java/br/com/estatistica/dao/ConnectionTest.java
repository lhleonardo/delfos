package br.com.estatistica.dao;


import java.awt.EventQueue;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;



import br.com.estatistica.modelos.table.TableModelPesquisa;
import br.com.estatistica.util.ConnectionFactory;
import br.com.estatistica.modelos.Pesquisa;

public class ConnectionTest extends JFrame {
	
//		Connection con = new ConnectionFactory().getConnection();
//		PesquisaDAO pesqDAO = new PesquisaDAO(con);
//		try {
//			List<Pesquisa> listaDePesquisas = pesqDAO.getAll();
//			for(int i = 0; i<listaDePesquisas.size(); i++){
//			System.out.println(listaDePesquisas.get(i).getNome());
//			}
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		
		 private JTable tblSocios;
		    private TableModelPesquisa tableModel;
		    private Connection con = new ConnectionFactory().getConnection();
		    private PesquisaDAO pesquisaDAO = new PesquisaDAO(con);
		     
		    public ConnectionTest() {
		        super("SocioTableModelTest");
		        initialize();
		    }
		 
		    private void initialize() {
		        setSize(400, 150);
		        setDefaultCloseOperation(EXIT_ON_CLOSE);
		        getContentPane().add(new JScrollPane(getTblSocios()));
		    }
		 
		    private JTable getTblSocios() {
		        if (tblSocios == null) {
		            tblSocios = new JTable();
		            tblSocios.setModel(getTableModel());
		        }
		        return tblSocios;
		    }
		 
		    private TableModelPesquisa getTableModel() {
		        if (tableModel == null) {
		            try {
						tableModel = new TableModelPesquisa(pesquisaDAO.getAll());
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
		        }
		        return tableModel;
		    }
		 
		    // cria uma lista com 5 sócios meramente ilustrativos
		    private List<Pesquisa> criaSocios() {
		        List<Pesquisa> socios = new ArrayList<Pesquisa>();
		        for (int i = 1; i <= 5; i++) {
		        	Pesquisa socio = new Pesquisa();
		            socio.setNome("Nome" + i);
		            Date data = new Date();
		            data.getTime();
		            socio.setData(data);
		            socios.add(socio);
		        }
		        return socios;
		    }
		 
		    public static void main(String[] args) {
		        EventQueue.invokeLater(new Runnable() {
		            @Override
		            public void run() {
		                new ConnectionTest().setVisible(true);
		            }
		        });
		    }
		
		
		
	}


