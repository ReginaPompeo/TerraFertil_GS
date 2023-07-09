package br.com.fiap.teste;

import java.io.IOException;
import br.com.fiap.model.Endereco;
import br.com.fiap.service.ViacepService;

public class Viacep {

	public static void main(String[] args) {

		ViacepService viacepservice = new ViacepService();
		try {
			Endereco endereco = viacepservice.getEndereco("05832240");
			String ddd = endereco.getDdd();
			String uf = endereco.getUf();
			System.out.println(endereco + "\n");
			System.out.println(ddd + "\n");
			System.out.println(uf + "\n");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
