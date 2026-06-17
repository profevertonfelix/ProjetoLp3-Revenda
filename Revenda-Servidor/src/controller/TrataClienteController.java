/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.ArrayList;
import model.CategoriaDao;
import model.UsuarioDao;
import model.VeiculoDao;
import modelDominio.Categoria;
import modelDominio.Usuario;
import modelDominio.Veiculo;

/**
 *
 * @author profe essa classe cuida da comunicao com os clientes. Thread para
 * criar a comunicao do server com varios clientes
 */
public class TrataClienteController extends Thread {

    private Socket cliente;
    private ObjectOutput out;
    private ObjectInputStream in;
    private int idUnico;//saber ql usuário 

    public TrataClienteController(Socket cliente, int idUnico) {
        this.cliente = cliente;
        this.idUnico = idUnico;
        try {
            //in RECEBE comandos do cliente
            this.in = new ObjectInputStream(cliente.getInputStream());
            //out ENVIA mensagens para o cliente
            this.out = new ObjectOutputStream(cliente.getOutputStream());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void run() {
        String comando;
        Categoria cat;
        CategoriaDao cDao;
        Usuario usuario;
        UsuarioDao uDao;
        Veiculo veiculo;
        VeiculoDao vDao;
        boolean res;
        System.out.println("Aguardando comandos do cliente " + idUnico);
        try {
            //espera comando do cliente
            comando = (String) in.readObject();
            //enquanto o comando for diferente de FIM, fica em looping
            while (!comando.equalsIgnoreCase("fim")) {
                System.out.println("Cliente " + idUnico + " enviou comando: " + comando);

                switch (comando) {
                    case "UsuarioLogin":
                        out.writeObject("ok");
                        // lendo o usuario que veio do Cliente
                        Usuario user = (Usuario) in.readObject();
                        System.out.println(user);
                        // Criando o UsuarioDao para chamar o método de login
                        uDao = new UsuarioDao();
                        Usuario userLogado = uDao.login(user);
                        out.writeObject(userLogado);

                        break;
                    case "CategoriaLista":
                        CategoriaDao categoriaDao = new CategoriaDao();//conecta no bd
                        ArrayList<Categoria> lista = categoriaDao.getLista();//faz o select
                        out.writeObject(lista);//manda a lista para o cliente
                        break;

                    case "CategoriaInserir":
                        out.writeObject("ok");
                        cat = (Categoria) in.readObject();
                        System.out.println(cat);
                        cDao = new CategoriaDao();
                        res = cDao.inserir(cat);
                        out.writeObject(res);
                        break;

                    case "CategoriaEditar":
                        out.writeObject("ok");
                        cat = (Categoria) in.readObject();
                        System.out.println(cat);
                        cDao = new CategoriaDao();
                        res = cDao.editar(cat);
                        out.writeObject(res);
                        break;

                    case "CategoriaExcluir":
                        out.writeObject("ok");
                        cat = (Categoria) in.readObject();
                        cDao = new CategoriaDao();
                        res = cDao.excluir(cat);
                        out.writeObject(res);

                        break;
                    case "UsuarioLista":
                        UsuarioDao usuarioDao = new UsuarioDao();//conecta no bd
                        ArrayList<Usuario> listau = usuarioDao.getLista();//faz o select
                        out.writeObject(listau);//manda a lista para o cliente
                        break;

                    case "UsuarioInserir":
                        out.writeObject("ok");
                        usuario = (Usuario) in.readObject();
                        System.out.println(usuario);
                        uDao = new UsuarioDao();
                        res = uDao.inserir(usuario);
                        out.writeObject(res);
                        break;

                    case "UsuarioEditar":
                        out.writeObject("ok");
                        usuario = (Usuario) in.readObject();
                        System.out.println(usuario);
                        uDao = new UsuarioDao();
                        res = uDao.editar(usuario);
                        out.writeObject(res);
                        break;

                    case "UsuarioExcluir":
                        out.writeObject("ok");
                        usuario = (Usuario) in.readObject();
                        uDao = new UsuarioDao();
                        res = uDao.excluir(usuario);
                        out.writeObject(res);

                        break;
                    case "VeiculoLista":
                        VeiculoDao veiculoDao = new VeiculoDao();//conecta no bd
                        ArrayList<Veiculo> listav = veiculoDao.getLista();//faz o select
                        out.writeObject(listav);//manda a lista para o cliente
                        break;

                    case "VeiculoInserir":
                        out.writeObject("ok");
                        veiculo = (Veiculo) in.readObject();
                        System.out.println(veiculo);
                        vDao = new VeiculoDao();
                        res = vDao.inserir(veiculo);
                        out.writeObject(res);
                        break;

                    case "VeiculoEditar":
                        out.writeObject("ok");
                        veiculo = (Veiculo) in.readObject();
                        System.out.println(veiculo);
                        vDao = new VeiculoDao();
                        res = vDao.editar(veiculo);
                        out.writeObject(res);
                        break;

                    case "VeiculoExcluir":
                        out.writeObject("ok");
                        veiculo = (Veiculo) in.readObject();
                        vDao = new VeiculoDao();
                        res = vDao.excluir(veiculo);
                        out.writeObject(res);

                        break;

                    default:
                        System.out.println("Comando inválido");
                        break;
                }

                //repete o pedido de comando
                comando = (String) in.readObject();

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
