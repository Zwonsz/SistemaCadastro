package formulario;

import exceptions.ListaVaziaException;
import exceptions.SelecaoPetException;
import model.Endereco;
import model.Pet;

import java.io.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Formulario {


    private ArrayList<String> perguntas = new ArrayList<>(List.of("1- Qual o nome e sobrenome do pet",
            "2- Qual o tipo do pet (Cachorro/Gato)?",
            "3- Qual o sexo do animal?(Masculino/Femino)",
            "4- Qual endereço e bairro que ele foi encontrado?",
            "5- Qual a idade aproximada do pet?",
            "6- Qual o peso aproximado do pet?",
            "7- Qual a raça do pet?"));

    public ArrayList<String> getPerguntas() {
        return perguntas;
    }

    public String getPerguntasEspec(int i) {

        return perguntas.get(i);

    }

    private final File file = new File("C:\\Users\\Pedro\\IdeaProjects\\sistemaCadastro\\src\\form\\formulario.txt");

    public void criarForm() {

        if (!file.exists() || file.length() == 0) {
            try (BufferedWriter bw = new BufferedWriter(new FileWriter(file))) {

                for (String pergunta : perguntas) {
                    bw.write(pergunta);
                    bw.newLine();
                }
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }

        }
    }


    public void lerForm() {

        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String linha;
            while ((linha = br.readLine()) != null) {
                System.out.println(linha);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void criarPetCadastrado(Pet pet) {

        LocalDateTime agora = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH-mm");
        File filePet = new File("C:\\Users\\Pedro\\IdeaProjects\\sistemaCadastro\\src\\data\\" + agora.format(formatter) + "-" + pet.getNome().toUpperCase().replace(" ", "") + ".txt");
        pet.setCaminhoArquivo(filePet.getAbsolutePath());
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(filePet))) {

            bw.write("1- " + pet.getNome());
            bw.newLine();
            bw.write("2- " + pet.getTipo());
            bw.newLine();
            bw.write("3- " + pet.getSexo());
            bw.newLine();
            bw.write("4- " + pet.getEndereco());
            bw.newLine();
            bw.write("5- " + pet.getIdade() + " anos");
            bw.newLine();
            bw.write("6- " + pet.getPeso() + " Kg");
            bw.newLine();
            bw.write("7- " + pet.getRaca());
            bw.newLine();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    public void exibirMenuBusca() {
        System.out.println("""
                Escolha dos seguintes critérios de busca:
                
                1 - Nome
                2 - Sexo
                3 - Idade
                4 - Peso
                5 - Raça
                """);
    }

    public void exibirMenuAtributoParaEditar() {
        System.out.println("""
                  Digite qual atributo deseja editar:
                
                  Nome
                  Idade
                  Peso
                  Raça
                  Endereço
                \n
                """);
    }

    public Endereco criarEndereco(Scanner scanner) {
        System.out.println("Digite o numero:");
        String numero = scanner.nextLine();
        System.out.println("Digite a cidade:");
        String cidade = scanner.nextLine();
        System.out.println("Digite a rua: ");
        String rua = scanner.nextLine();
        Endereco endereco = new Endereco(numero, cidade, rua);
        return endereco;
    }


    public void listarPetsEmLista(ArrayList<Pet> list) {

        int i = 1;
        for (Pet pet : list) {
            System.out.println(i + " - " + pet.getNome() + " - " + pet.getTipo() + " - " + pet.getSexo() + " - " + pet.getEndereco() +
                    " - " + pet.getIdade() + " - " + pet.getPeso() + " - " + pet.getRaca());
            i++;

        }
    }





    }







