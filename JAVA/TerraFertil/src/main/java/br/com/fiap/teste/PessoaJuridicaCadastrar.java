package br.com.fiap.teste;

import java.sql.Connection;
import org.apache.http.client.ClientProtocolException;
import br.com.fiap.beans.PessoaJuridica;
import br.com.fiap.bo.PessoaJuridicaBO;
import br.com.fiap.bo.Excecao;
import br.com.fiap.conexao.Conexao;
import java.io.IOException;
import br.com.fiap.model.Endereco;
import br.com.fiap.service.ViacepService;

public class PessoaJuridicaCadastrar {

	public static void main(String[] args) throws Excecao, ClientProtocolException, IOException {

		Connection con = Conexao.abrirConexao();

		PessoaJuridica pessoaJuridica = new PessoaJuridica();

		PessoaJuridicaBO pessoaJuridicabo = new PessoaJuridicaBO();

		ViacepService viacepservice = new ViacepService();

		// Método inserir

		String cep = "01311000";

		Endereco endereco = viacepservice.getEndereco(cep);

		pessoaJuridica.setNome("Empesa legal");
		pessoaJuridica.setRazaoSocial("Empresa Legal.LTDA");
		pessoaJuridica.setCnpj("12345678910234");
		pessoaJuridica.setEmail("empresalegal@outlook.com.br");
		pessoaJuridica.setSenha("Legal1234");
		pessoaJuridica.setCep(cep);
		pessoaJuridica.setCelular("11965832014");
		pessoaJuridica.setRua(endereco.getLogradouro());
		pessoaJuridica.setBairro(endereco.getBairro());

		pessoaJuridicabo.inserirBO(pessoaJuridica);

		Conexao.fecharConexao(con);
	}
}