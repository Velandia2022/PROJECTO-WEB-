package com.IFSULDEMINAS.SistemaDeGerenciamiento.model;

import jakarta.persistence.*;

import java.util.List;


@Entity
public class Administrativo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    //Ajuste long
    private long id;
    private int senha;
    private String tel;
    private String nome;
    private String correioEletronico;

    //Relacao e implementacao de relacoamentos
    @OneToMany(mappedBy = "administrativo")//tengo wue agragar el join columns (name ETC.. en todos los que tengan este relacionamiento)
    private List<Evento> eventos;

    // Constructor
    public Administrativo() {
        // Constructor vacío necesario para JPA
    }

    // Getters y Setters
    //Ajuste
    public long getId() {
        return id;
    }
    //Ajuste
    public void setId(int id) {
        this.id = id;
    }

    public int getSenha() {
        return senha;
    }

    public void setSenha(int senha) {
        this.senha = senha;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCorreioEletronico() {
        return correioEletronico;
    }

    public void setCorreioEletronico(String correioEletronico) {
        this.correioEletronico = correioEletronico;
    }
}