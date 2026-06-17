/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import factory.Conexao;
import java.sql.*;
import java.util.ArrayList;
import modelDominio.Categoria;

/**
 *
 * @author profe
 */
public class CategoriaDao {

    private Connection con;
    //cria uma instancia da variavel de conexao para usarmos na classe

    //construtor conecta ao banco
    public CategoriaDao() {
        con = Conexao.getConexao();
    }

    //metodo getLista retorna todas as categorias
    public ArrayList<Categoria> getLista() {
        ArrayList<Categoria> lista = new ArrayList<>();
        try {
            String sql
                    = "SELECT * FROM categoria";
            //prepara a execução do sql
            PreparedStatement stmt = con.prepareStatement(sql);
            //executa
            ResultSet res = stmt.executeQuery();
            //trata o retorno com um while + next.
            while (res.next()) {
                //cria o objeto
                Categoria categoria = new Categoria(
                        res.getInt("id"),
                        res.getString("nome"));

                lista.add(categoria);
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

    public boolean inserir(Categoria s) {
        try {
            String sql = "insert into categoria (nome) values (?)";
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1, s.getNome());
            stmt.execute();
            stmt.close();
            con.close();
            return true;//retorna que funcionou
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
      public boolean editar(Categoria s) {

        try {
            String sql = "update categoria set nome=? where id = ?";
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1, s.getNome());
            stmt.setInt(2, s.getId());
            stmt.execute();
            stmt.close();
            con.close();
            return true;//retorna que funcionou

        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
       public boolean excluir(Categoria s) {

        try {
            String sql = "delete from categoria where id = ?";
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
