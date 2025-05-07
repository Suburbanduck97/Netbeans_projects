/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.sistema_de_estoque.DAO;

import com.mycompany.sistema_de_estoque.Conexao.ConexaoMySQL;
import com.mycompany.sistema_de_estoque.View.Modelo.Produto;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author Ericsson Dos Santos
 */
public class ProdutoDao {
    
    public boolean adicionarProduto (Produto produto) {
        String sqlInsert = "INSERT INTO sistemadeestoque.produto (nomeProduto, quantidadeProduto, precoProduto) VALUES (?,?,?)";
        
        try (Connection conexaoDb = ConexaoMySQL.conectar();
            PreparedStatement stmt = conexaoDb.prepareStatement(sqlInsert)){
            
            stmt.setString(1, produto.getNomeDoProduto());
            stmt.setInt(2, produto.getQtdDeProdutos());
            stmt.setDouble(3, produto.getPrecoDoProduto());
            stmt.executeUpdate();
            return true; // Esse return será verificado lá na tela pricipal e disparará a mensagem que tudo ocorreu perfeitamente
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Não foi possível cadastrar o produto: " + e.getMessage(),
                    "Atenção!", JOptionPane.ERROR_MESSAGE);
            return false;
        }
    }
    
    public ArrayList<Produto> listarProdutos () {
        ArrayList<Produto> listaDeProdutos = new ArrayList<>();
        String sqlSelect = "SELECT * FROM sistemadeestoque.produto";
        
        try (Connection conexaoDb = ConexaoMySQL.conectar();
             Statement stmt = conexaoDb.createStatement();
             ResultSet rs = stmt.executeQuery(sqlSelect)){
            
            while (rs.next()) {
                Produto produto = new Produto(
                        rs.getInt("idproduto"),
                        rs.getString("nomeProduto"),
                        rs.getInt("quantidadeProduto"),
                        rs.getDouble("precoProduto")
                );
                listaDeProdutos.add(produto);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return listaDeProdutos;
    }
    
    public boolean atualizarProduto (Produto produto) {
        String SqlUpdate = "UPDATE sistemadeestoque.produto SET nomeProduto = ?, quantidadeProduto = ?, precoProduto = ? WHERE id = ?";
        
        try (Connection conexaoDb = ConexaoMySQL.conectar();
            PreparedStatement stmt = conexaoDb.prepareStatement(SqlUpdate)){
            
            stmt.setString(1, produto.getNomeDoProduto());
            stmt.setInt(2, produto.getQtdDeProdutos());
            stmt.setDouble(3, produto.getPrecoDoProduto());
            
            int linhasAfetadas = stmt.executeUpdate();
            return linhasAfetadas > 0;
            
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
    
    public boolean removerProduto (String nomeDoProduto) {
        String sqlDelete = "DELETE FROM sistemadeestoque.produto WHERE nomeProduto = ?";
        
        try (Connection conexaoDb = ConexaoMySQL.conectar();
            PreparedStatement stmt = conexaoDb.prepareCall(sqlDelete)){
            
            stmt.setString(1, nomeDoProduto);
            stmt.executeUpdate();
            return true;
            
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
    
}
