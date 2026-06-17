/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view.tableModel;

import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;
import modelDominio.Usuario;

/**
 *
 * @author profe
 */
public class UsuarioTableModel extends AbstractTableModel {

    private ArrayList<Usuario> lista;

    public UsuarioTableModel(ArrayList<Usuario> lista) {
        this.lista = lista;
    }

    @Override
    public int getRowCount() {
        return lista.size();
    }

    @Override
    public int getColumnCount() {
        return 5;//numero de colunas
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Usuario usuario = lista.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return usuario.getId();
            case 1:
                return usuario.getNome();
            case 2:
                return usuario.getEmail();
            case 3:
                return usuario.getSenha();
            case 4:
                return usuario.isTipo();
            default:
                return "nenhum";
        }
    }

    @Override
    public String getColumnName(int column) {
        switch (column) {
            case 0:
                return "id";
            case 1:
                return "nome";
            case 2:
                return "email";
            case 3:
                return "senha";
            case 4:
                return "tipo";

            default:
                return "nenhum";
        }
    }
    
    public Usuario getUsuario(int linha){
        return lista.get(linha);
    } 

}
