/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.sistema_de_estoque.View.Modelo;

/**
 *
 * @author Ericsson Dos Santos
 */
public class Produto {
    private int idProduto;
    private String nomeDoProduto;
    private int qtdDeProdutos;
    private double precoDoProduto;
    
    public Produto (String nomeDoProduto, int qtdDeProdutos, double precoDoProduto){
        this.nomeDoProduto = nomeDoProduto;
        this.qtdDeProdutos = qtdDeProdutos;
        this.precoDoProduto = precoDoProduto;
    }
    
    // Construtor para facilitar as buscas 
    public Produto(int idProduto, String nomeDoProduto, int qtdDeProdutos, double precoDoProduto) {
        this.idProduto = idProduto;
        this.nomeDoProduto = nomeDoProduto;
        this.qtdDeProdutos = qtdDeProdutos;
        this.precoDoProduto = precoDoProduto;
    }
    
    public String getNomeDoProduto () {
        return nomeDoProduto;
    }
    
    public int getQtdDeProdutos () {
        return qtdDeProdutos;
    }
    
    public double getPrecoDoProduto () {
        return precoDoProduto;
    }
    
    public int getIdProduto () {
        return idProduto;
    }
    
    public void setNomeDoProduto (String novoNomeDoProduto) {    
        this.nomeDoProduto = novoNomeDoProduto;
    }
    
    public void setQtdDeProdutos (int novaQtdDeProdutos) {
        this.qtdDeProdutos = novaQtdDeProdutos;
    }
    
    public void setPrecoDoProduto (double novoPrecoDoProduto) {
        this.precoDoProduto = novoPrecoDoProduto;
    }
    
    public void setIdProduto (int novoIdProduto) {
        this.idProduto = novoIdProduto;
    }
}
