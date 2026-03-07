package model;

import exceptions.SexoInvalidoException;

public enum PetSex {
    FEMINO("Feminino"), MASCULINO("Masculino");

    String nome;
    PetSex(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    public static PetSex PetSexoPorNome(String sexo){
        for(PetSex petSex : values()){
            if (petSex.getNome().equalsIgnoreCase(sexo)){
                return petSex;
            }
        }
        throw new SexoInvalidoException();
    }


}
