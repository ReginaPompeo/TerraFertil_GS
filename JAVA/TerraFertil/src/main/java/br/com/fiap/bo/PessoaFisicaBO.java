package br.com.fiap.bo;

import java.sql.Connection;
import br.com.fiap.beans.PessoaFisica;
import br.com.fiap.conexao.Conexao;

import br.com.fiap.dao.PessoaFisicaDAO;

public class PessoaFisicaBO {

	Connection con = Conexao.abrirConexao();

	PessoaFisicaDAO pessoaFisicadao = new PessoaFisicaDAO(con);


	// regra de negócio - Business Object
	public void inserirBO(PessoaFisica pessoaFisica) throws Excecao {
		if ((pessoaFisica.getCpf().length() > 11) || (pessoaFisica.getCep().length() > 8) || 
		    (pessoaFisica.getSenha().length() < 8)) {
			System.out.println("Quantidade de caracteres " + "do cpf/cep/senha" + " não atende o mínimo");
		} else {
			pessoaFisica.setCpf(pessoaFisica.getCpf());
			pessoaFisica.setCep(pessoaFisica.getCep());
			pessoaFisica.setSenha(pessoaFisica.getSenha());
			System.out.println(pessoaFisicadao.inserir(pessoaFisica));
		}
	}
}