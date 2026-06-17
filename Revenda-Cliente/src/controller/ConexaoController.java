/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

/**
 *
 * @author profe
 */
import modelDominio.Categoria;
import modelDominio.Usuario;
import modelDominio.Veiculo;

public class ConexaoController {

    private ObjectOutputStream out;
    private ObjectInputStream in;
    private Usuario userLogado;

    public ConexaoController(ObjectOutputStream out, ObjectInputStream in) {
        this.out = out;
        this.in = in;
    }

    public Usuario getUserLogado() {
        return userLogado;
    }

    public void setUserLogado(Usuario userLogado) {
        this.userLogado = userLogado;
    }

    public Usuario usuarioLogin(Usuario usuario) {
        try {
            // enviando comando "UsuarioLogin" para o servidor
            out.writeObject("UsuarioLogin");
            // lendo ok 
            in.readObject();
            // enviando o email e senha
            out.writeObject(usuario);
            // recebendo usuário ou nulo do servidor
            Usuario userLogado = (Usuario) in.readObject();
            return userLogado;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    //metodo para listar as categorias para o cliente
    public ArrayList<Categoria> categoriaLista() {
        try {
            out.writeObject("CategoriaLista");
            ArrayList<Categoria> lista = (ArrayList<Categoria>) in.readObject();
            return lista;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public ArrayList<Usuario> usuarioLista() {
        try {
            out.writeObject("UsuarioLista");
            ArrayList<Usuario> listau = (ArrayList<Usuario>) in.readObject();
            return listau;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public ArrayList<Veiculo> veiculoLista() {
        try {
            out.writeObject("VeiculoLista");
            ArrayList<Veiculo> listav = (ArrayList<Veiculo>) in.readObject();
            return listav;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public boolean categoriaInserir(Categoria cat) {
        try {
            out.writeObject("CategoriaInserir");
            in.readObject(); // lendo o OK
            out.writeObject(cat);
            boolean res = (boolean) in.readObject();
            return res;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean usuarioInserir(Usuario usuario) {
        try {
            out.writeObject("UsuarioInserir");
            in.readObject(); // lendo o OK
            out.writeObject(usuario);
            boolean res = (boolean) in.readObject();
            return res;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean veiculoInserir(Veiculo veiculo) {
        try {
            out.writeObject("VeiculoInserir");
            in.readObject(); // lendo o OK
            out.writeObject(veiculo);
            boolean res = (boolean) in.readObject();
            return res;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean categoriaEditar(Categoria cat) {
        try {
            out.writeObject("CategoriaEditar");
            in.readObject(); // lendo o OK
            out.writeObject(cat);
            boolean res = (boolean) in.readObject();
            return res;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean usuarioEditar(Usuario usuario) {
        try {
            out.writeObject("UsuarioEditar");
            in.readObject(); // lendo o OK
            out.writeObject(usuario);
            boolean res = (boolean) in.readObject();
            return res;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean veiculoEditar(Veiculo veiculo) {
        try {
            out.writeObject("VeiculoEditar");
            in.readObject(); // lendo o OK
            out.writeObject(veiculo);
            boolean res = (boolean) in.readObject();
            return res;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean categoriaExcluir(Categoria cat) {
        try {
            out.writeObject("CategoriaExcluir");
            in.readObject(); // lendo o OK
            out.writeObject(cat);
            boolean res = (boolean) in.readObject();
            return res;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean usuarioExcluir(Usuario user) {
        try {
            out.writeObject("UsuarioExcluir");
            in.readObject(); // lendo o OK
            out.writeObject(user);
            boolean res = (boolean) in.readObject();
            return res;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean veiculoExcluir(Veiculo veiculo) {
        try {
            out.writeObject("VeiculoExcluir");
            in.readObject(); // lendo o OK
            out.writeObject(veiculo);
            boolean res = (boolean) in.readObject();
            return res;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}
