package br.com.fiap.teste;

import java.sql.Connection;
import java.util.ArrayList;

import br.com.fiap.beans.Resposta;
import br.com.fiap.conexao.Conexao;
import br.com.fiap.dao.RespostaDAO;


public class RespostaSelecionar {
	public static void main(String[] args) {

		Connection con = Conexao.abrirConexao();

		RespostaDAO respostadao = new RespostaDAO(con);

		// Método Selecionar
		ArrayList<Resposta> lista = respostadao.retornarDados();

		if (lista != null) {
			for (Resposta r : lista) {
				System.out.println("Texto: " + r.getTexto() + "\n");
				System.out.println("Data: " + r.getData() + "\n");
				System.out.println("Aceitação: " + r.getAceitacao() + "\n");
			}
		}

		Conexao.fecharConexao(con);
	}
}
