/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.sistema_de_estoque.View.Modelo;

/**
 *
 * @author Ericsson Dos Santos
 */
public class Usuario {
    private String loginUsuario;
    private String senhaUsuario;
    
    public Usuario (String loginUsuario, String senhaUsuario){
        this.loginUsuario = loginUsuario;
        this.senhaUsuario = senhaUsuario;
    }
    
    public String getLoginUsuario(){
        return loginUsuario;
    }
    
    public String getSenhaUsuario() {
        return senhaUsuario;
    }
    
    public void setLoginUsuario(String novoLoginUsuario) {
        this.loginUsuario = novoLoginUsuario;
    }
    
    public void setSenhaUsuario (String novaSenhaUsuario) {
        this.senhaUsuario = novaSenhaUsuario;
    }
}
