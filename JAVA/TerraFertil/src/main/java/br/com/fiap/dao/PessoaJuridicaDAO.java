package br.com.fiap.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import br.com.fiap.beans.PessoaJuridica;

public class PessoaJuridicaDAO {

	private Connection con;

	public final Connection getCon() {
		return con;
	}

	public final void setCon(Connection con) {
		this.con = con;
	}

	public PessoaJuridicaDAO(Connection con) {
		setCon(con);
	}

	// Método Inserir
	public String inserir(PessoaJuridica pessoaJuridica) {
		String sql = "insert into pessoa_juridica(nome, razao_social, email, senha, cnpj, cep, rua, bairro, celular) values (?,?,?,?,?,?,?,?,?)";
		try {
			PreparedStatement ps = getCon().prepareStatement(sql);
			ps.setString(1, pessoaJuridica.getNome());
			ps.setString(2, pessoaJuridica.getRazaoSocial());
			ps.setString(3, pessoaJuridica.getEmail());
			ps.setString(4, pessoaJuridica.getSenha());
			ps.setString(5, pessoaJuridica.getCnpj());
			ps.setString(6, pessoaJuridica.getCep());
			ps.setString(7, pessoaJuridica.getRua());
			ps.setString(8, pessoaJuridica.getBairro());
			ps.setString(9, pessoaJuridica.getCelular());

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

	public String deletar(PessoaJuridica pessoaJuridica) {
		String sql = "delete from pessoa_juridica where cnpj = ?";
		try {
			PreparedStatement ps = getCon().prepareStatement(sql);
			ps.setString(1, pessoaJuridica.getCnpj());
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
	public ArrayList<PessoaJuridica> retornarDados() {
		String sql = "select * from pessoa_juridica";
		ArrayList<PessoaJuridica> retornarCliente = new ArrayList<PessoaJuridica>();
		try {
			PreparedStatement ps = getCon().prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			if (rs != null) {
				while (rs.next()) {
					PessoaJuridica pessoaJuridica = new PessoaJuridica();
					pessoaJuridica.setRazaoSocial(rs.getString(10));
					pessoaJuridica.setCnpj(rs.getString(9));
					retornarCliente.add(pessoaJuridica);
				}
				return retornarCliente;
			} else {
				return null;
			}
		} catch (SQLException e) {
			return null;
		}
	}

	// Método Alterar
	public String alterar(PessoaJuridica pessoaJuridica) {
		String sql = "update pessoa_juridica set senha = ? where cnpj = ?";
		try {
			PreparedStatement ps = getCon().prepareStatement(sql);
			ps.setString(1, pessoaJuridica.getSenha());
			ps.setString(2, pessoaJuridica.getCnpj());

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