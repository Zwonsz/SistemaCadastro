package model;

import exceptions.TipoInvalidoException;

public enum PetTipo {
    CACHORRO("Cachorro"), 
    GATO("Gato");

    String nome;

    public String getNome() {
        return nome;
    }

    PetTipo(String nome) {
        this.nome = nome;
    }

    public static PetTipo PetTipoPorNome (String nome){
    for (PetTipo petTipo : values()){
        if (petTipo.getNome().equalsIgnoreCase(nome)){
            return petTipo;
        }
    }
        throw new TipoInvalidoException(nome);
    }
}
