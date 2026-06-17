/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view;

import controller.ConexaoController;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

/**
 *
 * @author profe
 */
public class RevendaCliente {

    public static ConexaoController conexaocontroller;

    public static void main(String[] args) {
        try {
            Socket socket = new Socket("localhost", 123);
            // com o OUT eu posso enviar coisas para o SERVIDOR
            ObjectOutputStream out = new ObjectOutputStream(socket.getOutputStream());
            // com o IN eu posso receber coisas do SERVIDOR
            ObjectInputStream in = new ObjectInputStream(socket.getInputStream());
            conexaocontroller = new ConexaoController(out, in);
            TelaLogin login = new TelaLogin();
            login.setVisible(true);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
