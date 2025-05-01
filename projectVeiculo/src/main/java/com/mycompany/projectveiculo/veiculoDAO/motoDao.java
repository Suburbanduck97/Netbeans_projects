/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.projectveiculo.veiculoDAO;

import com.mycompany.projectveiculo.modelo.Moto;
import java.util.ArrayList;

/**
 *
 * @author aluno.den
 */
public class motoDao {
    private ArrayList<Moto> motosCadastradas = new ArrayList<>();
    
    public void centralAdicionarMoto(Moto moto) {
        motosCadastradas.add(moto);
    }
    
    public ArrayList<Moto> listarMotosCadastradas () {
        return motosCadastradas;
    }
}
