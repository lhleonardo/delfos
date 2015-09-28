/**
 * Classe PessoaTest.java
 *
 * @author Leonardo Braz
 */
package br.com.estatistica.dao;

import java.sql.SQLException;

import br.com.estatistica.modelos.Bairro;
import br.com.estatistica.modelos.Cidade;
import br.com.estatistica.modelos.Cpf;
import br.com.estatistica.modelos.Endereco;
import br.com.estatistica.modelos.Pessoa;
import br.com.estatistica.modelos.TipoLogradouro;
import br.com.estatistica.util.ConnectionFactory;
import br.com.estatistica.util.Mensagem;

/**
 * @author Leonardo Braz
 *
 */
public class PessoaTest {

	public static void main(String[] args) {
		try {
			PessoaDAO pDao = new PessoaDAO(new ConnectionFactory().getConnection());
			Pessoa p = pDao.get(cadastraPessoa(pDao));
			Mensagem.informa(null, "");
			p.setDescricao("Mudei a descrição da pessoa.");
			Endereco endereco = p.getEndereco();
			endereco.setDescricao("Nova descrição do endereço da pessoa");
			p.setEndereco(endereco);
			pDao.save(p);
		} catch (SQLException ex) {
			Mensagem.erro(null, ex);
		}
		
	}
	
	/**
	 * @param pDao
	 * @throws SQLException
	 */
	private static Integer cadastraPessoa(PessoaDAO pDao) throws SQLException {
		Pessoa pessoa = new Pessoa();
		pessoa.setNome("Leonardo Henrique de Braz");
		pessoa.setRg("12345123");
		pessoa.setTipoDocumento(new Cpf("01327621290"));
		pessoa.setEmail("lhleonardo@hotmail.com");

		Endereco enderecoDoLeonardo = new Endereco();
		enderecoDoLeonardo.setLogradouro("Sena Madureira");
		enderecoDoLeonardo.setCep("81823812831");
		enderecoDoLeonardo.setNumero("12313");
		Bairro b = new Bairro();
		b.setId(5);
		enderecoDoLeonardo.setBairro(b);
		Cidade c = new Cidade();
		c.setId(21);
		enderecoDoLeonardo.setCidade(c);
		TipoLogradouro l = new TipoLogradouro();
		l.setId(1);
		enderecoDoLeonardo.setTipoLogradouro(l);
		
		pessoa.setEndereco(enderecoDoLeonardo);
		
		return pDao.save(pessoa);
		
	}
}
