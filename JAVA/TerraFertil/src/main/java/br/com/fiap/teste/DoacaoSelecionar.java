package br.com.fiap.teste;

import java.sql.Connection;
import java.util.ArrayList;

import br.com.fiap.beans.Doacao;
import br.com.fiap.conexao.Conexao;
import br.com.fiap.dao.DoacaoDAO;

public class DoacaoSelecionar {
	public static void main(String[] args) {

		Connection con = Conexao.abrirConexao();

		Doacao doacao = new Doacao();

		DoacaoDAO doacaodao = new DoacaoDAO(con);

		// Método Selecionar
		ArrayList<Doacao> lista = doacaodao.retornarDados();

		if (lista != null) {
			for (Doacao d : lista) {
				System.out.println("Id: " + d.getId() + "\n");
				System.out.println("Nome: " + d.getNome() + "\n");
				System.out.println("Quantidade Doação: " + d.getQuantidade() + "\n");
			}
		}

		Conexao.fecharConexao(con);
	}
}
