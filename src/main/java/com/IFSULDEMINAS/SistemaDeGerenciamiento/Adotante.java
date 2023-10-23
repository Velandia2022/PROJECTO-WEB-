package com.IFSULDEMINAS.SistemaDeGerenciamiento;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;


@Entity
public class Adotante {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long adoptanteID;
    private String nome;
    private String enderecoResidencia;
    private String correioEletronico;
    private String statusDeAdocao;
    private String tel;

    // Constructor
    public Adotante() {
        // Constructor vacío necesario para JPA
    }

    // Getters y Setters
    public Long getAdotanteID() {
        return adoptanteID;
    }

    public void setAdotanteID(Long adoptanteID) {
        this.adoptanteID = adoptanteID;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEnderecoResidencia() {
        return enderecoResidencia;
    }

    public void setEnderecoResidencia(String enderecoResidencia) {
        this.enderecoResidencia = enderecoResidencia;
    }

    public String getCorreioEletronico() {
        return correioEletronico;
    }

    public void setCorreioEletronico(String correioEletronico) {
        this.correioEletronico = correioEletronico;
    }

    public String getStatusDeAdocao() {
        return statusDeAdocao;
    }

    public void setStatusDeAdocao(String statusDeAdocao) {
        this.statusDeAdocao = statusDeAdocao;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }
}