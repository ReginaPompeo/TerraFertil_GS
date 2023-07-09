package br.com.fiap.teste;

import java.sql.Connection;
import org.apache.http.client.ClientProtocolException;
import br.com.fiap.beans.PessoaFisica;
import br.com.fiap.bo.PessoaFisicaBO;
import br.com.fiap.bo.Excecao;
import br.com.fiap.conexao.Conexao;
import java.io.IOException;
import br.com.fiap.model.Endereco;
import br.com.fiap.service.ViacepService;

public class PessoaFisicaCadastrar {

	public static void main(String[] args) throws Excecao, ClientProtocolException, IOException {

		Connection con = Conexao.abrirConexao();

		PessoaFisica pessoaFisica = new PessoaFisica();

		PessoaFisicaBO pessoaFisicabo = new PessoaFisicaBO();

		ViacepService viacepservice = new ViacepService();

		// Método inserir

		String cep = "04904904";

		Endereco endereco = viacepservice.getEndereco(cep);

		pessoaFisica.setNome("Matheus Leite Oliveira Scalfo");
		pessoaFisica.setEmail("matheus.l.oliveira28@hotmail.com");
		pessoaFisica.setSenha("!amogatinhos24!");
		pessoaFisica.setCpf("47553265832");
		pessoaFisica.setDataNasc("28/01/2000");
		pessoaFisica.setCep(cep);
		pessoaFisica.setCelular("958280400");
		pessoaFisica.setRua(endereco.getLogradouro());
		pessoaFisica.setBairro(endereco.getBairro());

		pessoaFisicabo.inserirBO(pessoaFisica);

		Conexao.fecharConexao(con);
	}
}