/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.sistema_de_estoque.DAO;

import com.mycompany.sistema_de_estoque.Conexao.ConexaoMySQL;
import com.mycompany.sistema_de_estoque.View.Modelo.Categoria;
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
public class CategoriaDao {
    
    public boolean cadastrarCategoria (Categoria categoria) {
        String sqlInsert = "INSERT INTO sistemadeestoque.categoria VALUES (?)";
        try (Connection conexaoDb = ConexaoMySQL.conectar();
             PreparedStatement stmt = conexaoDb.prepareStatement(sqlInsert)){
            
            stmt.setString(1, categoria.getNomeDaCategoria());
            stmt.executeUpdate();
            return true;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Não foi possível cadastrar a categoria no banco de dados " + e.getMessage(),
                    "Atenção!", JOptionPane.ERROR_MESSAGE);
            return false;
        }
    }
    
    public ArrayList<Categoria> listarCategorias () {
        ArrayList<Categoria> listaDeCategorias = new ArrayList<>();
        String sqlSelect = "SELECT * FROM sistemadeestoque.categoria";
        try (Connection conexaoDb = ConexaoMySQL.conectar();
            Statement stmt = conexaoDb.createStatement();
            ResultSet rs = stmt.executeQuery(sqlSelect)) {
            
            while (rs.next()) {
                Categoria categoria = new Categoria(
                        rs.getInt("idcategoria"),
                        rs.getString("nomeCategoria")
                );
                listaDeCategorias.add(categoria);
            }
        } catch (SQLException e) {
           e.printStackTrace();
        }
        return listaDeCategorias;
    }
    
    public boolean atualizarCategoria (Categoria categoria) {
        String sqlUpdate = "UPDATE sistemadeestoque.categoria SET nomeCategoria = ? WHERE idcategoria = ?";
        
        try (Connection conexaoDb = ConexaoMySQL.conectar();
            PreparedStatement stmt = conexaoDb.prepareStatement(sqlUpdate)){
            
            stmt.setString(1, categoria.getNomeDaCategoria());
            stmt.setInt(2, categoria.getIdCategoria());
            
            int linhasAfetadas = stmt.executeUpdate();
            return linhasAfetadas > 0;
            
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao atualizar a categoria: " + e.getMessage(),
                    "Atenção!", JOptionPane.ERROR_MESSAGE);
            return false;
        }
    }
    
    public boolean removerCategoria (String nomeDaCategora) {
        String sqlDelete = "DELETE FROM sistemadeestoque.categoria WHERE nomeCategoria = ?";
        
        try (Connection conexaoDb = ConexaoMySQL.conectar();
            PreparedStatement stmt = conexaoDb.prepareStatement(sqlDelete)){
            
            stmt.setString(1, nomeDaCategora);
            stmt.executeUpdate();
            return true;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Não foi possível excluir a categoria do produto: " + e.getMessage(),
                    "Atenção!", JOptionPane.ERROR_MESSAGE);
            return false;
        }
    }
}
