/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.sistema_de_estoque.View.Modelo;

/**
 *
 * @author Ericsson Dos Santos
 */
public class Movimentacao {
    private int idMovimentacao;
    private String tipoDaMovimentacao;
    private int qtdDeProdutosMovimentados;
    
    public Movimentacao (String tipoDaMovimentacao, int qtdDeProdutosMovimentados){
        this.tipoDaMovimentacao = tipoDaMovimentacao;
        this.qtdDeProdutosMovimentados = qtdDeProdutosMovimentados;
    }
    
    public Movimentacao (int idMovimentacao, String tipoDaMovimentacao, int qtdDeProdutosMovimentados){
        this.idMovimentacao = idMovimentacao;
        this.tipoDaMovimentacao = tipoDaMovimentacao;
        this.qtdDeProdutosMovimentados = qtdDeProdutosMovimentados;
    }
    
    public String getTipoDaMovimentacao () {
        return tipoDaMovimentacao;
    }
    
    public int getQtdProdutosMovimentados () {
        return qtdDeProdutosMovimentados;
    }
    
    public int getIdMovimentacao () {
        return idMovimentacao;
    }
    
    public void setTipoDaMovimentacao (String novoTipoDaMovimentacao) {
        this.tipoDaMovimentacao = novoTipoDaMovimentacao;
    }
    
    public void setQtdDeProdutosMovimentados (int novaQtdDeProdutosMovimentados) {
        this.qtdDeProdutosMovimentados = novaQtdDeProdutosMovimentados;
    }
    
    public void setIdMovimentacao (int novoIdMovimentacao) {
        this.idMovimentacao = novoIdMovimentacao;
    }
}
