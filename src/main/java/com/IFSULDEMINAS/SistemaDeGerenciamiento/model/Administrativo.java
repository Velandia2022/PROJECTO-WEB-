package com.IFSULDEMINAS.SistemaDeGerenciamiento.model;

import jakarta.persistence.*;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.OneToMany;
import org.springframework.data.annotation.Id;

import java.util.List;


import javax.persistence.*;
import java.util.List;

@Entity
public class Administrativo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private int senha;
    private String tel;
    private String nome;
    private String correioEletronico;

    @OneToMany(mappedBy = "administrativo")
    private List<Evento> eventos;

    public Administrativo() {
        // Constructor vacío necesario para JPA
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
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
