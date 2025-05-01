/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.projectveiculo.veiculoController;

import com.mycompany.projectveiculo.modelo.Carro;
import com.mycompany.projectveiculo.veiculoDAO.CarroDao;
import java.util.ArrayList;

/**
 *
 * @author aluno.den
 */
public class carroController {
    private CarroDao carroDao = new CarroDao();
    
    public void dataBaseControllerCarroAdicionar (String marca, String modelo, int qtdPortas) {
        Carro carro = new Carro(marca, modelo, qtdPortas);
        carroDao.centralAdicionarCarro(carro);
    }
    
    public void dataBaseControllerUpdate(){
        
    }
    
    public ArrayList<Carro> listarCarrosCadastrados () {
        return carroDao.listarCarrosCadastrados();
    }
}
