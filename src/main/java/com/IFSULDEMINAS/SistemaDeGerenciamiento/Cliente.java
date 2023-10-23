package com.IFSULDEMINAS.SistemaDeGerenciamiento;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;


@Entity
public class Cliente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long clienteID;
    private String nome;
    private String serviço;
    private String correio;

    // Constructor
    public Cliente() {
        // Constructor vacío necesario para JPA
    }

    // Getters y Setters
    public Long getClienteID() {
        return clienteID;
    }

    public void setClienteID(Long clienteID) {
        this.clienteID = clienteID;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getServiço() {
        return serviço;
    }

    public void setServiço(String serviço) {
        this.serviço = serviço;
    }

    public String getCorreio() {
        return correio;
    }

    public void setCorreio(String correio) {
        this.correio = correio;
    }
}