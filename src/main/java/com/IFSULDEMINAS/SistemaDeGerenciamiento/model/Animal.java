package com.IFSULDEMINAS.SistemaDeGerenciamiento.model;

import jakarta.persistence.*;

import java.util.List;


@Entity
public class Animal {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long animalID;//Troque de variavel int pra long.
    private long idade; //Troque de variavel int pra long.
    private String nome;
    private String raça;
    private String descrição;
    private String nomeAdotante;
    private String estado;
    private String dataRegistro;

    //Relacao e implementacao de relacoamentos

    @OneToOne//Correcao de erro relacao adotante-animal
    private Adotante adotante;

    @ManyToMany
    @JoinTable(name = "animal-evento",joinColumns = @JoinColumn(name = "evento_id"))
    private List<Evento> eventos;



    public Animal(int animalID) {
        this.animalID = animalID;
    }//Ajuste

    public long getAnimalID() {
        return animalID;
    }

    public void setAnimalID(int animalID) {
        this.animalID = animalID;
    }// Ajuste variavel long

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public long getIdade() {
        return idade;
    } // Ajuste variavel long

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public String getRaça() {
        return raça;
    }

    public void setRaça(String raça) {
        this.raça = raça;
    }

    public String getDescrição() {
        return descrição;
    }

    public void setDescrição(String descrição) {
        this.descrição = descrição;
    }

    public String getNomeAdotante() {
        return nomeAdotante;
    }

    public void setNomeAdotante(String nomeAdotante) {
        this.nomeAdotante = nomeAdotante;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getDataRegistro() {
        return dataRegistro;
    }

    public void setDataRegistro(String dataRegistro) {
        this.dataRegistro = dataRegistro;
    }
}
