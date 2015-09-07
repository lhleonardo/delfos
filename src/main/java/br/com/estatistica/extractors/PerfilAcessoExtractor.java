package br.com.estatistica.extractors;

import java.sql.Connection;
import java.sql.ResultSet;
import java.util.List;

import br.com.estatistica.modelos.PerfilAcesso;

public class PerfilAcessoExtractor implements Extractable<PerfilAcesso> {

	@Override
	public PerfilAcesso extract(ResultSet rs, Connection con) {
		// TODO: Preparar a extração do perfil de acesso.
		return null;
	}

	@Override
	public List<PerfilAcesso> extractAll(ResultSet rs, Connection con) {
		// TODO Auto-generated method stub
		return null;
	}

}
