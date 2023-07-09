package br.com.fiap.teste;

import java.sql.Connection;

import javax.swing.JOptionPane;

import br.com.fiap.conexao.Conexao;
import br.com.fiap.dao.DoacaoDAO;
import br.com.fiap.to.DoacaoTO;

public class ProgramaInserir {
    public static void main(String[] args) {
        Connection con = Conexao.abrirConexao();

        DoacaoDAO doacaoDao = new DoacaoDAO(con);

        // Inserir nova empresa
        DoacaoTO novaDoacao = new DoacaoTO();
        novaDoacao.setNome(JOptionPane.showInputDialog("Digite o nome do doador: "));
        novaDoacao.setQuantidade(Double.parseDouble(JOptionPane.showInputDialog("Digite a quantidade da doação: ")));
        doacaoDao.inserir(novaDoacao);
        System.out.println("Nova doação inserida com sucesso.");

        Conexao.fecharConexao(con);
    }
}
