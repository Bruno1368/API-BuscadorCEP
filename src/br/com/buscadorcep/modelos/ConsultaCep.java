package br.com.buscadorcep.modelos;

import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ConsultaCep {

    public Endereco buscaEndereco(String cep) {
        URI endereco = URI.create("https://viacep.com.br/ws/" + cep + "/json/");

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(endereco)
                .build();
        try {
            HttpResponse<String> response = client
                    .send(request, HttpResponse.BodyHandlers.ofString());
            // Verifique o código de status da resposta HTTP
            if (response.statusCode() == 200) {
                Gson gson = new Gson();
                return gson.fromJson(response.body(), Endereco.class);
            } else {
                System.out.println("Erro ao encontrar endereço pelo CEP solicitado");
            }
        } catch (IOException | InterruptedException | JsonSyntaxException | IllegalStateException e) {
            System.out.println("Erro ao encontrar endereço pelo CEP solicitado");
        }

        return null; // Retorna null em caso de erro
    }

}
