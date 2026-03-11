package util;

import exceptions.IdadeException;
import exceptions.NomeInvalidoException;
import exceptions.PetPesoException;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Validador {


    public String validarNome(String nome){

        String regex = "^[A-Za-zÀ-ÖØ-öø-ÿ]+( [A-Za-zÀ-ÖØ-öø-ÿ]+)+$";
        Pattern pattern = Pattern.compile(regex);

        if (nome == null || nome.trim().isEmpty()){
            throw new NomeInvalidoException("Nome não pode estar vazio");
        }

        Matcher matcher = pattern.matcher(nome.trim());
        if (!matcher.matches()){
            throw new NomeInvalidoException("Nome não pode conter caracter especial");
        }

        return nome;
    }

    public double validarPeso(Double peso) throws PetPesoException {

        if(peso > 60){
            throw new PetPesoException("Peso do pet excede o limite");
        }
        if (peso < 0.5){
            throw  new PetPesoException("Peso do pet é menor do que o permitido");
        }
        return peso;

    }

    public double validarIdade (Double idade)throws IdadeException {

        if (idade > 20){
            throw new IdadeException();
        }
        return idade;
    }

}
