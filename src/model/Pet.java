package model;

public class Pet {

    private String nome;
    private PetTipo tipo;
    private PetSex sexo;
    private Endereco endereco;
    private Double idade;
    private double peso;
    private String raca;

    public void setRaca(String raca) {
        this.raca = raca;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    public void setIdade(Double idade) {
        this.idade = idade;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setTipo(PetTipo tipo) {
        this.tipo = tipo;
    }

    public void setSexo(PetSex sexo) {
        this.sexo = sexo;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    public String getNome() {
        return nome;
    }

    public PetTipo getTipo() {
        return tipo;
    }

    public PetSex getSexo() {
        return sexo;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public Double getIdade() {
        return idade;
    }

    public double getPeso() {
        return peso;
    }

    public String getRaca() {
        return raca;
    }
}

