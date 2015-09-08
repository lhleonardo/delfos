package br.com.estatistica.extractors;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import br.com.estatistica.dao.PermissoesAcessoDAO;
import br.com.estatistica.modelos.PerfilAcesso;

public class PerfilAcessoExtractor extends Extractable<PerfilAcesso> {

	protected PerfilAcesso extractModel(ResultSet rs, Connection connection) throws SQLException {
		PerfilAcesso perfil = new PerfilAcesso();
		perfil.setId(rs.getInt("id_perfil_acesso"));
		perfil.setDescricao(rs.getString("descricao"));
		perfil.setNome(rs.getString("nome"));

		try (PermissoesAcessoDAO pDao = new PermissoesAcessoDAO(connection)) {
			perfil.setPermissoes(pDao.getAll(perfil));
		}

		return perfil;
	}

}
