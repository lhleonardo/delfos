package br.com.estatistica.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.estatistica.modelo.Pesquisador;
import br.com.estatistica.util.Mensagem;

public class PesquisadorDAO implements DAO<Pesquisador> {

	private static final String SQL_INSERT = "INSERT INTO pesquisador(nome, cpf, rg, dataNascimento) values(?,?,?,?);";
	private static final String SQL_UPDATE = "UPDATE pesquisador SET nome = ?, cpf = ?, rg = ?, dataNascimento = ? where idPesquisador = ?";
	private static final String SQL_DELETE = "DELETE FROM pesquisador WHERE idPesquisador = ?";
	private static final String SQL_SELECT = "SELECT * FROM pesquisador";

	@Override
	public void save(Pesquisador modelo) throws SQLException, NullPointerException {
		if (modelo == null) {
			throw new NullPointerException("Nenhum valor foi informado para salvar.");
		}

		if (modelo.getId() == null) {
			try (Connection con = new ConnectionFactory().getConnection()) {
				boolean op = insert(modelo, con);
				Mensagem.informa((op) ? "Salvo com sucesso"
				        : "Falha desconhecida, operação cancelada...\nCaso persista, entre em contato com o administrador.");
			}
		} else if (modelo.getId() != null) {
			try (Connection con = new ConnectionFactory().getConnection()) {
				boolean op = update(modelo, con);
				Mensagem.informa((op) ? "Salvo com sucesso"
				        : "Falha desconhecida, operação cancelada...\nCaso persista, entre em contato com o administrador.");
			}
		}

	}

	private boolean update(Pesquisador modelo, Connection con) throws SQLException {
		PreparedStatement pst = con.prepareStatement(SQL_UPDATE);
		pst.setString(1, modelo.getNome());
		pst.setString(2, modelo.getTipoDocumento().getValor());
		pst.setString(3, modelo.getRg());
		pst.setDate(4, new Date(modelo.getDataNascimento().getTime()));
		return pst.execute();
	}

	private boolean insert(Pesquisador modelo, Connection con) throws SQLException {
		PreparedStatement pst = con.prepareStatement(SQL_INSERT);
		pst.setString(1, modelo.getNome());
		pst.setString(2, modelo.getTipoDocumento().getValor());
		pst.setString(3, modelo.getRg());
		pst.setDate(4, new Date(modelo.getDataNascimento().getTime()));
		return pst.execute();
	}

	@Override
	public void remove(Pesquisador modelo) throws SQLException, NullPointerException {
		if (modelo == null) {
			throw new NullPointerException("Nenhum valor foi informado para a exclusão.");
		}

		Pesquisador pesquisa = findById(modelo.getId());
		if (pesquisa != null) {
			try (Connection con = new ConnectionFactory().getConnection()) {
				PreparedStatement pst = con.prepareStatement(SQL_DELETE);
				pst.setInt(1, modelo.getId());
				boolean op = pst.execute();
				Mensagem.informa((op) ? "Excluído com sucesso"
				        : "Falha desconhecida, operação cancelada...\nCaso persista, entre em contato com o administrador.");

			}
		}

	}

	@Override
	public List<Pesquisador> getAll() throws SQLException {
		ArrayList<Pesquisador> filtro = new ArrayList<>();

		try (Connection con = new ConnectionFactory().getConnection()) {
			PreparedStatement pst = con.prepareStatement(SQL_SELECT);
			pst.execute();

			ResultSet rs = pst.getResultSet();

			PesquisadorExtractor extractor = new PesquisadorExtractor();

			while (rs.next()) {
				Pesquisador pesquisador = extractor.extract(rs);
				filtro.add(pesquisador);
			}
		}
		return filtro;
	}

	@Override
	public List<Pesquisador> getByNome(String nome) throws SQLException {
		ArrayList<Pesquisador> filtro = new ArrayList<>();

		try (Connection con = new ConnectionFactory().getConnection()) {
			String consulta = SQL_SELECT + "where nome like '?%'";
			PreparedStatement pst = con.prepareStatement(consulta);
			pst.setString(1, nome);
			pst.execute();

			ResultSet rs = pst.getResultSet();

			PesquisadorExtractor extractor = new PesquisadorExtractor();

			while (rs.next()) {
				Pesquisador pesquisador = extractor.extract(rs);
				filtro.add(pesquisador);
			}
		}
		return filtro;
	}

	@Override
	public Pesquisador findById(Integer id) throws SQLException {
		try (Connection con = new ConnectionFactory().getConnection()) {
			String consulta = SQL_SELECT + "where idPesquisador = ?";
			PreparedStatement pst = con.prepareStatement(consulta);
			pst.setInt(1, id);
			pst.execute();

			ResultSet rs = pst.getResultSet();

			PesquisadorExtractor extractor = new PesquisadorExtractor();

			while (rs.next()) {
				return extractor.extract(rs);
			}
		}
		return null;
	}

	@Override
	public void init() {

	}

}
