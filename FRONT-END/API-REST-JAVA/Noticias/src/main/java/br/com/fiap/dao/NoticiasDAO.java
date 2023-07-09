package br.com.fiap.dao;

import java.util.ArrayList;
import java.util.List;

import br.com.fiap.to.NoticiasTO;

public class NoticiasDAO {

	private static List<NoticiasTO> listaDeNoticias;

	public NoticiasDAO() {
		if (listaDeNoticias == null) {
			
			// CODIFICAÇÃO DO BANCO DE DADOS >> UM SELECT >> TO TIPO LIST
			//SELECT
			
			listaDeNoticias = new ArrayList<NoticiasTO>();

			NoticiasTO pto = new NoticiasTO();
			pto.setCodigo(1);
			pto.setTitulo("");
			pto.setDescricao("Chinelo");
			pto.setAutor("");
			pto.setData("");
			listaDeNoticias.add(pto);


		}
	}

	// SELECT ALL
	public List<NoticiasTO> select() {
		return listaDeNoticias;
	}

	// SELECT BY_ID
	public NoticiasTO select(int id) {
		for (int i = 0; i < listaDeNoticias.size(); i++) {
			if (listaDeNoticias.get(i).getCodigo() == id) {
				return listaDeNoticias.get(i);
			}
		}
		return null;
	}

	// INSERT
	public boolean insert(NoticiasTO pto) {
		pto.setCodigo(listaDeNoticias.size() + 1);
		return listaDeNoticias.add(pto);
	}

	// UPDATE
	public void update(NoticiasTO pto) {
		NoticiasTO p = select(pto.getCodigo());
		p.setTitulo(pto.getTitulo());
		p.setDescricao(pto.getDescricao());
		p.setAutor(pto.getTitulo());
		p.setData(pto.getData());
	}
	
	//DELETE
	public void delete(int id) {
		listaDeNoticias.remove(select(id));
	}

}
