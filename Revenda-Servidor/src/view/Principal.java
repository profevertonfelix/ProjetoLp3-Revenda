/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view;

import controller.TrataClienteController;
import factory.Conexao;
import java.net.ServerSocket;
import java.net.Socket;

/**
 *
 * @author profe
 */
public class Principal {
    public static void main(String[] args) {
        try {
            if(Conexao.getConexao() != null){
                System.out.println("Conectado ao bd!");
            }
            
            ServerSocket servidor = new ServerSocket(123);
            System.out.println("Servidor inicializado! Aguardando conexões");
            int idUnico = 0;
            
            while(true){
                Socket cliente = servidor.accept();
                System.out.println("Novo cliente conectado com id: "+idUnico+", cliente: "+cliente);
                idUnico++;
                TrataClienteController trataCliente = new TrataClienteController(cliente, idUnico);
                trataCliente.start();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
