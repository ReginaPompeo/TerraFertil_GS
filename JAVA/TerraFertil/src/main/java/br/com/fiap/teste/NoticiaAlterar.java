package br.com.fiap.teste;

import java.sql.Connection;

import br.com.fiap.beans.Noticia;
import br.com.fiap.conexao.Conexao;
import br.com.fiap.dao.NoticiaDAO;

public class NoticiaAlterar {
	public static void main(String[] args) {
		Connection con = Conexao.abrirConexao();

		Noticia noticia = new Noticia();
		NoticiaDAO noticiadao = new NoticiaDAO(con);

		// Testando o método alterar
		noticia.setTexto("TextoTesteCRUD");
		noticia.setTitulo("titulo11");

		System.out.println(noticiadao.alterar(noticia));

		Conexao.fecharConexao(con);
	}

}
