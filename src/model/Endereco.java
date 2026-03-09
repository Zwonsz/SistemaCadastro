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

    public Endereco cadastrarEndereco(){
        Scanner scanner = new Scanner(System.in);

        System.out.println("Numero da casa");
        this.numero = scanner.nextLine();
        scanner.nextLine();
        System.out.println("Cidade");
        this.cidade = scanner.nextLine();
        System.out.println("Rua");
        this.rua = scanner.nextLine();

        return new Endereco(numero, cidade, rua);
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
        return  rua + ", " + numero + ", " + cidade;
    }
}
