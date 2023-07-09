package br.com.fiap.bo;

import java.sql.Connection;

import br.com.fiap.beans.Suporte;
import br.com.fiap.conexao.Conexao;
import br.com.fiap.dao.SuporteDAO;


public class SuporteBO {

	Connection con = Conexao.abrirConexao();

	SuporteDAO suportedao = new SuporteDAO(con);


	// regra de negócio - Business Object
	public void inserirBO(Suporte suporte) throws Excecao {
		if ((suporte.getNomeCompleto().length() < 3) || (suporte.getEmail().length() < 3) || 
		    (suporte.getTexto().length() < 3)) {
			System.out.println("Quantidade de caracteres " +  " não atende o mínimo");
		} else {
			suporte.setNomeCompleto(suporte.getNomeCompleto());
			suporte.setEmail(suporte.getEmail());
			suporte.setTexto(suporte.getTexto());
			System.out.println(suportedao.inserir(suporte));
		}
	}
}
