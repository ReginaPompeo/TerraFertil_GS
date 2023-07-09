package br.com.fiap.bo;

import java.util.List;

import br.com.fiap.dao.NoticiasDAO;
import br.com.fiap.to.NoticiasTO;

public class NoticiasBO {

	private NoticiasDAO pd;

	public List<NoticiasTO> listar() {
		pd = new NoticiasDAO();
		// REGRAS DE NEGÓCIO
		return pd.select();
	}

	public NoticiasTO listar(int id) {
		pd = new NoticiasDAO();
		// REGRAS DE NEGÓCIO
		return pd.select(id);
	}

	public boolean cadastrar(NoticiasTO pto) {
		pd = new NoticiasDAO();
		// REGRAS DE NEGÓCIO
		return pd.insert(pto);
	}

	public void atualiza(NoticiasTO pto) {
		pd = new NoticiasDAO();
		// REGRAS DE NEGÓCIO
		pd.update(pto);
	}

	public void remover(int id) {
		pd = new NoticiasDAO();
		// REGRAS DE NEGÓCIO
		pd.delete(id);
	}

}
