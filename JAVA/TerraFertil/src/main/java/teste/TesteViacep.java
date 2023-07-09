package teste;

import java.io.IOException;

import model.Endereco;
import service.ViacepService;

public class TesteViacep {
	
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

