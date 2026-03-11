package model;

import java.util.Scanner;

public class Endereco {
    private String numero;
    private String cidade;
   private String rua;

    public Endereco(String numero, String cidade, String rua) {
        this.numero = numero;
        this.cidade = cidade;
        this.rua = rua;
    }


    public Endereco() {

    }

    public Endereco(String[] x) {
        this.numero = x[0].trim();
        this.cidade = x[1].trim();
        this.rua = x[2].trim();
    }



    public String getCidade() {
        return cidade;
    }

    public String getRua() {
        return rua;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public void setRua(String rua) {
        this.rua = rua;
    }

    @Override
    public String toString() {
        boolean ruaVazia = rua == null || rua.isBlank();
        boolean numeroVazio = numero == null || numero.isBlank();
        boolean cidadeVazia = cidade == null || cidade.isBlank();

        if (ruaVazia && numeroVazio && cidadeVazia) {
            return "NÃO INFORMADO";
        }
        return  rua + ", " + cidade + ", " + numero;
    }
}
