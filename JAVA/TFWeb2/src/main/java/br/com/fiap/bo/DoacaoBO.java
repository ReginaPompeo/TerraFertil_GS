package br.com.fiap.bo;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import br.com.fiap.conexao.Conexao;
import br.com.fiap.dao.DoacaoDAO;
import br.com.fiap.to.DoacaoTO;

public class DoacaoBO {
    
	/**
	 * Ranking de doações visível na página web
	 * onde demonstra qual doador doou mais e 
	 * qual doou menos 
	 */
	public ArrayList<DoacaoTO> exibirDadosDoacaoBo() {
	    Connection con = null;
	    try {
	        con = Conexao.abrirConexao();
	        DoacaoDAO doacaodao = new DoacaoDAO(con);
	        ArrayList<DoacaoTO> doacoes = doacaodao.exibirDoacao();
	        // Usado para ordenar em ordem decrescente
	        Collections.sort(doacoes);
	        return doacoes;
	    } catch (Exception e) {
	        e.printStackTrace();
	        return null;
	    } finally {
	        System.out.println("Feito");
	        Conexao.fecharConexao(con);
	    }
	}
	
	public DoacaoTO exibirDadosDoacaoBoId(int id) {
	    Connection con = null;
	    try {
	        con = Conexao.abrirConexao();
	        DoacaoDAO doacaodao = new DoacaoDAO(con);
	        DoacaoTO doacao = doacaodao.exibirDoacaoPorId(id);
	        return doacao;
	    } catch (Exception e) {
	        e.printStackTrace();
	        return null;
	    } finally {
	        System.out.println("Feito");
	        Conexao.fecharConexao(con);
	    }
	}
	  public void inserirDoacao(DoacaoTO doacao) throws SQLException {
	        Connection con = null;
	        try {
	            con = Conexao.abrirConexao();
	            DoacaoDAO doacaoDao = new DoacaoDAO(con);
	            doacaoDao.inserir(doacao);
	            System.out.println("Doação inserida com sucesso.");
	        } finally {
	            Conexao.fecharConexao(con);
	        }
	    }

	    public void atualizarDoacao(DoacaoTO doacao) throws SQLException {
	        Connection con = null;
	        try {
	            con = Conexao.abrirConexao();
	            DoacaoDAO doacaoDao = new DoacaoDAO(con);
	            doacaoDao.atualizar(doacao);
	            System.out.println("Doação atualizada com sucesso.");
	        } finally {
	            Conexao.fecharConexao(con);
	        }
	    }

	    public void excluirDoacao(int id) throws SQLException {
	        Connection con = null;
	        try {
	            con = Conexao.abrirConexao();
	            DoacaoDAO doacaoDao = new DoacaoDAO(con);
	            doacaoDao.excluir(id);
	            System.out.println("Doação excluída com sucesso.");
	        } finally {
	            Conexao.fecharConexao(con);
	        }
	    }

}
