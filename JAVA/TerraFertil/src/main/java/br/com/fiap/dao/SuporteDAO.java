package br.com.fiap.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import br.com.fiap.beans.Suporte;

public class SuporteDAO {
	private Connection con;

	public final Connection getCon() {
		return con;
	}

	public final void setCon(Connection con) {
		this.con = con;
	}

	public SuporteDAO(Connection con) {
		setCon(con);
	}

	// Método Inserir
	public String inserir(Suporte suporte) {
		String sql = "insert into suporte (nome, email, texto) values (?,?,?)";
		try {
			PreparedStatement ps = getCon().prepareStatement(sql);

			ps.setString(1, suporte.getNomeCompleto());
			ps.setString(2, suporte.getEmail());
			ps.setString(3, suporte.getTexto());

			if (ps.executeUpdate() > 0) {
				return "Inserido com sucesso";
			} else {
				return "Erro ao inserir";
			}
		} catch (SQLException e) {
			return e.getMessage();
		}
	}
}
