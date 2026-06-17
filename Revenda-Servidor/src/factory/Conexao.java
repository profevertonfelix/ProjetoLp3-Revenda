/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package factory;

import java.sql.*;

/**
 *
 * @author profe
 */
public class Conexao {

    //esse obj guarda a conexao com o banco
    //fazer import Connextion do java.sql.*
    private static Connection con;

    //método que faz a conexao com o banco quando chamado.
    public static Connection getConexao() {
        try {
            String url = "jdbc:mysql://localhost:3306/banquinho1";
            String usuario = "root";
            String senha = "";
            
            con = DriverManager.getConnection(url, usuario, senha);
            return con;
        }catch(Exception e){
            e.printStackTrace();
            return null;
        }
    }
}
