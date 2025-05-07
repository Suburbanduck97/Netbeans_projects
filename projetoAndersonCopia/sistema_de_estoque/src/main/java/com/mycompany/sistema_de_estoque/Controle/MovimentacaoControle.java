/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.sistema_de_estoque.Controle;

import com.mycompany.sistema_de_estoque.DAO.MovimentacaoDao;
import com.mycompany.sistema_de_estoque.View.Modelo.Movimentacao;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author Ericsson Dos Santos
 */
public class MovimentacaoControle {
    private MovimentacaoDao movDao = new MovimentacaoDao();
    
    public void registrarMovimentacaoNaCentral (String tipoDaMovimentacao, int qtdMovimentacao) {
        Movimentacao movimentacao = new Movimentacao(tipoDaMovimentacao, qtdMovimentacao);
        boolean retornoDaCentral = movDao.adicionarMovimentacao(movimentacao);
        
        if (!retornoDaCentral) {
            JOptionPane.showMessageDialog(null, "Não foi possível registrar a movimentação, entre em contato com o suporte!",
                    "Atenção!", JOptionPane.INFORMATION_MESSAGE);
            return; 
        }
        
        JOptionPane.showMessageDialog(null, "Houve novas movimentações no sistema, Você pode vê-las no histórico de movimentações!",
                "Atenção!", JOptionPane.INFORMATION_MESSAGE);
    }
    
    public ArrayList<Movimentacao> listarMovimentacoesDaCentral () {
        ArrayList<Movimentacao> listaDeMovimentacoes = movDao.listarMovimentacoes();
        return listaDeMovimentacoes;
    }
    
    public void atualizarMovimentacoes (String tipoDaMovimentacao, int qtdMovimentacao) {
        Movimentacao movimentacao = new Movimentacao(tipoDaMovimentacao, qtdMovimentacao);
        boolean retornoDaCentral = movDao.atualizarMovimentacao(movimentacao);
        
        if (!retornoDaCentral) {
            JOptionPane.showMessageDialog(null, "Não foi possível atualizar as movimentações, entre em contato com o suporte",
                    "Atenção!", JOptionPane.ERROR_MESSAGE);
            return;
        }
    }
}
