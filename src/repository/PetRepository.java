package repository;

import model.Endereco;
import model.Pet;
import model.PetSex;
import model.PetTipo;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class PetRepository {

    private ArrayList<Pet> petRepository = new ArrayList<>();



    public ArrayList<Pet> getPetRepository() {
        return petRepository;
    }

    public void adicionarPet(Pet pet){
        petRepository.add(pet);
    }

    public void carregarPetsCadastrados (){

        File pasta = new File("C:\\Users\\Pedro\\IdeaProjects\\sistemaCadastro\\src\\data");
        File[] arquivos = pasta.listFiles();
        if (arquivos == null) return;

        for (File file : arquivos){
            try(BufferedReader br = new BufferedReader(new FileReader(file))){
                Pet pet = new Pet();
                pet.setNome(br.readLine().substring(3));


                pet.setTipo(PetTipo.PetTipoPorNome(br.readLine().substring(3)));


                pet.setSexo(PetSex.PetSexoPorNome(br.readLine().substring(3)));


                String enderec1[] = br.readLine().substring(3).split(",", -1);


                if (enderec1[0].isBlank() && enderec1[1].isBlank() && enderec1[2].isBlank() || enderec1.length == 1){
                    pet.setEndereco(new Endereco());
                }else {
                    Endereco endereco = new Endereco(enderec1);
                    pet.setEndereco(endereco);
                }
                String idade = br.readLine().substring(3).replace("anos", "");
                pet.setIdade(Double.valueOf(idade));


                String peso = br.readLine().substring(3).replace("Kg", "");
                pet.setPeso(Double.parseDouble(peso));


                pet.setRaca(br.readLine().substring(3));
                petRepository.add(pet);

            } catch (IOException e) {
                throw new RuntimeException(e);
            }

        }

    }

}
