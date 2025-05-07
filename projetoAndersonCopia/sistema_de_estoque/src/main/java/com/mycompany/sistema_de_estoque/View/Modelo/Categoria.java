/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.sistema_de_estoque.View.Modelo;

/**
 *
 * @author Ericsson Dos Santos
 */
public class Categoria {
    private int idCategoria;
    private String nomeDaCategoria;
    
    public Categoria (String nomeDaCategoria) {
       this.nomeDaCategoria = nomeDaCategoria;
    }
    
    // Para facilitar buscas
    public Categoria (int idCategoria, String nomeDaCategoria) {
       this.idCategoria = idCategoria; 
       this.nomeDaCategoria = nomeDaCategoria;
    }
   
    public String getNomeDaCategoria () {
       return nomeDaCategoria;
    }
   
    public void setNomeDaCategoria (String novaCagtegoria) {
        this.nomeDaCategoria = novaCagtegoria;
    }
    
    public int getIdCategoria () {
        return idCategoria;
    }
    
    public void setIdCategoria (int novoIdCategoria) {
        this.idCategoria = novoIdCategoria;
    }
}
