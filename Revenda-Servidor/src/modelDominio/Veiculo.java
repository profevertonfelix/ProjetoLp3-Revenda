/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelDominio;

import java.io.Serializable;

/**
 *
 * @author profe
 */
public class Veiculo implements Serializable{
    private static final long serialVersionUID = 123L; //codigicação da classe
    private String placa;
    private String modelo;
    private String cor;
    private Categoria categoria;
    private byte[] imagem;

    public Veiculo(String placa, String valor, String cor, Categoria categoria, byte[] imagem) {
        this.placa = placa;
        this.modelo = valor;
        this.cor = cor;
        this.categoria = categoria;
        this.imagem = imagem;
    }

    public byte[] getImagem() {
        return imagem;
    }

    public void setImagem(byte[] imagem) {
        this.imagem = imagem;
    }
   

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getCor() {
        return cor;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    @Override
    public String toString() {
        return "Veiculo{" + "placa=" + placa + ", modelo=" + modelo + ", cor=" + cor + ", categoria=" + categoria + ", imagem=" + imagem + '}';
    }



    
    
}
