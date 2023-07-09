package br.com.fiap.teste;

import java.sql.Connection;

import br.com.fiap.beans.Resposta;
import br.com.fiap.conexao.Conexao;
import br.com.fiap.dao.RespostaDAO;


public class RespostaAlterar {

	public static void main(String[] args) {

		Connection con = Conexao.abrirConexao();

		Resposta resposta = new Resposta();

		RespostaDAO respostadao = new RespostaDAO(con);

		// Testando o método alterar
		resposta.setTexto("TextoTeste2");
		resposta.setData("06-06-2023");

		System.out.println(respostadao.alterar(resposta));
		Conexao.fecharConexao(con);

	}
}
