package br.com.fiap.teste;

import java.sql.Connection;
import java.util.ArrayList;

import br.com.fiap.beans.Pergunta;
import br.com.fiap.conexao.Conexao;
import br.com.fiap.dao.PerguntaDAO;

public class PerguntaSelecionar {

	public static void main(String[] args) {

		Connection con = Conexao.abrirConexao();

		PerguntaDAO perguntadao = new PerguntaDAO(con);

		//Execultando o método Selecionar
		ArrayList<Pergunta> lista = perguntadao.retornarDados();

		if (lista != null) {
			for (Pergunta c : lista) {
				System.out.println("Titulo: " + c.getTitulo() + "\n");
				System.out.println("Texto: " + c.getTexto() + "\n");
				System.out.println("Data de postagem: " + c.getData() + "\n");
			}
		}

		Conexao.fecharConexao(con);

	}

}
