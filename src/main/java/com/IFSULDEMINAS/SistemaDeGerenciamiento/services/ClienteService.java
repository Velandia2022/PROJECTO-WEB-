package com.IFSULDEMINAS.SistemaDeGerenciamiento.services;

import com.IFSULDEMINAS.SistemaDeGerenciamiento.model.Cliente;

import java.util.List;

public class ClienteService {
private com.IFSULDEMINAS.SistemaDeGerenciamiento.repository.clienteRepository clienteRepository;



public Cliente save(Cliente cliente){
    Cliente save = com.IFSULDEMINAS.SistemaDeGerenciamiento.repository.clienteRepository.save(cliente);
    return save;
}

public List<Cliente> list() {
    return com.IFSULDEMINAS.SistemaDeGerenciamiento.repository.clienteRepository.findAll();

}}