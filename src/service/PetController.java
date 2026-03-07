package service;

import formulario.Formulario;
import model.Pet;

import java.util.ArrayList;
import java.util.Scanner;

public class PetController {

    Pet pet = new Pet();
    public ArrayList<Pet> respostas = new ArrayList<>();
    Formulario form = new Formulario();
    Scanner scanner = new Scanner(System.in);

public void cadastrarPet(){

    for (int i = 0; i < form.getPerguntas().size(); i++){
        System.out.println(form.getPerguntasEspec(i));
        String reposta = scanner.nextLine();
        respostas.add(reposta);
    }
    System.out.println(respostas);
}


}
