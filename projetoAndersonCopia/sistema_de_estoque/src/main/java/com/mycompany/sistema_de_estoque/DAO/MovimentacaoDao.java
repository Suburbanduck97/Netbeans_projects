/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.sistema_de_estoque.DAO;

import com.mycompany.sistema_de_estoque.Conexao.ConexaoMySQL;
import com.mycompany.sistema_de_estoque.View.Modelo.Movimentacao;
import java.awt.Dialog;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author Ericsson Dos Santos
 */
public class MovimentacaoDao {
    
    public boolean adicionarMovimentacao (Movimentacao movimentacao) {
        String sqlInsert = "INSERT INTO sistemadeestoque.movimentacao (quatidade, tipo) VALUES (?,?)";
        
        try (Connection conexaoDb = ConexaoMySQL.conectar();
            PreparedStatement stmt = conexaoDb.prepareStatement(sqlInsert)){
            
            stmt.setInt(1, movimentacao.getQtdProdutosMovimentados());
            stmt.setString(2, movimentacao.getTipoDaMovimentacao());
            stmt.executeUpdate();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
    
    public ArrayList<Movimentacao> listarMovimentacoes () {
       ArrayList<Movimentacao> listaDeMovimentacoes = new ArrayList<>();
       String sqlSelect = "SELECT * FROM sistemadeestoque.movimentacao";
       
        try (Connection conexaoDb = ConexaoMySQL.conectar();
            Statement stmt = conexaoDb.createStatement();
            ResultSet rs = stmt.executeQuery(sqlSelect)){
            
            while (rs.next()) {
                Movimentacao movimentacao = new Movimentacao(
                    rs.getInt("idmovimentacao"),
                    rs.getString("tipo"),
                    rs.getInt("quantidade")
                );
                listaDeMovimentacoes.add(movimentacao);
           }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
        return listaDeMovimentacoes;
    }
    
    public boolean atualizarMovimentacao (Movimentacao movimentacao) {
        String sqlUpdate = "UPDATE sistemadeestoque.movimentacao SET quantidade = ?, tipo = ? WHERE id = ?";
        
        try (Connection conexaoDb = ConexaoMySQL.conectar();
            PreparedStatement stmt = conexaoDb.prepareStatement(sqlUpdate)){
            
            stmt.setInt(1, movimentacao.getQtdProdutosMovimentados());
            stmt.setString(2, movimentacao.getTipoDaMovimentacao());
            stmt.setInt(3, movimentacao.getIdMovimentacao());
            stmt.executeUpdate();
            conexaoDb.commit();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}
