package br.com.fiap.teste;

import java.sql.Connection;

import br.com.fiap.beans.Resposta;
import br.com.fiap.conexao.Conexao;
import br.com.fiap.dao.RespostaDAO;


public class RespostaCadastrar {

	public static void main(String[] args) {

		Connection con = Conexao.abrirConexao();

		Resposta resposta = new Resposta();

		RespostaDAO respostadao = new RespostaDAO(con);

	
		// Método inserir

		resposta.setTexto("Texto Teste");
		resposta.setData("06-06-2023");
		resposta.setAceitacao(false);
		

		System.out.println(respostadao.inserir(resposta));

		Conexao.fecharConexao(con);
	}
}
