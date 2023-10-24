package com.IFSULDEMINAS.SistemaDeGerenciamiento;

import jakarta.persistence.*;

import java.util.List;


@Entity
public class Cliente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    //Ajuste
    private int clienteID;
    private String nome;
    private String serviço;
    private String correio;

    //Relacao e implementacao de relacoamentos
    @OneToOne
    private Adotante adotante;

    @ManyToMany
    @JoinTable(name = "cliente_evento",joinColumns = @JoinColumn(name ="clientes_id"),inverseJoinColumns = @JoinColumn(name = "evento_id"))
    private List<Evento> eventos;
    // Constructor
    public Cliente() {
        // Constructor vacío necesario para JPA
    }

    // Getters y Setters
    //Ajuste
    public int getClienteID() {
        return clienteID;
    }
    //Ajuste
    public void setClienteID(int clienteID) {
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