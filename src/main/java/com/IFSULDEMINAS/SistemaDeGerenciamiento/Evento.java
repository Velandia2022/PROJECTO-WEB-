package com.IFSULDEMINAS.SistemaDeGerenciamiento;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Evento {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long eventoID;
    private String nome;
    private String data;
    private String endereco;

    // Constructor
    public Evento() {
        // Constructor vacío necesario para JPA
    }

    // Getters y Setters
    public Long getEventoID() {
        return eventoID;
    }

    public void setEventoID(Long eventoID) {
        this.eventoID = eventoID;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }
}
