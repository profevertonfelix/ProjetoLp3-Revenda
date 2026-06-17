/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelDominio;

import java.io.Serializable;

/**
 *
 * @author profe
 */
public class Cliente extends Usuario implements Serializable {
        private static final long serialVersionUID = 123L; //codigicação da classe

    public Cliente(int id, String nome, String email, String senha, boolean tipo) {
        super(id, nome, email, senha, tipo);
    }

    public Cliente(String nome, String email, String senha) {
        super(nome, email, senha);
    }

    public Cliente(String email, String senha) {
        super(email, senha);
    }

    @Override
    public String toString() {
        return super.toString()+"Cliente{" + '}';
    }
    
    
}
