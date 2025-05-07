/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.sistema_de_estoque.Controle;

import com.mycompany.sistema_de_estoque.DAO.ProdutoDao;
import com.mycompany.sistema_de_estoque.View.Modelo.Produto;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author Ericsson Dos Santos
 */
public class ProdutoControle {
    private ProdutoDao prodtDao = new ProdutoDao();
    
    public void registrarProdutoNaCentral (String nomeDoProduto, int qtdDoProduto, double precoDoProduto) {
        // A verificação será na tela principal
        Produto produto = new Produto(nomeDoProduto, qtdDoProduto, precoDoProduto);
        boolean retornoDaCentral = prodtDao.adicionarProduto(produto);
        
        if (!retornoDaCentral) {
            JOptionPane.showMessageDialog(null, "Não foi possível cadastrar o produto!",
                    "Atenção!", JOptionPane.ERROR_MESSAGE);
            return;
        }
    }
    
    public ArrayList<Produto> listarProdutosDaCentral () {
        ArrayList<Produto> listaDeProdutos = prodtDao.listarProdutos();
        return listaDeProdutos;
    }
    
    public void atualizarProdutoNaCentral (String nomeDoProduto, int qtdDoProduto, double precoDoProduto) {
        Produto produto = new Produto(nomeDoProduto, qtdDoProduto, precoDoProduto);
        boolean retornoDaCentral = prodtDao.atualizarProduto(produto);
        
        if (!retornoDaCentral) {
            JOptionPane.showMessageDialog(null, "Não foi possível atualizar o produto!", "Atenção!",
                    JOptionPane.ERROR_MESSAGE);
            return; 
        }
        JOptionPane.showMessageDialog(null, "Produto atualizado com sucesso!", "Sucesso!",
                JOptionPane.INFORMATION_MESSAGE);
    }
    
    public void removerProdutoNaCentral (String nomeDoProduto) {
        boolean retornoDaCentral = prodtDao.removerProduto(nomeDoProduto);
        
        if (!retornoDaCentral) {
            JOptionPane.showMessageDialog(null, "Não foi possível remover o produto!",
                    "Atenção!", JOptionPane.ERROR_MESSAGE);
            return;
        }
        JOptionPane.showMessageDialog(null, "Produto removido com sucesso!", "Sucesso!",
                JOptionPane.INFORMATION_MESSAGE);
    }
}
