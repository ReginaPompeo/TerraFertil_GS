package br.com.fiap.teste;

import java.sql.Connection;

import br.com.fiap.beans.Pergunta;
import br.com.fiap.conexao.Conexao;
import br.com.fiap.dao.PerguntaDAO;


public class PerguntaCadastrar {
	public static void main(String[] args) {

		Connection con = Conexao.abrirConexao();

		Pergunta pergunta = new Pergunta();

		PerguntaDAO perguntadao = new PerguntaDAO(con);

	
		// Método inserir

		pergunta.setTitulo("Titulo Teste");
		pergunta.setTexto("Texto Teste");
		pergunta.setData("05-09-2003");
		
	

		System.out.println(perguntadao.inserir(pergunta));

		Conexao.fecharConexao(con);
	}
}
