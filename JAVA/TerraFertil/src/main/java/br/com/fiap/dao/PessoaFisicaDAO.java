package br.com.fiap.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import br.com.fiap.beans.PessoaFisica;

public class PessoaFisicaDAO {

	private Connection con;

	public final Connection getCon() {
		return con;
	}

	public final void setCon(Connection con) {
		this.con = con;
	}

	public PessoaFisicaDAO(Connection con) {
		setCon(con);
	}

	// Método Inserir
	public String inserir(PessoaFisica pessoaFisica) {
		String sql = "insert into pessoa_fisica(nome, email, senha, cpf, data_nasc, cep, celular, rua, bairro) values (?,?,?,?,?,?,?,?,?)";
		try {
			PreparedStatement ps = getCon().prepareStatement(sql);

			ps.setString(1, pessoaFisica.getNome());
			ps.setString(2, pessoaFisica.getEmail());
			ps.setString(3, pessoaFisica.getSenha());
			ps.setString(4, pessoaFisica.getCpf());
			ps.setString(5, pessoaFisica.getDataNasc());
			ps.setString(6, pessoaFisica.getCep());
			ps.setString(7, pessoaFisica.getCelular());
			ps.setString(8, pessoaFisica.getRua());
			ps.setString(9, pessoaFisica.getBairro());
			

			if (ps.executeUpdate() > 0) {
				return "Inserido com sucesso";
			} else {
				return "Erro ao inserir";
			}
		} catch (SQLException e) {
			return e.getMessage();
		}
	}

	// Método Deletar
	public String deletar(PessoaFisica pessoaFisica) {
		String sql = "delete from pessoa_fisica where cpf = ?";
		try {
			PreparedStatement ps = getCon().prepareStatement(sql);

			ps.setString(1, pessoaFisica.getCpf());

			if (ps.executeUpdate() > 0) {
				return "Deletado com sucesso";
			} else {
				return "Erro ao deletar";
			}
		} catch (SQLException e) {
			return e.getMessage();
		}
	}

	// Método Selecionar
	public ArrayList<PessoaFisica> retornarDados() {
		String sql = "select * from pessoa_fisica";
		ArrayList<PessoaFisica> retornarPessoaFisica = new ArrayList<PessoaFisica>();
		try {
			PreparedStatement ps = getCon().prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			if (rs != null) {
				while (rs.next()) {
					PessoaFisica pessoaFisica = new PessoaFisica();
					pessoaFisica.setNome(rs.getString(2));
					pessoaFisica.setEmail(rs.getString(3));
					pessoaFisica.setCpf(rs.getString(9));
					pessoaFisica.setCep(rs.getString(5));
					pessoaFisica.setCelular(rs.getString(6));					
					
					retornarPessoaFisica.add(pessoaFisica);
				}
				return retornarPessoaFisica;
			} else {
				return null;
			}
		} catch (SQLException e) {
			return null;
		}
	}

	// Método Alterar
	public String alterar(PessoaFisica pessoaFisica) {
		String sql = "update pessoa_fisica set senha = ? where cpf = ?";
		try {
			PreparedStatement ps = getCon().prepareStatement(sql);
			ps.setString(1, pessoaFisica.getSenha());
			ps.setString(2, pessoaFisica.getCpf());

			if (ps.executeUpdate() > 0) {
				return "Alterado com sucesso";
			} else {
				return "Erro ao alterar";
			}
		} catch (SQLException e) {
			return e.getMessage();
		}
	}
}