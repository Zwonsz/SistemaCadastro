package controller;


import exceptions.PetPesoException;
import formulario.Formulario;
import model.Endereco;
import model.Pet;
import repository.PetRepository;
import service.PetService;


import java.util.ArrayList;
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

public void buscarPorCritério(){

    System.out.println("""
            Escolha até dois dos seguintes critérios de busca:
   
            1 - Nome
            2 - Sexo
            3 - Idade
            4 - Peso
            5 - Raça
            """);

    String criterio1 = scanner.nextLine().toLowerCase();
    System.out.println("""
            Escolha o segundo criterio ou aperte enter para pular:
   
            1 - Nome
            2 - Sexo
            3 - Idade
            4 - Peso
            5 - Raça
            """);
    String criterio2 = scanner.nextLine().toLowerCase();

    System.out.println("Digite agora o " + criterio1 + " para a busca:");

    String valor1 = scanner.nextLine();

    String valor2;

    if (criterio2.isBlank()){
        criterio2 = null;
        valor2 = null;
    }else {System.out.println("Digite agora o " + criterio2 + " para a busca:");
         valor2 = scanner.nextLine();}

    ArrayList<Pet> resultadoBusca = petService.buscador(criterio1,valor1,criterio2,valor2);
    if (resultadoBusca.isEmpty()){
        System.out.println("Não foram encontrados nenhum Pet que se encaixe nos parametros fornecidos. Tente novamente com outros parametros.\n");
    }else {
        for (Pet pet : resultadoBusca){
            System.out.println(pet.getNome() + " - " + pet.getTipo() + " - " + pet.getSexo() + " - " + pet.getEndereco() +
                    " - " + pet.getIdade() + " - " + pet.getPeso() + " - " + pet.getRaca());
        }
    }




}



}








