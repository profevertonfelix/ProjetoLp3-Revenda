/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import factory.Conexao;
import java.sql.*;
import java.util.ArrayList;
import modelDominio.Administrador;
import modelDominio.Cliente;
import modelDominio.Usuario;

/**
 *
 * @author profe
 */
public class UsuarioDao {

    private Connection con;
    //cria uma instancia da variavel de conexao para usarmos na classe

    //construtor conecta ao banco
    public UsuarioDao() {
        con = Conexao.getConexao();
    }

    public Usuario login(Usuario user) {
        Usuario userLogado = null;
        try {
            String sql = "select * from usuario where"
                    + " email = ? and senha = ?";
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1, user.getEmail());
            stmt.setString(2, user.getSenha());

            ResultSet res = stmt.executeQuery();
            if (res.next()) {
                if (res.getBoolean("tipo") == true) {
                    // Administrador
                    userLogado = new Administrador(
                            res.getInt("id"),
                            res.getString("nome"),
                            res.getString("email"),
                            res.getString("senha"),
                            res.getBoolean("tipo")
                    );
                } else {
                    // Cliente
                    userLogado = new Cliente( 
                            res.getInt("id"),
                            res.getString("nome"),
                            res.getString("email"),
                            res.getString("senha"),
                            res.getBoolean("tipo")
                    );
                }
                System.out.println(userLogado);
            }
            // fechando as conexões
            res.close();
            stmt.close();
            con.close();
            return userLogado;

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    //metodo getLista retorna todas as categorias
    public ArrayList<Usuario> getLista() {
        ArrayList<Usuario> lista = new ArrayList<>();
        try {
            String sql
                    = "SELECT * FROM usuario";
            //prepara a execução do sql
            PreparedStatement stmt = con.prepareStatement(sql);
            //executa
            ResultSet res = stmt.executeQuery();
            //trata o retorno com um while + next.
            while (res.next()) {
                //cria o objetoint id, String nome, String email, String senha
                Usuario usuario = new Usuario(
                        res.getInt("id"),
                        res.getString("nome"),
                        res.getString("email"),
                        res.getString("senha"),
                        res.getBoolean("tipo")
                );

                lista.add(usuario);
                //adiciona na lista
            }
            res.close();
            stmt.close();
            con.close();
            return lista;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public boolean inserir(Usuario s) {
        try {
            String sql = "insert into usuario (nome, email, senha, tipo) values (?,?,?, false)";
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1, s.getNome());
            stmt.setString(2, s.getEmail());
            stmt.setString(3, s.getSenha());
            stmt.execute();
            stmt.close();
            con.close();
            return true;//retorna que funcionou
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean editar(Usuario s) {

        try {
            String sql = "update usuario set nome=?, email = ?, senha = ? where id = ?";
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1, s.getNome());
            stmt.setString(2, s.getEmail());
            stmt.setString(3, s.getSenha());
            stmt.setInt(4, s.getId());
            stmt.execute();
            stmt.close();
            con.close();
            return true;//retorna que funcionou

        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean excluir(Usuario s) {

        try {
            String sql = "delete from usuario where id = ?";
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setInt(1, s.getId());

            stmt.execute();

            stmt.close();
            con.close();
            return true;//retorna que funcionou

        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

}
