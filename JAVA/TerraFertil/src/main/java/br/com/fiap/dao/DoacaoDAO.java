package br.com.fiap.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import br.com.fiap.beans.Doacao;


public class DoacaoDAO {
	private Connection con;

	public final Connection getCon() {
		return con;
	}

	public final void setCon(Connection con) {
		this.con = con;
	}

	public DoacaoDAO(Connection con) {
		setCon(con);
	}

	// Método Inserir
	public String inserir(Doacao doacao) {
		String sql = "insert into doacao (nome, quantidade) values (?,?)";
		try {
			PreparedStatement ps = getCon().prepareStatement(sql);

			ps.setString(1, doacao.getNome());
			ps.setDouble(2, doacao.getQuantidade());
		    
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
	public String deletar(Doacao doacao) {
		String sql = "delete from doacao where nome = ?";
		try {
			PreparedStatement ps = getCon().prepareStatement(sql);

			ps.setString(1, doacao.getNome());

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
	public ArrayList<Doacao> retornarDados() {
		String sql = "select * from doacao";
		ArrayList<Doacao> retornarDoacao = new ArrayList<Doacao>();
		try {
			PreparedStatement ps = getCon().prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			if (rs != null) {
				while (rs.next()) {
					Doacao doacao = new Doacao();
					doacao.setId(rs.getInt(1));
					doacao.setNome(rs.getString(2));
					doacao.setQuantidade(rs.getDouble(3));
				
					retornarDoacao.add(doacao);
				}
				return retornarDoacao;
			} else {
				return null;
			}
		} catch (SQLException e) {
			return null;
		}
	}

	// Método Alterar
	public String alterar(Doacao doacao) {
			String sql = "update doacao set quantidade = ? where nome = ?";
			try {
				PreparedStatement ps = getCon().prepareStatement(sql);
				ps.setDouble(1, doacao.getQuantidade());
				ps.setString(2, doacao.getNome());

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
