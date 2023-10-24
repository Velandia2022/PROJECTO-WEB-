package com.IFSULDEMINAS.SistemaDeGerenciamiento;

import jakarta.persistence.*;

import java.util.List;


@Entity
public class Animal {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int animalID;
    private int idade; //Troque de variavel Long pra int.
    private String nome;
    private String raça;
    private String descrição;
    private String nomeAdotante;
    private String estado;
    private String dataRegistro;

    //Relacao e implementacao de relacoamentos
    @OneToOne(mappedBy = "adotante")
    private Adotante adotante;

    @ManyToMany
    @JoinTable(name = "animal-evento",joinColumns = @JoinColumn(name = "evento_id"))
    private List<Evento> eventos;

    public Animal(int animalID) {
        this.animalID = animalID;
    }//Ajuste

    public int getAnimalID() {
        return animalID;
    }

    public void setAnimalID(int animalID) {
        this.animalID = animalID;
    }//Ajuste

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getIdade() {
        return idade;
    }

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
