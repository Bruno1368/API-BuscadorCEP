package br.com.buscadorcep.modelos;

public class Endereco {
    private String cep;
    private String logradouro;
    private String bairro;
    private String localidade;

    public Endereco(String cep) {
        this.cep = cep;
    }

    public String getCep() {
        return cep;
    }

    public String getLogradouro() {
        return logradouro;
    }

    public String getBairro() {
        return bairro;
    }

    public String getLocalidade() {
        return localidade;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public void setLogradouro(String logradouro) {
        this.logradouro = logradouro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public void setLocalidade(String localidade) {
        this.localidade = localidade;
    }

    @Override
    public String toString() {
        return "(Cep: " + this.cep + ", logradouro: " + this.logradouro + ", bairro: " + this.bairro + ", Localidade: " + this.localidade + ") ";
    }
}
