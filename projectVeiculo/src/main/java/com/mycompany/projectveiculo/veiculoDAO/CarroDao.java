/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.projectveiculo.veiculoDAO;

import com.mycompany.projectveiculo.modelo.Carro;
import java.util.ArrayList;

/**
 *
 * @author aluno.den
 */
public class CarroDao {
    private ArrayList<Carro> carrosCadastrados = new ArrayList<>();
    
    public void centralAdicionarCarro(Carro carro) {
        carrosCadastrados.add(carro);
    }
    
    public ArrayList<Carro> listarCarrosCadastrados () {
        return carrosCadastrados;
    }
}
