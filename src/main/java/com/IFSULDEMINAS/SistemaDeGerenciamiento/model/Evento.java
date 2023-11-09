package com.IFSULDEMINAS.SistemaDeGerenciamiento.model;

import com.IFSULDEMINAS.SistemaDeGerenciamiento.model.Administrativo;
import com.IFSULDEMINAS.SistemaDeGerenciamiento.model.Animal;
import com.IFSULDEMINAS.SistemaDeGerenciamiento.model.Cliente;
import jakarta.persistence.*;

import java.util.List;

@Entity
public class Evento {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)


    private long eventoID; //Ajuste variavel long
    private String nome;
    private String data;
    private String endereco;


    //Relacao e implementacao de relacoamentos
    @ManyToMany(mappedBy = "eventos")
    private List<Animal> animais;

    @ManyToMany(mappedBy = "eventos")
    private List<Cliente> clientes;

    @ManyToOne
    private Administrativo administrativo;
    // Constructor
    public Evento() {
        // Constructor vacío necesario para JPA
    }

    // Getters y Setters

    public long getEventoID() {
        return eventoID;
    }   //Ajuste variavel long
    //Ajuste
    public void setEventoID(int eventoID) {
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
