package br.com.fiap.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import br.com.fiap.beans.Noticia;


public class NoticiaDAO {
	private Connection con;

	public final Connection getCon() {
		return con;
	}

	public final void setCon(Connection con) {
		this.con = con;
	}

	public NoticiaDAO(Connection con) {
		setCon(con);
	}

	// Método Inserir
	public String inserir(Noticia noticia) {
		String sql = "insert into noticia (titulo, texto, data_post) values (?,?,?)";
		try {
			PreparedStatement ps = getCon().prepareStatement(sql);

			ps.setString(1, noticia.getTitulo());
			ps.setString(2, noticia.getTexto());
			ps.setString(3, noticia.getData());
		    
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
	public String deletar(Noticia noticia) {
		String sql = "delete from noticia where titulo = ?";
		try {
			PreparedStatement ps = getCon().prepareStatement(sql);

			ps.setString(1, noticia.getTitulo());

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
	public ArrayList<Noticia> retornarDados() {
		String sql = "select * from noticia";
		ArrayList<Noticia> retornarNoticia = new ArrayList<Noticia>();
		try {
			PreparedStatement ps = getCon().prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			if (rs != null) {
				while (rs.next()) {
					Noticia noticia = new Noticia();
					noticia.setTitulo(rs.getString(2));
					noticia.setTexto(rs.getString(3));
					noticia.setData(rs.getString(4));
				
					retornarNoticia.add(noticia);
				}
				return retornarNoticia;
			} else {
				return null;
			}
		} catch (SQLException e) {
			return null;
		}
	}

	// Método Alterar
	public String alterar(Noticia noticia) {
			String sql = "update noticia set texto = ? where titulo = ?";
			try {
				PreparedStatement ps = getCon().prepareStatement(sql);
				ps.setString(1, noticia.getTexto());
				ps.setString(2, noticia.getTitulo());

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
