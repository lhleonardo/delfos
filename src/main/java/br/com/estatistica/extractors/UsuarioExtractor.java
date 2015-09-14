package br.com.estatistica.extractors;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import br.com.estatistica.dao.PerfilAcessoDAO;
import br.com.estatistica.modelos.Usuario;

public class UsuarioExtractor extends Extractable<Usuario> {

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
		} else {
			throw new IllegalArgumentException("Parece que o usuário " + usu.getLogin()
			        + "  não possui um perfil de acesso válido. \nContate o administrador para resolver esse problema.");
		}

		return usu;
	}

}
