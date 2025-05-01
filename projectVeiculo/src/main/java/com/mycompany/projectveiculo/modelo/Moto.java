/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.projectveiculo.modelo;

/**
 *
 * @author aluno.den
 */
public class Moto extends Veiculo{
    private int cilindradas;
    
    public Moto(String marca, String modelo, int cilindradas){
        super(marca, modelo);
        this.cilindradas = cilindradas;
    }
    
    public int getCilindradas () {
        return cilindradas;
    }
    
    public void setCilindradas (int novaCilindrada) {
        this.cilindradas = novaCilindrada;
    }
}
