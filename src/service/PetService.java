package service;

import exceptions.IdadeException;
import exceptions.NomeInvalidoException;
import exceptions.PetPesoException;
import formulario.Formulario;
import model.Endereco;
import model.Pet;
import model.PetSex;
import model.PetTipo;
import repository.PetRepository;
import util.Validador;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PetService {

    PetRepository petRepository = new PetRepository();
    Formulario form = new Formulario();

    public void cadastrarPet(String nomePet, String tipopet, String sexoPet, Endereco endereco,
                             Double idade,
                             Double peso,
                             String raca) {
        Validador validador = new Validador();
        Pet pet = new Pet();
        pet.setNome(validador.validarNome(nomePet));
        pet.setTipo(PetTipo.PetTipoPorNome(tipopet));
        pet.setSexo(PetSex.PetSexoPorNome(sexoPet));
        pet.setEndereco(endereco);
        pet.setIdade(validador.validarIdade(idade));
        pet.setPeso(validador.validarPeso(peso));
        pet.setRaca(raca);
        form.criarPetCadastrado(pet);
        petRepository.adicionarPet(pet);

    }


//    public void listPetsMemoria(){
//
//        for (Pet pets : petsMemoria){
//            System.out.println(pets);
//        }
}
