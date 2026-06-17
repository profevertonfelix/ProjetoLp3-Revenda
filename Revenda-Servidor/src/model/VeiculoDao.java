/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import factory.Conexao;
import java.sql.*;
import java.util.ArrayList;
import modelDominio.Categoria;
import modelDominio.Veiculo;

/**
 *
 * @author profe
 */
public class VeiculoDao {

    private Connection con;
    //cria uma instancia da variavel de conexao para usarmos na classe

    //construtor conecta ao banco
    public VeiculoDao() {
        con = Conexao.getConexao();
    }

    //metodo getLista retorna todas as categorias
    public ArrayList<Veiculo> getLista() {
        ArrayList<Veiculo> lista = new ArrayList<>();
        try {
            String sql
                    = "SELECT veiculo.*, categoria.* FROM veiculo inner join categoria"
                    + " on veiculo.idcategoria = categoria.id";
            //prepara a execução do sql
            PreparedStatement stmt = con.prepareStatement(sql);
            //executa
            ResultSet res = stmt.executeQuery();
            //trata o retorno com um while + next.
            while (res.next()) {
                Veiculo veiculo = new Veiculo(
                        res.getString("placa"),
                        res.getString("cor"),
                        res.getString("modelo"),
                        new Categoria(res.getInt("idcategoria"), res.getString("nome")),
                        res.getBytes("imagem")
                );

                lista.add(veiculo);
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

    public boolean inserir(Veiculo s) {
        try {
            String sql = "insert into veiculo (placa, cor, modelo,"
                    + " idcategoria, imagem) values (?, ?,?,?, ?)";
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1, s.getPlaca());
            stmt.setString(2, s.getCor());
            stmt.setString(3, s.getModelo());
            stmt.setInt(4, s.getCategoria().getId());
            stmt.setBytes(5, s.getImagem());
            stmt.execute();
            stmt.close();
            con.close();
            return true;//retorna que funcionou
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean editar(Veiculo s) {

        try {
            String sql = "update veiculo set cor=?, modelo = ?, "
                    + "idcategoria = ?, imagem = ? where placa = ?";
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1, s.getCor());
            stmt.setString(2, s.getModelo());
            stmt.setInt(3, s.getCategoria().getId());
            stmt.setBytes(4, s.getImagem());
            stmt.setString(5, s.getPlaca());

            stmt.execute();
            stmt.close();
            con.close();
            return true;//retorna que funcionou

        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean excluir(Veiculo s) {

        try {
            String sql = "delete from veiculo where placa = ?";
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1, s.getPlaca());

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
