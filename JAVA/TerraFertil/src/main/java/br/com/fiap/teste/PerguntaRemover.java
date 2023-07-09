package br.com.fiap.teste;

import java.sql.Connection;

import br.com.fiap.beans.Pergunta;
import br.com.fiap.conexao.Conexao;
import br.com.fiap.dao.PerguntaDAO;


public class PerguntaRemover {
	public static void main(String[] args) {
		Connection con = Conexao.abrirConexao();

		Pergunta pergunta = new Pergunta();
		PerguntaDAO perguntadao = new PerguntaDAO(con);

		// Testando o método deletar
		pergunta.setTitulo("Titulo Teste");

		System.out.println(perguntadao.deletar(pergunta));

		Conexao.fecharConexao(con);
	}
}
