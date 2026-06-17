/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view.tableModel;

import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.table.AbstractTableModel;
import modelDominio.Veiculo;
import java.awt.Image;
public class VeiculoTableModel extends AbstractTableModel {

    private ArrayList<Veiculo> lista;

    public VeiculoTableModel(ArrayList<Veiculo> lista) {
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
        Veiculo veiculo = lista.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return veiculo.getPlaca();
            case 1:
                return veiculo.getCor();
            case 2:
                return veiculo.getModelo();
            case 3:
                return veiculo.getCategoria().getNome();
            case 4:
                ImageIcon icon = new ImageIcon(veiculo.getImagem());

                Image img = icon.getImage().getScaledInstance(
                        100, 100, java.awt.Image.SCALE_SMOOTH);

                return new ImageIcon(img);
            default:
                return "nenhum";
        }
    }

    @Override
    public Class<?> getColumnClass(int columnIndex) {
        if (columnIndex == 4) {
            return ImageIcon.class;
        }
        return Object.class;
    }

    @Override
    public String getColumnName(int column) {
        switch (column) {
            case 0:
                return "placa";
            case 1:
                return "COR";
            case 2:
                return "Modelo";
            case 3:
                return "categoria";
            case 4:
                return "imagem";

            default:
                return "nenhum";
        }
    }

    public Veiculo getVeiculo(int linha) {
        return lista.get(linha);
    }

}
