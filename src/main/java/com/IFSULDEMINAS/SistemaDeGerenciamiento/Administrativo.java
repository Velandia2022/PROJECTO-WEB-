package com.IFSULDEMINAS.SistemaDeGerenciamiento;

import jakarta.persistence.*;

import java.util.List;


@Entity
public class Administrativo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    //Ajuste
    private int id;
    private int senha;
    private String tel;
    private String nome;
    private String correioEletronico;

    //Relacao e implementacao de relacoamentos
    @OneToMany(mappedBy = "administrativo")
    private List<Evento> eventos;

    // Constructor
    public Administrativo() {
        // Constructor vacío necesario para JPA
    }

    // Getters y Setters
    //Ajuste
    public int getId() {
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