package com.IFSULDEMINAS.SistemaDeGerenciamiento.services;

import com.IFSULDEMINAS.SistemaDeGerenciamiento.exceptions.ClienteNotFundException;
import com.IFSULDEMINAS.SistemaDeGerenciamiento.model.Cliente;
import com.IFSULDEMINAS.SistemaDeGerenciamiento.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ClienteService {
    @Autowired
    private ClienteRepository clienteRepository;

// Metodos para la logica

    public Cliente buscarClientePorId (long clienteID){
        return clienteRepository.findById(clienteID).orElseThrow(()->new ClienteNotFundException("Cliente no encontrado" + clienteID));
    }
}
