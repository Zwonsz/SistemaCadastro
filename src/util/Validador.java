package util;

import exceptions.IdadeException;
import exceptions.NomeInvalidoException;
import exceptions.PetPesoException;
import model.Pet;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Validador {
private static final List<String> CRITERIOS_VALIDOS = List.of("nome", "sexo", "idade", "peso", "raca");
private static final List<String> ATRIBUTOS_VALIOS =  List.of("nome", "idade","peso","raca","endereco");

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

    public String validarCriterioBusca(String criterio){

        criterio = criterio.toLowerCase().replace("ç", "c").replace("ã", "a");

        if (!(CRITERIOS_VALIDOS.contains(criterio))){
            throw new IllegalArgumentException("Criterio de busca inválido, tente novamente");
        }else return criterio;



    }

    public String validarAtributoEditavel(String atributo){

        atributo = atributo.toLowerCase().replace("ç","c").replace("ã", "a");

        if (!(ATRIBUTOS_VALIOS.contains(atributo))) {
            throw new IllegalArgumentException("Atributo não disponível para editar. Por favor, escolha outro");
        }else return atributo;
    }


}
