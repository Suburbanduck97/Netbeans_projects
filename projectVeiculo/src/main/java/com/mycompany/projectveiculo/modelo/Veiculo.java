/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.projectveiculo.modelo;

/**
 *
 * @author aluno.den
 */

public class Veiculo {
    private String marca;
    private String modelo;
    
    public Veiculo(String marca, String modelo){
        this.marca = marca;
        this.modelo = modelo;
    }
    
    public String getMarca () {
        return marca;
    }
    
    public String getModelo () {
        return modelo;
    }
    
    public void setMarca (String novaMarca) {
        this.marca = novaMarca;
    }
    
    public void setModelo (String novoModelo) {
        this.modelo = novoModelo;
    }
}
