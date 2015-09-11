package br.com.estatistica.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import javax.swing.JOptionPane;

import br.com.estatistica.modelos.Pergunta;

	public class PerguntaDAO extends GenericDAO<Pergunta> {
		private static final String SQL_SELECT = "SELECT * FROM Usuario";
		private static final String SQL_SELECT_WHERE = SQL_SELECT + " WHERE login = ? AND senha = ?";
		private static final String SQL_SELECT_BY_ID = SQL_SELECT + " WHERE id_usuario = ?";
		private static final String SQL_SELECT_BY_LOGIN = SQL_SELECT + " WHERE login = ?";
		private static final String SQL_SELECT_BY_LOGIN_AND_SENHA = SQL_SELECT_BY_LOGIN + " AND senha = ?";
		private static final String SQL_INSERT = "INSERT INTO Pergunta(descricao,observacao,questionario,tipopergunta, tipocampo) VALUES(?,?,?,?)";
		private static final String SQL_UPDATE = "UPDATE Usuario SET login = ?, senha = ?, descricao = ?, id_perfil_usuario = ? WHERE id_usuario =?";
		private static final String SQL_DELETE = "DELETE FROM Usuario WHERE id_usuario = ?";
		
		public PerguntaDAO(Connection connection) {
			super(connection);
			
		}

		@Override
		protected void insert(Pergunta model) throws SQLException {
			try (PreparedStatement pst = super.getConnection().prepareStatement(SQL_INSERT)) {
				pst.setString(1, model.getDescricao());
				pst.setString(2, model.getObservacao());
				pst.setString(3, model.getQuestionario());
				pst.set(4, model.getTipoPergunta());
				pst.set(5, model.getTipoCampo());
				pst.executeUpdate();
			}
		}
			
		

		@Override
		protected void update(Pergunta model) throws SQLException {
			try (PreparedStatement pst = super.getConnection().prepareStatement(SQL_UPDATE)) {
			pst.executeUpdate();
			}
				}

		@Override
		public void delete(Pergunta model) throws SQLException {
			if (model.getId() != null) {
				try (PreparedStatement pst = super.getConnection().prepareStatement(SQL_DELETE)) {
					pst.setInt(1, model.getId());
					int linhasAfetadas = pst.executeUpdate();
					if (linhasAfetadas > 0) {
						JOptionPane.showMessageDialog(null, "Excluído com sucesso.");
					}
				}
			}
		}
			
		}

		@Override
		public List<Pergunta> getAll() throws SQLException {
			
			return null;
		}

		@Override
		public Pergunta get(Pergunta model) throws SQLException {
			
			return null;
		}

		@Override
		public Pergunta get(Integer idModel) throws SQLException {
		
			return null;
		}

		@Override
		public Pergunta get(String value) throws SQLException {
			
			return Pergunta;
		}

		@Override
		public boolean isExist(Pergunta model) throws SQLException {
			
			return false;
		}

		@Override
		public boolean isExist(Integer idModel) throws SQLException {
			
			return false;
		}
		
	}

		