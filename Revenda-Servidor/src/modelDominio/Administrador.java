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
public class Administrador extends Usuario implements Serializable {
        private static final long serialVersionUID = 123L; //codigicação da classe

    public Administrador(int id, String nome, String email, String senha, boolean tipo) {
        super(id, nome, email, senha, tipo);
    }

    public Administrador(String nome, String email, String senha) {
        super(nome, email, senha);
    }

    public Administrador(String email, String senha) {
        super(email, senha);
    }

    @Override
    public String toString() {
        return super.toString()+"Administrador{" + '}';
    }

    
    

   
    
    
}
