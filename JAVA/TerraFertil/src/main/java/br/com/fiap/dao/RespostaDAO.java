package br.com.fiap.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import br.com.fiap.beans.Pergunta;
import br.com.fiap.beans.Resposta;

public class RespostaDAO {
	

	private Connection con;

	public final Connection getCon() {
		return con;
	}

	public final void setCon(Connection con) {
		this.con = con;
	}

	public RespostaDAO(Connection con) {
		setCon(con);
	}

	// Método Inserir
	public String inserir(Resposta resposta) {
		String sql = "insert into Resposta ( texto, data_post, aceitacao) values (?,?,?)";
		try {
			PreparedStatement ps = getCon().prepareStatement(sql);

			ps.setString(1, resposta.getTexto());
			ps.setString(2, resposta.getData());
			ps.setBoolean(3, resposta.getAceitacao());

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
	public String deletar(Resposta resposta) {
		String sql = "delete from resposta where data_post = ?";
		try {
			PreparedStatement ps = getCon().prepareStatement(sql);

			ps.setString(1, resposta.getData());

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
	public ArrayList<Resposta> retornarDados() {
		String sql = "select * from resposta";
		ArrayList<Resposta> retornarPergunta = new ArrayList<Resposta>();
		try {
			PreparedStatement ps = getCon().prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			if (rs != null) {
				while (rs.next()) {
					Resposta resposta = new Resposta();
					resposta.setTexto(rs.getString(2));
					resposta.setData(rs.getString(3));
					resposta.setAceitacao(rs.getBoolean(4));

					retornarPergunta.add(resposta);
				}
				return retornarPergunta;
			} else {
				return null;
			}
		} catch (SQLException e) {
			return null;
		}
	}

	// Método Alterar
	public String alterar(Resposta resposta) {
		String sql = "update resposta set texto = ? where data_post = ?";
		try {
			PreparedStatement ps = getCon().prepareStatement(sql);
			ps.setString(1, resposta.getTexto());
			ps.setString(2, resposta.getData());

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