/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.sistema_de_estoque.DAO;

import com.mycompany.sistema_de_estoque.Conexao.ConexaoMySQL;
import com.mycompany.sistema_de_estoque.View.Modelo.Usuario;
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
public class UsuarioDao {
    public boolean cadastrarUsuario(Usuario usuario) {
        String sqlInsert = "INSERT INTO sistemadeestoque.usuario (login, senha) VALUES (?,?)";
        
        // PreparedStatement permite adicionarmos através do comando sql os respectivos dados
        try (Connection conexaoDb = ConexaoMySQL.conectar();
            PreparedStatement stmt = conexaoDb.prepareStatement(sqlInsert)) {
      
            stmt.setString(1, usuario.getLoginUsuario());
            stmt.setString(2, usuario.getSenhaUsuario());
            stmt.executeUpdate();
            return true;
        } catch (SQLException e) {
            System.out.println("Erro ao cadastrar usuário " + 
                    e.getMessage());
            return false;
        }
    }
    
    // Paramos aqui, fazer o sistema de logar
    public boolean logar(String login, String senha) {
        String sqlSelect = "SELECT login,senha FROM sistemadeestoque.usuario WHERE login = ? AND senha = ?";
        try (Connection conexaoDB = ConexaoMySQL.conectar();
            PreparedStatement stmt = conexaoDB.prepareStatement(sqlSelect)){
            
            stmt.setString(1, login);
            stmt.setString(2, senha);
            
            ResultSet rs = stmt.executeQuery();
            return rs.next(); // retorna true se encontrar e false se não
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao tentar logar: " + e.getMessage(),
                    "Atenção!", JOptionPane.ERROR_MESSAGE);
            return false;
        }
    }
    
    public ArrayList<Usuario> listarUsuarios () {
        ArrayList<Usuario> listaDeUsuarios = new ArrayList<>();
        String sqlSelect = "SELECT * FROM sistemadeestoque.usuario";
        
        try (Connection conexaoDb = ConexaoMySQL.conectar();
            Statement stmt = conexaoDb.createStatement(); 
            ResultSet rs = stmt.executeQuery(sqlSelect)) { // Precisamos entender o ResultSet
            
            while (rs.next()) {
                Usuario usuario = new Usuario(
                    rs.getString("login"),
                    rs.getString("senha"
                ));
                listaDeUsuarios.add(usuario);
            }
        } catch (SQLException e) {
           e.printStackTrace();
        }
        return listaDeUsuarios;
    }
}


