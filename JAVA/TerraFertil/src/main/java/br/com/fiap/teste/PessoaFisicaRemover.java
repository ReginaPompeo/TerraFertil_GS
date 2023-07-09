package br.com.fiap.teste;

import java.sql.Connection;
import br.com.fiap.beans.PessoaFisica;
import br.com.fiap.conexao.Conexao;
import br.com.fiap.dao.PessoaFisicaDAO;


public class PessoaFisicaRemover {

	public static void main(String[] args) {

		Connection con = Conexao.abrirConexao();

		PessoaFisica pessoaFisica = new PessoaFisica();
		PessoaFisicaDAO pessoaFisicadao = new PessoaFisicaDAO(con);

		// Testando o método deletar
		pessoaFisica.setCpf("47553265832");
		
		System.out.println(pessoaFisicadao.deletar(pessoaFisica));

		Conexao.fecharConexao(con);
	}
}
