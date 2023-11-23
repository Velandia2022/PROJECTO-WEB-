package com.IFSULDEMINAS.SistemaDeGerenciamiento.services;

import com.IFSULDEMINAS.SistemaDeGerenciamiento.exceptions.ClienteNotFundException;
import com.IFSULDEMINAS.SistemaDeGerenciamiento.model.Cliente;
import com.IFSULDEMINAS.SistemaDeGerenciamiento.model.repository.ClienteRepository;

import java.util.List;
import java.util.Optional;

public class ClienteService {
private ClienteRepository clienteRepository;

public ClienteService(ClienteRepository clienteRepository){
    this.clienteRepository = clienteRepository;
}

public Cliente save(Cliente cliente){
    Cliente save = ClienteRepository.save(cliente);
    return save;
}

public List<Cliente> list(){
    return ClienteRepository.findAll();
}
public Cliente getID throws void ClienteNotFundException(Long ID){
    Optional<Cliente> clt = clienteRepository.findID(ID);
    if(!clt.isPresent()){
        throw new ClienteNotFundException(ID);
    }
    return; clt.get();
    }
}
