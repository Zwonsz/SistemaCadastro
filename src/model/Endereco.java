package model;

import java.util.Scanner;

public class Endereco {
    private int numero;
    private String cidade;
   private String rua;

    public Endereco(int numero, String cidade, String rua) {
        this.numero = numero;
        this.cidade = cidade;
        this.rua = rua;
    }

    public Endereco() {

    }

    public Endereco cadastrarEndereco(){
        Scanner scanner = new Scanner(System.in);

        System.out.println("Numero da casa");
        this.numero = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Cidade");
        this.cidade = scanner.nextLine();
        System.out.println("Rua");
        this.rua = scanner.nextLine();

        return new Endereco(numero, cidade, rua);
    }

    public int getNumero() {
        return numero;
    }

    public String getCidade() {
        return cidade;
    }

    public String getRua() {
        return rua;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public void setRua(String rua) {
        this.rua = rua;
    }
}
