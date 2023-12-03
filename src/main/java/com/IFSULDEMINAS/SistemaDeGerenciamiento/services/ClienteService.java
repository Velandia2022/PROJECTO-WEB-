package com.IFSULDEMINAS.SistemaDeGerenciamiento.services;

import com.IFSULDEMINAS.SistemaDeGerenciamiento.exceptions.ClienteNotFundException;
import com.IFSULDEMINAS.SistemaDeGerenciamiento.model.Cliente;
import com.IFSULDEMINAS.SistemaDeGerenciamiento.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import java.util.List;
@Service
public class ClienteService {
    @Autowired
    private ClienteRepository clienteRepository;

// Metodos para la logica

    // Obtener todos los clientes
    public List<Cliente> obtenerTodosLosClientes() {
        return clienteRepository.findAll();
    }
    public Cliente buscarClientePorId(long clienteID) {
        return clienteRepository.findById(clienteID).orElseThrow(() -> new ClienteNotFundException("Cliente no encontrado" + clienteID));
    }

    // Crear un nuevo cliente
    public Cliente crearCliente(@Validated Cliente nuevoCliente) {
        // Aquí puedes agregar lógica de validación u otras operaciones antes de guardar
        return clienteRepository.save(nuevoCliente);
    }

    // Actualizar un cliente existente
    public Cliente actualizarCliente(long clienteID, @Validated Cliente clienteActualizado) {
        if (!clienteRepository.existsById(clienteID)) {
            throw new ClienteNotFundException("Cliente no encontrado con ID: " + clienteID);
        }

        // Aquí puedes agregar lógica de validación u otras operaciones antes de guardar
        clienteActualizado.setClienteID(clienteID);
        return clienteRepository.save(clienteActualizado);
    }

    // Eliminar un cliente por ID
    public void eliminarCliente(long clienteID) {
        if (!clienteRepository.existsById(clienteID)) {
            throw new ClienteNotFundException("Cliente no encontrado con ID: " + clienteID);
        }

        clienteRepository.deleteById(clienteID);
    }

    


}
