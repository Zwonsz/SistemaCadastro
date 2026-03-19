package service;

import formulario.Formulario;
import model.Endereco;
import model.Pet;
import model.PetSex;
import model.PetTipo;
import repository.PetRepository;
import util.Validador;

import java.awt.*;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Locale;
import java.util.Scanner;


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

 public boolean comparador(Pet pet, String criterio, String valor){
    criterio = criterio.toLowerCase();
        switch (criterio){

            case "nome":
              return pet.getNome().toLowerCase().contains(valor.toLowerCase());
            case "sexo":
                return pet.getSexo().toString().equals(valor.toUpperCase());
            case "idade":
                return pet.getIdade().equals(Double.parseDouble(valor));
            case "peso":
                return pet.getPeso().equals(Double.parseDouble(valor));
            case "raca":
                return pet.getRaca().equalsIgnoreCase(valor);
            default:
                return false;

        }
 }

 public ArrayList<Pet> buscador(String criterio, String valor, String criterio2, String valor2){
     ArrayList<Pet> matches = new ArrayList<>();
     for(Pet pet : todosOsPetsCadastrados()){
         Boolean criterioBoolean1 = comparador(pet, criterio, valor);
         Boolean criterioBoolean2 = true;
            if (!(criterio2 == null) && !(valor2 == null)){
                criterioBoolean2 = comparador(pet, criterio2, valor2);
            }

         if (criterioBoolean1 && criterioBoolean2){
             matches.add(pet);
         }


     }
     return matches;

 }

public Pet alterarInformacoes( String atributo, String novoValorAtributo, ArrayList<Pet> list, int index, Endereco endereco){

        Pet pet = list.get(index);
    Scanner scanner = new Scanner(System.in);
        String r = atributo.toLowerCase().replace("ç", "c");
switch (r){
    case "nome":
        pet.setNome(novoValorAtributo);
        break;
    case "idade":
        pet.setIdade(Double.parseDouble(novoValorAtributo));
        break;
    case "peso":
        pet.setPeso(Double.parseDouble(novoValorAtributo));
        break;
    case "raca":
        pet.setRaca(novoValorAtributo);
        break;
    case "endereco":
        pet.setEndereco(endereco);
        break;
    default:
        System.out.println("Atributo não disponível para edição, tente novamente.");
        break;
}
return pet;


 }

}
