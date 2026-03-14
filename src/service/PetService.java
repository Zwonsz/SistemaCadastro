package service;

import formulario.Formulario;
import model.Endereco;
import model.Pet;
import model.PetSex;
import model.PetTipo;
import repository.PetRepository;
import util.Validador;

import java.util.ArrayList;


public class PetService {

   public  PetRepository petRepository;
    Formulario form = new Formulario();

    public PetService(PetRepository petRepository) {
        this.petRepository = petRepository;
    }

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


    public ArrayList<Pet> todosOsPetsCadastrados(){
        return  petRepository.getPetRepository();
    }


//    public void listPetsMemoria(){
//
//        for (Pet pets : petsMemoria){
//            System.out.println(pets);
//        }
}
