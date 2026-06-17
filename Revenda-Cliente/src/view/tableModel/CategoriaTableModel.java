/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view.tableModel;

import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;
import modelDominio.Categoria;

/**
 *
 * @author profe
 */
public class CategoriaTableModel extends AbstractTableModel {

    private ArrayList<Categoria> lista;

    public CategoriaTableModel(ArrayList<Categoria> lista) {
        this.lista = lista;
    }

    @Override
    public int getRowCount() {
        return lista.size();
    }

    @Override
    public int getColumnCount() {
        return 2;//numero de colunas
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Categoria categoria = lista.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return categoria.getId();
            case 1:
                return categoria.getNome();
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
            default:
                return "nenhum";
        }
    }
    
    public Categoria getCategoria(int linha){
        return lista.get(linha);
    } 

}
