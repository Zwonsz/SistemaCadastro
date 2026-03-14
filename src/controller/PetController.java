package controller;


import exceptions.PetPesoException;
import formulario.Formulario;
import model.Endereco;
import model.Pet;
import repository.PetRepository;
import service.PetService;


import java.util.Scanner;


public class PetController {

    private PetRepository petRepository;
    private Formulario form = new Formulario();
    private Scanner scanner = new Scanner(System.in);
    private PetService petService;

    public PetController(PetRepository petRepository) {
        this.petRepository = petRepository;
        this.petService = new PetService(petRepository);
    }


    public void cadastrarPet() throws PetPesoException {
    Pet pet = new Pet();

//    Carregar pets na memória

    System.out.println(form.getPerguntasEspec(0));
    String nome = scanner.nextLine();

    System.out.println(form.getPerguntasEspec(1));
    String tipoPet = scanner.nextLine();

    System.out.println(form.getPerguntasEspec(2));
    String sexo = scanner.nextLine();

    System.out.println(form.getPerguntasEspec(3));
    System.out.println("\nQual o numero da casa?");
    String enredecoCasa = scanner.nextLine();
    System.out.println("Qual o nome da cidade?");
    String cidadeNome = scanner.nextLine();
    System.out.println("Qual rua?");
    String nomeRua = scanner.nextLine();
    Endereco endereco = new Endereco(enredecoCasa, cidadeNome, nomeRua);

    System.out.println(form.getPerguntasEspec(4));
    Double idade = scanner.nextDouble();

    System.out.println(form.getPerguntasEspec(5));
    Double peso = scanner.nextDouble();

    System.out.println(form.getPerguntasEspec(6));
    scanner.nextLine();
    String raca = scanner.nextLine();

    petService.cadastrarPet(nome,tipoPet,sexo,endereco,idade,peso,raca);

}

public void listarTodosOsPetsCadastrados(){
    for (Pet pet : petService.todosOsPetsCadastrados()){
        System.out.println(pet);
    }
}





}








