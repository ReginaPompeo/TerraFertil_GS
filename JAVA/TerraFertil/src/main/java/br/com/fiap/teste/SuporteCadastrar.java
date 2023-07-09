package br.com.fiap.teste;

import java.io.IOException;
import java.sql.Connection;

import org.apache.http.client.ClientProtocolException;

import br.com.fiap.beans.Suporte;
import br.com.fiap.bo.Excecao;
import br.com.fiap.bo.SuporteBO;
import br.com.fiap.conexao.Conexao;

public class SuporteCadastrar {
	
	public static void main(String[] args) throws Excecao, ClientProtocolException, IOException {

		Connection con = Conexao.abrirConexao();

		Suporte suporte = new Suporte();
		
		SuporteBO suportebo = new SuporteBO();

	
		// Método inserir

		suporte.setNomeCompleto("Regina");
		suporte.setEmail("regina");
		suporte.setTexto("Teste");
		
		suportebo.inserirBO(suporte);

		Conexao.fecharConexao(con);
	}
}

