package br.com.fiap.teste;

import java.sql.Connection;

import br.com.fiap.beans.Resposta;
import br.com.fiap.conexao.Conexao;
import br.com.fiap.dao.RespostaDAO;


public class RespostaRemover {
	public static void main(String[] args) {

		Connection con = Conexao.abrirConexao();

		Resposta resposta = new Resposta();

		RespostaDAO respostadao = new RespostaDAO(con);

		// Testando o método deletar
		resposta.setData("06-06-2023");

		System.out.println(respostadao.deletar(resposta));

		Conexao.fecharConexao(con);
	}
}
