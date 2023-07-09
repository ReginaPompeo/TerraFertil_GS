package br.com.fiap.teste;

import java.sql.Connection;

import br.com.fiap.beans.Doacao;
import br.com.fiap.conexao.Conexao;
import br.com.fiap.dao.DoacaoDAO;

public class DoacaoAlterar {

	public static void main(String[] args) {

		Connection con = Conexao.abrirConexao();

		Doacao doacao = new Doacao();

		DoacaoDAO doacaodao = new DoacaoDAO(con);

		// Testando o método alterar
		doacao.setQuantidade(20.0);
		doacao.setNome("Patricia Avelar");

		System.out.println(doacaodao.alterar(doacao));
		Conexao.fecharConexao(con);

	}
}
