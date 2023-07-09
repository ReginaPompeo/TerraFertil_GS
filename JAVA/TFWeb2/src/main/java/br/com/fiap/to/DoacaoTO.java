package br.com.fiap.to;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class DoacaoTO implements Comparable<DoacaoTO> {

	private int id;
	private String nome;
	private double quantidade;

	public DoacaoTO() {

	}

	public DoacaoTO(int id, String nome, double quantidade) {
		super();
		this.id = id;
		this.nome = nome;
		this.quantidade = quantidade;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public double getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(double quantidade) {
		this.quantidade = quantidade;
	}

	/** 
	 * Utilizado para ordenar em ordem decrescente com base no 
	 * valor da quantidade registrada no banco de dados pelo doador
	 * 
	 * @author Regina Pompeo 
	 *  
	 */ 

	@Override
	public int compareTo(DoacaoTO outraDoacao) {
		// Ordenar em ordem decrescente com base no valor
		if (this.quantidade > outraDoacao.getQuantidade()) {
			return -1;
		} else if (this.quantidade < outraDoacao.getQuantidade()) {
			return 1;
		} else {
			return 0;
		}
	}
} 