package service;

import exceptions.IdadeException;
import exceptions.NomeInvalidoException;
import exceptions.PetPesoException;
import formulario.Formulario;
import model.Pet;
import model.PetSex;
import model.PetTipo;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PetController {

    Pet pet = new Pet();
    public ArrayList<Pet> respostas = new ArrayList<>();
    Formulario form = new Formulario();
    Scanner scanner = new Scanner(System.in);

public void cadastrarPet() throws PetPesoException {

    System.out.println(form.getPerguntasEspec(0));
    String nome = scanner.nextLine();
    pet.setNome(validarNome(nome)); // Nome invalido exception

    System.out.println(form.getPerguntasEspec(1));
    String tipoPet = scanner.nextLine();
    pet.setTipo(PetTipo.PetTipoPorNome(tipoPet)); // Pet tipo excpetion

    System.out.println(form.getPerguntasEspec(2));
    String sexo = scanner.nextLine();
    pet.setSexo(PetSex.PetSexoPorNome(sexo)); // pet sexo exception

    /// // Faltando o endereço pergunta espc 3

    System.out.println(form.getPerguntasEspec(4));
    Double idade = scanner.nextDouble();
    pet.setIdade(validarIdade(idade)); // Idade exception

    System.out.println(form.getPerguntasEspec(5));
    Double peso = scanner.nextDouble();
    pet.setPeso(validarPeso(peso)); /// peso exception

    System.out.println(form.getPerguntasEspec(6));
    String raca = scanner.nextLine();
    pet.setRaca(raca);

}

public String validarNome(String nome){

    String regex = "/^[A-Za-zÀ-ÖØ-öø-ÿ]+( [A-Za-zÀ-ÖØ-öø-ÿ]+)+$/";
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

public double validarIdade (Double idade)throws IdadeException{

    if (idade > 20){
        throw new IdadeException();
    }
    return idade;
}
}
