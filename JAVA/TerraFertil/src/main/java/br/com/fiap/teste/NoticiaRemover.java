package br.com.fiap.teste;

import java.sql.Connection;

import br.com.fiap.beans.Noticia;
import br.com.fiap.conexao.Conexao;
import br.com.fiap.dao.NoticiaDAO;


public class NoticiaRemover {

	public static void main(String[] args) {

		Connection con = Conexao.abrirConexao();

		Noticia noticia = new Noticia();
		NoticiaDAO noticiadao = new NoticiaDAO(con);

		// Testando o método deletar
		noticia.setTitulo("Titulo Teste");
		
		System.out.println(noticiadao.deletar(noticia));

		Conexao.fecharConexao(con);
	}
}
