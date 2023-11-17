package com.IFSULDEMINAS.SistemaDeGerenciamiento.controller;

import com.IFSULDEMINAS.SistemaDeGerenciamiento.model.Cliente;
import com.IFSULDEMINAS.SistemaDeGerenciamiento.model.repository.ClienteRepository;

import jakarta.persistence.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.ArrayList;
//clase con ejemplos
@Controller
public class ClienteController {
    private ClienteRepository clienterepository;

    @GetMapping("/clientes")

    //Operacao Create
    @PostMapping // este metodo trata adquiciciones
    public Cliente save(@RequestBody Cliente evento) {

        return evento;
    }

    // Operacion Create
    @PostMapping
    public ResponseEntity<Cliente> createCliente(@RequestBody Cliente cliente) {
        Cliente clienteCreado = ClienteRepository.createCliente(cliente);
        return new ResponseEntity<>(clienteCreado, HttpStatus.CREATED);
    }

    // Operacion Read (Obtener todos los clientes)
    @GetMapping
    public ResponseEntity<List<Cliente>> getAllClientes() {
        List<Cliente> clientes = ClienteRepository.findAll();
        return new ResponseEntity<>(clientes, HttpStatus.OK);
    }

    // Operacion Read (Obtener un cliente por ID)
    @GetMapping("/{id}")
    public ResponseEntity<Cliente> getClienteById(@PathVariable Long id) {
        // Manejar la posibilidad de que el cliente no exista
        Cliente cliente = ClienteRepository.findById(id).orElse(null);

        if (cliente != null) {
            return new ResponseEntity<>(cliente, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // Operación Update
    @PutMapping("/{id}")
    public ResponseEntity<Cliente> updateCliente(@PathVariable Long id, @RequestBody Cliente cliente) {
        // Verificar si el cliente con el ID proporcionado existe
        if (ClienteRepository.existsById(id)) {
            cliente.setId(id);
            Cliente clienteActualizado = ClienteRepository.save(cliente);
            return new ResponseEntity<>(clienteActualizado, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // Operación Delete
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCliente(@PathVariable Long id) {
        // Verificar si el cliente con el ID proporcionado existe
        if (ClienteRepository.existsById(id)) {
            ClienteRepository.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }




    public String listarClientes(Model model) {
        // Simula cargar datos de clientes desde una fuente.
        List<Cliente> clientes = obtenerClientesDesdeFuente();

        // Agrega la lista de clientes al modelo.
        model.addAttribute("clientes", clientes);

        return "lista-clientes"; //Muestra la lista de clientes
    }

    private List<Cliente> obtenerClientesDesdeFuente() {
        // Implementacion de logica para una muestra
        // simular datos
        List<Cliente> clientes = new ArrayList<>();
        clientes.add(new Cliente(1L, "Alex", "Servicio 1", "nocua68@gmail.com"));
        clientes.add(new Cliente(2L, "Miguel", "Servicio 2", "velandia0903@gmail.com"));
        clientes.add(new Cliente(3L, "Francelli", "Servicio 3", "fracelli@ifsuldeminas.com"));
        return clientes;
    }
}
