package br.com.fiap.teste;

import java.sql.Connection;
import java.util.ArrayList;
import br.com.fiap.beans.PessoaFisica;
import br.com.fiap.conexao.Conexao;
import br.com.fiap.dao.PessoaFisicaDAO;

public class PessoaFisicaSelecionar {

	public static void main(String[] args) {

		Connection con = Conexao.abrirConexao();

		PessoaFisicaDAO pessoaFisicadao = new PessoaFisicaDAO(con);

		// Método Selecionar
		ArrayList<PessoaFisica> lista = pessoaFisicadao.retornarDados();

		if (lista != null) {
			for (PessoaFisica c : lista) {
				System.out.println("Nome: " + c.getNome() + "\n");
				System.out.println("Email: " + c.getEmail() + "\n");
				System.out.println("Cpf: " + c.getCpf() + "\n");
				System.out.println("CEP: " + c.getCep() + "\n");
				System.out.println("Telefone de contato: " + c.getCelular() + "\n");
			}
		}

		Conexao.fecharConexao(con);
	}
}