/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.cadastro2.dao;

import com.mycompany.cadastro2.conexao.ConexaoMySQL;
import com.mycompany.cadastro2.modelo.Pessoa;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author aluno.den
 */
public class PessoaDAO {
    public void inserir(Pessoa pessoa) throws SQLException{
        String sql = "INSERT INTO pessoa (nome, idade) VALUES (?, ?)";
        try (Connection conn = ConexaoMySQL.conectar(); PreparedStatement smt = conn.prepareStatement(sql)){
            smt.setString(1, pessoa.getNome());
            smt.setInt(2, pessoa.getIdade());
            smt.executeUpdate();
        }catch (SQLException e){
            e.printStackTrace();
        }
    }
    
    public ArrayList<Pessoa> listarPessoa() {
        ArrayList<Pessoa> lista = new ArrayList<>();
        String sql = "SELECT * FROM pessoa";
        try (Connection conn = ConexaoMySQL.conectar();
                Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()){
                Pessoa p = new Pessoa (
                    rs.getInt("id"),
                    rs.getString("nome"),
                    rs.getInt("idade")
                );
                lista.add(p);
            }
        }catch (SQLException e) {
            e.printStackTrace();
        }
        return lista;
    }
    
    public ArrayList<Pessoa> buscarPorNome (String nome) throws SQLException {
        ArrayList<Pessoa> lista = new ArrayList<>();
        String sql = "SELECT * FROM pessoa WHERE nome LIKE ?";
        
        try (Connection conn = ConexaoMySQL.conectar();
                PreparedStatement stmt = conn.prepareStatement(sql)){
            stmt.setString(1, "%" + nome + "%");
            ResultSet rs = stmt.executeQuery();
            
            while (rs.next()) {
                Pessoa p = new Pessoa (
                        rs.getInt("id"),
                        rs.getString("nome"),
                        rs.getInt("idade")
                );
                lista.add(p);
            }
            
        }
        return lista;
    }
    
    public void atualizar(Pessoa pessoa){
        String sql = "UPDATE pessoa SET nome = ?, idade = ? WHERE id = ?";
        try (Connection conn = ConexaoMySQL.conectar();
                PreparedStatement stmt = conn.prepareStatement(sql)){
            stmt.setString(1, pessoa.getNome());
            stmt.setInt(2, pessoa.getIdade());
            stmt.setInt(3, pessoa.getId());
            stmt.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public void remover(int id){
        String sql = "DELETE FROM pessoa WHERE id = ?";
        try (Connection conn = ConexaoMySQL.conectar();
            PreparedStatement stmt = conn.prepareStatement(sql)){
            stmt.setInt(1, id);
            stmt.executeUpdate();
            
        }catch (SQLException e) {
            e.printStackTrace();
        }
    }
}