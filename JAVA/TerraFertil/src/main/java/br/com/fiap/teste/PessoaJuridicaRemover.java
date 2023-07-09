package br.com.fiap.teste;

import java.sql.Connection;

import br.com.fiap.beans.PessoaJuridica;
import br.com.fiap.conexao.Conexao;
import br.com.fiap.dao.PessoaJuridicaDAO;

public class PessoaJuridicaRemover {

	public static void main(String[] args) {
		
		Connection con = Conexao.abrirConexao();

		PessoaJuridica pessoaJuridica = new PessoaJuridica();
		PessoaJuridicaDAO pessoaJuridicadao = new PessoaJuridicaDAO(con);

		// Testando o método deletar
		pessoaJuridica.setCnpj("12345678910234");
		System.out.println(pessoaJuridicadao.deletar(pessoaJuridica));

		Conexao.fecharConexao(con);

	}

}
