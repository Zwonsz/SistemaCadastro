package model;

public class Pet {

    private String nome;
    private PetTipo tipo;
    private PetSex sexo;
    private Endereco endereco;
    private Double idade;
    private Double peso;
    private String raca;
    private String caminhoArquivo;

    public void setRaca(String raca) {
        this.raca = raca;
    }

    public void setPeso(Double peso) {
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

    public Double getPeso() {
        return peso;
    }

    public String getRaca() {
        return raca;
    }

    @Override
    public String toString() {
        return nome + " - " + tipo + " - " + sexo + " - " + endereco + " - " + idade +
                " anos - " + peso + " Kgs - " + raca;
    }

    public void setCaminhoArquivo(String caminhoArquivo) {
        this.caminhoArquivo = caminhoArquivo;
    }

    public String getCaminhoArquivo() {
        return caminhoArquivo;
    }
}

