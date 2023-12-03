package com.IFSULDEMINAS.SistemaDeGerenciamiento.controller;

import com.IFSULDEMINAS.SistemaDeGerenciamiento.exceptions.ClienteNotFundException;
import com.IFSULDEMINAS.SistemaDeGerenciamiento.model.Cliente;

import com.IFSULDEMINAS.SistemaDeGerenciamiento.repository.ClienteRepository;
import com.IFSULDEMINAS.SistemaDeGerenciamiento.services.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.ArrayList;
import java.util.Optional;

//clase con ejemplos
@RestController
@RequestMapping("/clientes")
public class ClienteController {
    @Autowired
    private ClienteRepository clienteRepository;
    @Autowired
    private ClienteService clienteService;

    // Obtener todos los clientes
    @GetMapping
    public ResponseEntity<List<Cliente>> obtenerTodosLosClientes() {
        List<Cliente> clientes = clienteService.obtenerTodosLosClientes();
        return ResponseEntity.ok(clientes);
    }



    // Crear un nuevo cliente
    @PostMapping
    public ResponseEntity<Cliente> crearCliente( @RequestBody Cliente nuevoCliente) {
        Cliente clienteCreado = clienteService.crearCliente(nuevoCliente);
        return ResponseEntity.status(HttpStatus.CREATED).body(clienteCreado);
    }

    // Actualizar un cliente existente
    @PutMapping("/{clienteID}")
    public ResponseEntity<Cliente> actualizarCliente(@PathVariable long clienteID, @RequestBody Cliente clienteActualizado) {
        try {
            Cliente cliente = clienteService.actualizarCliente(clienteID, clienteActualizado);
            return ResponseEntity.ok(cliente);
        } catch (ClienteNotFoundException ex) {
            return ResponseEntity.notFound().build();
        }
    }

    // Eliminar un cliente por ID
    @DeleteMapping("/{clienteID}")
    public ResponseEntity<Void> eliminarCliente(@PathVariable long clienteID) {
        try {
            clienteService.eliminarCliente(clienteID);
            return ResponseEntity.noContent().build();
        } catch (ClienteNotFoundException ex) {
            return ResponseEntity.notFound().build();
        }
    }




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
        //AGREGACAO Clientenotfundexception
        try {
            Optional<Cliente> clienteOptional = clienteRepository.findById(clienteID);
            return clienteOptional.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
        }catch (ClienteNotFundException ex){
            return ResponseEntity.notFound().build();
        }
    }

    // UPDATE
    @PutMapping("/{clienteID}")
    public ResponseEntity<Cliente> atualizarCliente(@PathVariable long clienteID, @RequestBody Cliente clienteAtualizado) {
        Optional<Cliente> clienteOptional = clienteRepository.findById(clienteID);
try{
    Cliente clienteExistente = clienteOptional.get();
    clienteExistente.setNome(clienteAtualizado.getNome());
    clienteExistente.setServiço(clienteAtualizado.getServiço());
    clienteExistente.setCorreio(clienteAtualizado.getCorreio());
    return ResponseEntity.ok(clienteRepository.save(clienteExistente));
}catch (ClienteNotFundException ex){
    return ResponseEntity.notFound().build();
}

    }

    // DELETE
    @DeleteMapping("/{clienteID}")
    public ResponseEntity<Void> excluirCliente(@PathVariable long clienteID) {
        Optional<Cliente> clienteOptional = clienteRepository.findById(clienteID);
try {
    clienteRepository.deleteById(clienteID);
    return ResponseEntity.noContent().build();
}catch (ClienteNotFundException ex){
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
