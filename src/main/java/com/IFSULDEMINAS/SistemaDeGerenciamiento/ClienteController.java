package com.IFSULDEMINAS.SistemaDeGerenciamiento;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;
import java.util.ArrayList;
//clase con ejemplos
@Controller
public class ClienteController {
    @GetMapping("/clientes")
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
