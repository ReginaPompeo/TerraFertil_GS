package br.com.fiap.teste;

import java.sql.Connection;

import br.com.fiap.beans.Doacao;
import br.com.fiap.conexao.Conexao;
import br.com.fiap.dao.DoacaoDAO;

public class DoacaoCadastrar {
	
	public static void main(String[] args) {

		Connection con = Conexao.abrirConexao();

		Doacao doacao = new Doacao();

		DoacaoDAO doacaodao = new DoacaoDAO(con);

	
		// Método inserir

		doacao.setNome("NomeTeste");
		doacao.setQuantidade(10);
		

		System.out.println(doacaodao.inserir(doacao));

		Conexao.fecharConexao(con);
	}
}
