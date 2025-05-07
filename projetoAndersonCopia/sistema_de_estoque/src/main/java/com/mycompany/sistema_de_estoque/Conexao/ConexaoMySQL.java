/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.sistema_de_estoque.Conexao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Ericsson Dos Santos
 */
public class ConexaoMySQL {
    //Passando o endereço do banco de dados
    private static final String URL = "jdbc:mysql://localhost:3306/sistemadeestoque";
    private static final String USUARIO = "root";
    private static final String SENHA = "";
    
    // Cria um método para conexão no banco de dados
    public static Connection conectar() {
        try {
            return DriverManager.getConnection(URL, USUARIO, SENHA);
        } catch (SQLException e) {
            throw new RuntimeException("Erro na conexão com o banco de dados "
            + e.getMessage());
        }
    }
    
    public static void main(String[] args){
        Connection conexaoDb = conectar();
        if (conexaoDb != null) {
            System.out.println("Conexão verificada e ativada!");
        } else {
            System.out.println("Erro ao se conectar com o banco de dados!");
        }
    }
    
}


