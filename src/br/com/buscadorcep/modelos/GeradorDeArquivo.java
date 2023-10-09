package br.com.buscadorcep.modelos;

import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.FileWriter;
import java.io.IOException;

public class GeradorDeArquivo {

    public void guardaEndereco(Endereco endereco) throws IOException {

        Gson gson = new GsonBuilder().setPrettyPrinting().setFieldNamingPolicy(FieldNamingPolicy.UPPER_CAMEL_CASE).create();

        FileWriter enderecos = new FileWriter("enderecos.json");
        enderecos.write(gson.toJson(endereco));
        enderecos.close();
    }
}
