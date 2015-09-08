package br.com.estatistica.extractors;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.estatistica.dao.PerfilAcessoDAO;
import br.com.estatistica.modelos.Usuario;

public class UsuarioExtractor extends Extractable<Usuario> {

	public Usuario extract(ResultSet rs, Connection con) throws SQLException {
		if (rs.next()) {
			return extractModel(rs, con);
		} else
			return null;
	}

	@Override
	protected Usuario extractModel(ResultSet rs, Connection con) throws SQLException {
		Usuario usu = new Usuario();
		usu.setId(rs.getInt("id_usuario"));
		usu.setLogin(rs.getString("login"));
		usu.setSenha(rs.getString("senha"));
		usu.setDescricao(rs.getString("descricao"));

		if ((Integer) rs.getInt("id_perfil_acesso") != null) {
			try (PerfilAcessoDAO dao = new PerfilAcessoDAO(con)) {
				usu.setPerfilAcesso(dao.get(rs.getInt("id_perfil_acesso")));
			}
		}

		return usu;
	}

	@Override
	public List<Usuario> extractAll(ResultSet rs, Connection con) throws SQLException {
		List<Usuario> usuarios = new ArrayList<Usuario>();

		while (rs.next() && con != null) {
			usuarios.add(extractModel(rs, con));
		}

		return usuarios;
	}

}
