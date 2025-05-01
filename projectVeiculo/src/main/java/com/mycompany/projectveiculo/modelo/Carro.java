/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.projectveiculo.modelo;

/**
 *
 * @author aluno.den
 */
public class Carro extends Veiculo{
    private int qtdPortas;
    
    public Carro(String marca, String modelo, int qtdPortas){
        super(marca, modelo);
        this.qtdPortas = qtdPortas;
    }
    
    public int getQtdPortas () {
        return qtdPortas;
    }
    
    public void setQtdPortas () {
        this.qtdPortas = qtdPortas;
    }
}
