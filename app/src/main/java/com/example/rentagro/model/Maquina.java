package com.example.rentagro.model;

import java.io.Serializable;

public class Maquina implements Serializable {

    private final String nome;
    private final String imagem;
    private final String dias;
    private final String preco;
    private final String telefone;
    private final String cidade;
//    private final String descricao;



    public Maquina(String local, String imagem, String dias, String preco, String telefone, String cidade) {
        this.nome = local;
        this.imagem = imagem;
        this.dias = dias;
        this.preco = preco;
        this.telefone = telefone;
        this.cidade = cidade;
//        this.descricao = descricao;
    }

//    public String getDescricao() {return descricao; }

    public String getTelefone() {
        return telefone;
    }

    public String getCidade() {
        return cidade;
    }

    public String getNome() {
        return nome;
    }

    public String getImagem() {
        return imagem;
    }

    public String getDias() {
        return dias;
    }

    public String getPreco() {
        return preco;
    }

}

