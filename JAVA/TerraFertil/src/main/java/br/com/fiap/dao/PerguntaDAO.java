package br.com.fiap.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import br.com.fiap.beans.Pergunta;

public class PerguntaDAO {
	private Connection con;

	public final Connection getCon() {
		return con;
	}

	public final void setCon(Connection con) {
		this.con = con;
	}

	public PerguntaDAO(Connection con) {
		setCon(con);
	}

	// Método Inserir
	public String inserir(Pergunta pergunta) {
		String sql = "insert into pergunta (titulo, texto, data_post) values (?,?,?)";
		try {
			PreparedStatement ps = getCon().prepareStatement(sql);

			ps.setString(1, pergunta.getTitulo());
			ps.setString(2, pergunta.getTexto());
			ps.setString(3, pergunta.getData());

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
	public String deletar(Pergunta pergunta) {
		String sql = "delete from pergunta where titulo = ?";
		try {
			PreparedStatement ps = getCon().prepareStatement(sql);

			ps.setString(1, pergunta.getTitulo());

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
	public ArrayList<Pergunta> retornarDados() {
		String sql = "select * from pergunta";
		ArrayList<Pergunta> retornarPergunta = new ArrayList<Pergunta>();
		try {
			PreparedStatement ps = getCon().prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			if (rs != null) {
				while (rs.next()) {
					Pergunta pergunta = new Pergunta();
					pergunta.setTitulo(rs.getString(4));
					pergunta.setTexto(rs.getString(2));
					pergunta.setData(rs.getString(3));

					retornarPergunta.add(pergunta);
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
	public String alterar(Pergunta pergunta) {
		String sql = "update pergunta set texto = ? where titulo = ?";
		try {
			PreparedStatement ps = getCon().prepareStatement(sql);
			ps.setString(1, pergunta.getTexto());
			ps.setString(2, pergunta.getTitulo());

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

