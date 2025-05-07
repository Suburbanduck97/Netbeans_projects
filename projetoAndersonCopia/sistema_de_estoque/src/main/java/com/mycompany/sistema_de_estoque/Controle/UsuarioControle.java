/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.sistema_de_estoque.Controle;

import com.mycompany.sistema_de_estoque.DAO.UsuarioDao;
import com.mycompany.sistema_de_estoque.View.Modelo.Usuario;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author Ericsson Dos Santos
 */
public class UsuarioControle {
    private UsuarioDao userDao = new UsuarioDao();
    
    public boolean registrarUsuarioNaCentral (String login, String senha, String confirmaSenha) {
        if (login == null || senha == null || confirmaSenha == null || login.isEmpty() || senha.isEmpty() || confirmaSenha.isEmpty()){
            JOptionPane.showMessageDialog(null, "Login ou senha não podem estar vazios",
                    "Atenção!", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        
        if (!confirmaSenha.equals(senha)) {
            JOptionPane.showMessageDialog(null, "As senhas estão diferentes!",
                    "Atenção!", JOptionPane.ERROR_MESSAGE);
            return false;            
        }
        Usuario novoUsuario = new Usuario(login, confirmaSenha);
        // Irá retornar um verdadeiro ou false como resultado do cadastro de usuário no banco
        return userDao.cadastrarUsuario(novoUsuario);
    }
    
    public boolean loginNaCentral (String usuario, String senha) {
        if (usuario == null || senha == null || usuario.isEmpty() || senha.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Preencha todos os campos de login!", "Atenção!",
                    JOptionPane.ERROR_MESSAGE);
            return false;
        }
        
        boolean retornoDaCentral = userDao.logar(usuario, senha);
        if (!retornoDaCentral) {
            JOptionPane.showMessageDialog(null, "Usuário ou senha invalido(s)!", "Atenção!",
                    JOptionPane.ERROR_MESSAGE);
            return false;
        }
        
        JOptionPane.showMessageDialog(null, "Login bem-sucedido!", "Sucesso!",
                JOptionPane.INFORMATION_MESSAGE);
        return true;
    }
    
    public ArrayList<Usuario> listarUsuariosDaCentral () {
        ArrayList<Usuario> usuariosListados = userDao.listarUsuarios();
        return usuariosListados;
    }
}
