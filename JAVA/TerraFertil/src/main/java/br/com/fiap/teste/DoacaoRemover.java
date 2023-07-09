package br.com.fiap.teste;

import java.sql.Connection;

import br.com.fiap.beans.Doacao;
import br.com.fiap.conexao.Conexao;
import br.com.fiap.dao.DoacaoDAO;

public class DoacaoRemover {

	public static void main(String[] args) {

		Connection con = Conexao.abrirConexao();

		Doacao doacao = new Doacao();

		DoacaoDAO doacaodao = new DoacaoDAO(con);
		// Testando o método deletar
		doacao.setNome("Patricia Avelar");

		System.out.println(doacaodao.deletar(doacao));

		Conexao.fecharConexao(con);
	}
}


