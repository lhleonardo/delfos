package br.com.estatistica.extractors;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import br.com.estatistica.dao.PerfilAcessoDAO;
import br.com.estatistica.modelos.Usuario;

public class UsuarioExtractor extends Extractable<Usuario> {

	private PerfilAcessoDAO pDao;
	
	@Override
	protected Usuario extractModel(ResultSet rs, Connection con) throws SQLException {
		Usuario usu = new Usuario();
		usu.setId(rs.getInt("id_usuario"));
		usu.setLogin(rs.getString("login"));
		usu.setSenha(rs.getString("senha"));
		usu.setDescricao(rs.getString("descricao"));

		this.pDao = new PerfilAcessoDAO(con);
		usu.setPerfilAcesso(this.pDao.get(rs.getInt("id_perfil_acesso")));

		return usu;
	}

}
