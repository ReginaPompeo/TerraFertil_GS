package br.com.fiap.teste;

import java.sql.Connection;
import java.util.ArrayList;

import br.com.fiap.beans.Noticia;
import br.com.fiap.conexao.Conexao;
import br.com.fiap.dao.NoticiaDAO;


public class NoticiaSelecionar {

	public static void main(String[] args) {

		Connection con = Conexao.abrirConexao();

		NoticiaDAO noticiadao = new NoticiaDAO(con);

		// Método Selecionar
		ArrayList<Noticia> lista = noticiadao.retornarDados();

		if (lista != null) {
			for (Noticia n : lista) {
				System.out.println("Título: " + n.getTitulo() + "\n");
				System.out.println("Texto: " + n.getTexto() + "\n");
				System.out.println("Data: " + n.getData() + "\n");
				}
		}

		Conexao.fecharConexao(con);
	}
}
