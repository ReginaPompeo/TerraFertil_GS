package br.com.fiap.teste;

import java.sql.Connection;

import br.com.fiap.beans.Noticia;
import br.com.fiap.conexao.Conexao;
import br.com.fiap.dao.NoticiaDAO;



public class NoticiaCadastrar {

	public static void main(String[] args) {

		Connection con = Conexao.abrirConexao();

		Noticia noticia = new Noticia();

		NoticiaDAO noticiadao = new NoticiaDAO(con);

	
		// Método inserir

		noticia.setTitulo("Titulo Teste");
		noticia.setTexto("Texto Teste");
		noticia.setData("05-09-2003");
		
	

		System.out.println(noticiadao.inserir(noticia));

		Conexao.fecharConexao(con);
	}
}