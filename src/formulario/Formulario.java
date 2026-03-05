package formulario;

import java.io.*;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class Formulario {

//
//private String[] perguntas = {"1- Qual o nome e sobrenome do pet?",
//        "2- Qual o tipo do pet (Cachorro/Gato)?",
//        "3- Qual o sexo do animal?",
//        "4- Qual endereço e bairro que ele foi encontrado?",
//        "5- Qual a idade aproximada do pet?",
//        "6- Qual o peso aproximado do pet?",
//        "7- Qual a raça do pet?"};

private ArrayList<String> perguntas = new ArrayList<>(List.of("1- Qual o nome e sobrenome do pet",
        "2- Qual o tipo do pet (Cachorro/Gato)?",
        "3- Qual o sexo do animal?",
        "4- Qual endereço e bairro que ele foi encontrado?",
        "5- Qual a idade aproximada do pet?",
        "6- Qual o peso aproximado do pet?",
        "7- Qual a raça do pet?"));

private final File file = new File("C:\\Users\\Pedro\\IdeaProjects\\sistemaCadastro\\src\\data\\formulario.txt");

public void criarForm() {

    if (!file.exists() || file.length() == 0) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(file))) {

            for (String pergunta : perguntas){
                bw.write(pergunta);
                bw.newLine();
            }
        } catch (Exception e) {
            System.out.println(e.fillInStackTrace());
        }

    }
    }


public void lerForm(){

    try(BufferedReader br = new BufferedReader(new FileReader(file))){
        String linha;
        while ((linha = br.readLine()) != null){
            System.out.println(linha);
        }

    } catch (IOException e) {
        System.out.println(e.getStackTrace());
    }

}






   }

