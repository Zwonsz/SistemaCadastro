package controller;


import exceptions.ListaVaziaException;
import exceptions.PetPesoException;
import exceptions.SelecaoPetException;
import formulario.Formulario;
import model.Endereco;
import model.Pet;
import repository.PetRepository;
import service.PetService;
import util.Validador;


import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;


public class PetController {

    private PetRepository petRepository;
    private Formulario form = new Formulario();
    private Scanner scanner = new Scanner(System.in);
    private PetService petService;
    private Validador validador;

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

        petService.cadastrarPet(nome, tipoPet, sexo, endereco, idade, peso, raca);

    }

    public void listarTodosOsPetsCadastrados() {
        for (Pet pet : petService.todosOsPetsCadastrados()) {
            System.out.println(pet);
        }
    }

    public ArrayList buscarPorCriterio() {

       String[] resultados = coletarCriteriosParaBusca();
        ArrayList<Pet> resultadoBusca = realizarBuscaPorCriterios(resultados[0],resultados[1],resultados[2],resultados[3]);
        form.listarPetsEmLista(resultadoBusca);
        return resultadoBusca;
    }


    public void alterarInformacoesPet() {


        while (true) {
            try {
                String[] resultados = coletarCriteriosParaBusca();
                ArrayList<Pet> resultadoBusca = petService.buscador(resultados[0], resultados[1], resultados[2], resultados[3]);
                if (resultadoBusca.isEmpty()){
                    System.out.println("Nenhum pet encontrado");
                    continue;
                }
                form.listarPetsEmLista(resultadoBusca);
                int index = selecionarPet(resultadoBusca);
                form.exibirMenuAtributoParaEditar();
                String atributo = selecionarAtributoParaEditar(scanner);
                Endereco endereco = null;
                String novoValorAtributo = null;
                if (atributo.equals("endereco")) {
                    endereco = form.criarEndereco(scanner);
                } else {
                    System.out.println("\nDigite o novo valor de " + atributo + ":\n");
                    novoValorAtributo = scanner.nextLine();
                }
                Pet pet = petService.alterarInformacoes(atributo, novoValorAtributo, resultadoBusca, index, endereco);
                petRepository.atualizarPet(pet);
                break;

            } catch (IllegalArgumentException | ListaVaziaException | SelecaoPetException e) {
                System.out.println(e.getMessage());
                continue;
            }


        }


    }


    public int selecionarPet(ArrayList<Pet> resultadoBusca) {
        System.out.println("\nDigite o numero do pet que deseja selecionar: \n");
        String entrada = scanner.nextLine();
        try {
            int index = Integer.parseInt(entrada);
            index -= 1;

            if (index < 0 || index >= resultadoBusca.size()) {
                throw new SelecaoPetException("Selecione um Pet válido");
            }

            return index;

        } catch (NumberFormatException e) {
            throw new SelecaoPetException("Digite um número válido");
        }


    }

    public String selecionarAtributoParaEditar(Scanner scanner) {

        try {
            String atributo = validador.validarAtributoEditavel(scanner.nextLine());
            return atributo;

        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    public String[] coletarCriteriosParaBusca(){

        form.exibirMenuBusca();
        String criterio1 = validador.validarCriterioBusca(scanner.nextLine());
        form.exibirMenuBusca();
        String criterio2 = validador.validarCriterioBusca(scanner.nextLine());

        System.out.println("Digite agora o " + criterio1 + " para a busca:");

        String valor1 = scanner.nextLine();

        String valor2;

        if (criterio2.isBlank()) {
            criterio2 = null;
            valor2 = null;
        } else {
            System.out.println("Digite agora o " + criterio2 + " para a busca:");
            valor2 = scanner.nextLine();
        }
        return new String[]{criterio1,valor1,criterio2,valor2};
    }

    public ArrayList<Pet> realizarBuscaPorCriterios(String criterio1, String valor1, String criterio2, String valor2) {


        ArrayList<Pet> resultadoBusca = petService.buscador(criterio1, valor1, criterio2, valor2);
        if (resultadoBusca.isEmpty()) {
            throw new ListaVaziaException("Não foram encontrados nenhum Pet que se encaixe nos parametros fornecidos");
        }
        return resultadoBusca;


    }

}








