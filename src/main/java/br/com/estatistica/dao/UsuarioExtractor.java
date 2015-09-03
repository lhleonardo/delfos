package br.com.estatistica.dao;

import java.sql.Connection;
import java.sql.ResultSet;

import br.com.estatistica.modelo.cadastro.PerfilAcesso;
import br.com.estatistica.modelo.cadastro.Pessoa;
import br.com.estatistica.modelo.cadastro.Usuario;

public class UsuarioExtractor {

	public static Usuario extract(ResultSet rs, Connection con) {

		PerfilAcesso perfilAcesso = new PerfilAcessoDAO(con).getById(rs.getInt("id_perfil_acesso"));
		Pessoa pessoa = new PessoaDAO(con).getById(rs.getInt("id_pessoa"));
		return new Usuario(rs.getInt("id"), rs.getString("login"), rs.getString("descricao"), perfilAcesso, pessoa);
	}

}
