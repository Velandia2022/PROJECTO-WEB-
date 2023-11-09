package com.IFSULDEMINAS.SistemaDeGerenciamiento.model;

import jakarta.persistence.*;

import java.util.List;


@Entity
public class Cliente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)


    private long clienteID; //Ajuste variavel long
    private String nome;
    private String servico;
    private String correio;

    //Relacao e implementacao de relacoamentos
    @OneToOne
    private Adotante adotante;

    @ManyToMany
    @JoinTable(name = "cliente_evento",joinColumns = @JoinColumn(name ="clientes_id"),inverseJoinColumns = @JoinColumn(name = "evento_id"))
    private List<Evento> eventos;


    // Constructor
    //correccion del constructor para simular datos
    public Cliente(long l, String maría, String s, String mail) {
    }

    // Getters y Setters

    public long getClienteID() {
        return clienteID;
    }  //Ajuste variavel long
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
        return servico;
    } //ajuste na escrita servico

    public void setServiço(String serviço) {
        this.servico = servico;
    }

    public String getCorreio() {
        return correio;
    }

    public void setCorreio(String correio) {
        this.correio = correio;
    }
}