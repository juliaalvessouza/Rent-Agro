package com.example.rentagro.model;

import com.example.rentagro.helper.ConfigFirebase;
import com.google.firebase.database.DatabaseReference;

public class Usuario {

    private String nome;
    private String email;
    private String senha;
    private String idUsuario;

    public Usuario() {
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public void setIdUsuario(String idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getIdUsuario() {
        return idUsuario;
    }

    public void salvar(){
        DatabaseReference firebase = ConfigFirebase.getFirebaseDB();
        firebase.child("usuarios")
                .child(this.idUsuario)
                .setValue(this);
    }
}
