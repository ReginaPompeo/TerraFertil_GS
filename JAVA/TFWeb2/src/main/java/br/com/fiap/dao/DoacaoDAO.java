package br.com.fiap.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.fiap.to.DoacaoTO;

public class DoacaoDAO {

	private Connection conexao;

	public final Connection getConexao() {
		return conexao;
	}

	public final void setConexao(Connection conexao) {
		this.conexao = conexao;
	}

	public DoacaoDAO(Connection conexao) {
        setConexao(conexao);
    }

	public DoacaoDAO() {
		// TODO Auto-generated constructor stub
	}

	public ArrayList<DoacaoTO> exibirDoacao() {
		String sql = "SELECT * FROM doacao";
		ArrayList<DoacaoTO> retornarDoacao = new ArrayList<>();

		try {
			if (conexao != null) {
				PreparedStatement ps = conexao.prepareStatement(sql);
				ResultSet rs = ps.executeQuery();
				while (rs.next()) {
					DoacaoTO doacao = new DoacaoTO();
					doacao.setId(rs.getInt("ID"));
					doacao.setNome(rs.getString("nome"));
					doacao.setQuantidade(rs.getDouble("Quantidade"));
					retornarDoacao.add(doacao);
				}
			}
		} catch (SQLException e) {
			System.err.println("Erro ao buscar os objetos Empresa: " + e.getMessage());
		}
		return retornarDoacao;
	}

	public DoacaoTO exibirDoacaoPorId(int id) {
		String sql = "SELECT * FROM doacao WHERE id = ?";
		DoacaoTO doacao = null;
		try {
			if (conexao != null) {
				PreparedStatement ps = conexao.prepareStatement(sql);
				ps.setInt(1, id);
				ResultSet rs = ps.executeQuery();
				if (rs.next()) {
					doacao = new DoacaoTO();
					doacao.setId(rs.getInt("id"));
					doacao.setNome(rs.getString("nome"));
					doacao.setQuantidade(rs.getDouble("Quantidade"));
				}
			}
		} catch (SQLException e) {
			System.err.println("Erro ao buscar o objeto Doação: " + e.getMessage());
		}

		return doacao;
	}

	public void inserir(DoacaoTO doacao) {
		String sql = "INSERT INTO doacao (nome, quantidade) "
				+ "VALUES (?, ?)";
		try {
			PreparedStatement ps = conexao.prepareStatement(sql);
			ps.setString(1, doacao.getNome());
			ps.setDouble(2, doacao.getQuantidade());
			ps.executeUpdate();
		} catch (SQLException e) {
			System.err.println("Erro ao inserir o objeto Doação: " + e.getMessage());
		}
	}

	public void atualizar(DoacaoTO doacao) {
		String sql = "UPDATE doacao SET nome = ?, quantidade = ? WHERE id = ?";
		try {
			PreparedStatement ps = conexao.prepareStatement(sql);
			ps.setString(1, doacao.getNome());
			ps.setDouble(2, doacao.getQuantidade());
			ps.setInt(3, doacao.getId());
			ps.executeUpdate();
		} catch (SQLException e) {
			System.err.println("Erro ao atualizar o objeto Doação: " + e.getMessage());
		}
	}

	public void excluir(int id) {
		String sql = "DELETE FROM doacao WHERE id = ?";
		try {
			PreparedStatement ps = conexao.prepareStatement(sql);
			ps.setInt(1, id);
			ps.executeUpdate();
		} catch (SQLException e) {
			System.err.println("Erro ao excluir o objeto Doação: " + e.getMessage());
		}
	}

}
