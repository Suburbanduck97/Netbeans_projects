/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.projectveiculo.veiculoController;

import com.mycompany.projectveiculo.modelo.Moto;
import com.mycompany.projectveiculo.veiculoDAO.motoDao;
import java.util.ArrayList;

/**
 *
 * @author aluno.den
 */
public class MotoController {
   private motoDao mtDao = new motoDao();
   
    public void dataBaseControllerMotoAdicionar (String marca, String modelo, int cilindradas) {
       Moto moto = new Moto(marca, modelo, cilindradas);
       mtDao.centralAdicionarMoto(moto);
    }
    
    public ArrayList<Moto> listarMotosCadastradas () {
        return mtDao.listarMotosCadastradas();
    }
}
