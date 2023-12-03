package com.IFSULDEMINAS.SistemaDeGerenciamiento.controller;

import com.IFSULDEMINAS.SistemaDeGerenciamiento.model.Cliente;

import com.IFSULDEMINAS.SistemaDeGerenciamiento.repository.clienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.ArrayList;
import java.util.Optional;

//clase con ejemplos
@Controller
public class ClienteController {
    @Autowired
    private com.IFSULDEMINAS.SistemaDeGerenciamiento.repository.clienteRepository clienteRepository;

    // CREATE
    @PostMapping
    public Cliente criarCliente(@RequestBody Cliente cliente) {
        return clienteRepository.save(cliente);
    }

    // READ
    @GetMapping
    public List<Cliente> listarClientes() {
        return clienteRepository.findAll();
    }

    @GetMapping("/{clienteID}")
    public ResponseEntity<Cliente> buscarClientePorId(@PathVariable long clienteID) {
        Optional<Cliente> clienteOptional = clienteRepository.findById(clienteID);
        return clienteOptional.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    // UPDATE
    @PutMapping("/{clienteID}")
    public ResponseEntity<Cliente> atualizarCliente(@PathVariable long clienteID, @RequestBody Cliente clienteAtualizado) {
        Optional<Cliente> clienteOptional = clienteRepository.findById(clienteID);

        if (clienteOptional.isPresent()) {
            Cliente clienteExistente = clienteOptional.get();
            clienteExistente.setNome(clienteAtualizado.getNome());
            clienteExistente.setServiço(clienteAtualizado.getServiço());
            clienteExistente.setCorreio(clienteAtualizado.getCorreio());

            return ResponseEntity.ok(clienteRepository.save(clienteExistente));
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // DELETE
    @DeleteMapping("/{clienteID}")
    public ResponseEntity<Void> excluirCliente(@PathVariable long clienteID) {
        Optional<Cliente> clienteOptional = clienteRepository.findById(clienteID);

        if (clienteOptional.isPresent()) {
            clienteRepository.deleteById(clienteID);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
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
    //git prova de commit
    private String Hola;
}
