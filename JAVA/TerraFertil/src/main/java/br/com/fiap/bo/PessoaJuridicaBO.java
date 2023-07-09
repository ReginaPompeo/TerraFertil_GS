package br.com.fiap.bo;

import java.sql.Connection;
import br.com.fiap.beans.PessoaJuridica;
import br.com.fiap.conexao.Conexao;
import br.com.fiap.dao.PessoaJuridicaDAO;


public class PessoaJuridicaBO {

	Connection con = Conexao.abrirConexao();

	PessoaJuridicaDAO pessoaJuridicadao = new PessoaJuridicaDAO(con);

	// regra de negócio - Business Object
	public void inserirBO(PessoaJuridica pessoaJuridica) throws Excecao {
		if ((pessoaJuridica.getCnpj().length() > 14) || (pessoaJuridica.getCep().length() > 8) || 
			    (pessoaJuridica.getSenha().length() < 8)) {
				System.out.println("Quantidade de caracteres " + "do cpf/cep/senha" + " não atende o mínimo");
		} else {
			pessoaJuridica.setCnpj(pessoaJuridica.getCnpj());
			pessoaJuridica.setCep(pessoaJuridica.getCep());
			pessoaJuridica.setSenha(pessoaJuridica.getSenha());
			System.out.println(pessoaJuridicadao.inserir(pessoaJuridica));
		}
	}
}