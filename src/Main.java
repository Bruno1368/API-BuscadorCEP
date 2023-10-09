import br.com.buscadorcep.modelos.ConsultaCep;
import br.com.buscadorcep.modelos.Endereco;
import br.com.buscadorcep.modelos.GeradorDeArquivo;
import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException, InterruptedException {

        Scanner pergunta = new Scanner(System.in);
        Gson gson = new GsonBuilder()
                .setPrettyPrinting()
                .setFieldNamingPolicy(FieldNamingPolicy.UPPER_CAMEL_CASE)
                .create();
        String sair = "";
        List<Endereco> listaEnderecos = new ArrayList<>();

        //Endereco endereco = null;

        Endereco endereco = null;
        while (!sair.equalsIgnoreCase("sair")) {
            System.out.println("Digite um cep válido");
            String resposta = pergunta.next();

            if (resposta.equalsIgnoreCase("sair")) {
                break;
            }

            ConsultaCep cep = new ConsultaCep();

            System.out.println("Endereço: " + cep.buscaEndereco(resposta));

            endereco = cep.buscaEndereco(resposta);

            listaEnderecos.add(endereco);
        }

        GeradorDeArquivo arquivo = new GeradorDeArquivo();
        arquivo.guardaEndereco(endereco);

        System.out.println("Endereços fornecidos: " + listaEnderecos);

    }

}