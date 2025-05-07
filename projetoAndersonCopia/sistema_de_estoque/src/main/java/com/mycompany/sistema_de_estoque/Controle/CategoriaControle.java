/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.sistema_de_estoque.Controle;

import com.mycompany.sistema_de_estoque.DAO.CategoriaDao;
import com.mycompany.sistema_de_estoque.View.Modelo.Categoria;
import javax.swing.JOptionPane;

/**
 *
 * @author Ericsson Dos Santos
 */
public class CategoriaControle {
    private CategoriaDao categDao = new CategoriaDao();
    
    public void registrarCategoriaNaCentral(String nomeDaCategoria) {
        if (nomeDaCategoria == null || nomeDaCategoria.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Por favor selecione uma categoria para cadastrar o produto!",
                    "Atenção!", JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        Categoria categoria = new Categoria(nomeDaCategoria);
        boolean retornoDaCentral = categDao.cadastrarCategoria(categoria);
        
        if (!retornoDaCentral) {
            JOptionPane.showMessageDialog(null, "Não foi possível registrar a categoria do produto!",
                    "Atenção!", JOptionPane.ERROR_MESSAGE);
            return;
        }
    }
    
    public boolean atualizarCategoriaNaCentral (String nomeDaCategoria) {
        Categoria categoria = new Categoria(nomeDaCategoria);
       boolean retornoDaCentral = categDao.cadastrarCategoria(categoria);
       
       if (!retornoDaCentral) {
           JOptionPane.showMessageDialog(null, "Não foi possível atualizar a categoria do produto!");
           return false;
       }
       
       return true;
    }
}
