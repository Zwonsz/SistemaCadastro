package controller;

import model.Pet;
import service.PetController;

import java.util.Scanner;

public class Menu {

    private Scanner scanner = new Scanner(System.in);
    Pet pet = new Pet();
    PetController petC = new PetController();
    public void exibirMenu(){

        boolean rodar = true;
        while (rodar) {

            System.out.println("""
                1- Cadastrar novo pet
                2- Alterar os dados do pet cadastrado
                3- Deletar um pet cadastrado
                4- Listar todos os pets cadastrados
                5- Listar pets por algum critério (idade, nome, raça)
                6- Sair
                """);
            int opcao = 0;
            try {
                String entrada = scanner.nextLine();
                opcao = Integer.parseInt(entrada);
            } catch (NumberFormatException e) {
                System.out.println("Apenas opções numericas são aceitas.");
            }
            switch (opcao){
                case 1 :
                    petC.cadastrarPet();
                    break;
                case 2 :
                    System.out.println("2");
                    break;
                case 3 :
                    System.out.println("3");
                    break;
                case 4 :
                    System.out.println("4");
                    break;
                case 5 :
                    System.out.println("5");
                    break;
                case 6 :
                    rodar = false;
                    break;
                default :
                    System.out.println("Opção selecionada inválida. Por favor, selecione uma opção válida\n");
                    break;

            }
        }




    }


}
