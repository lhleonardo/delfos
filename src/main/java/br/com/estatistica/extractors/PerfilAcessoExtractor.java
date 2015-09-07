package br.com.estatistica.extractors;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.estatistica.dao.PermissoesAcessoDAO;
import br.com.estatistica.modelos.PerfilAcesso;

public class PerfilAcessoExtractor implements Extractable<PerfilAcesso> {

	@Override
	public PerfilAcesso extract(ResultSet rs, Connection con) throws SQLException {
		PerfilAcesso perfil = new PerfilAcesso();

		if (rs.next() && con != null) {
			perfil.setId(rs.getInt("id_perfil_acesso"));
			perfil.setDescricao(rs.getString("descricao"));
			perfil.setNome(rs.getString("nome"));

			try (PermissoesAcessoDAO pDao = new PermissoesAcessoDAO(con)) {
				perfil.setPermissoes(pDao.getAll(perfil));
			}

			return perfil;
		} else {
			return null;
		}

	}

	@Override
	public List<PerfilAcesso> extractAll(ResultSet rs, Connection con) throws SQLException {
		List<PerfilAcesso> perfis = new ArrayList<PerfilAcesso>();

		while (rs.next() && con != null) {
			PerfilAcesso perfil = this.extract(rs, con);
			if (perfil != null) {
				perfis.add(perfil);
			}
		}

		return perfis;
	}

}
