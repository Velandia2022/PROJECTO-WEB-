package com.IFSULDEMINAS.SistemaDeGerenciamiento.model.repository;

import com.IFSULDEMINAS.SistemaDeGerenciamiento.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
public interface ClienteRepository {
    static boolean existsById(Long id) {
        return false;
    }

    static List<Cliente> findAll() {
        return null;
    }

    // Método para buscar clientes por nombre
    List<Cliente> findByNombre(String nombre);

    // Método para buscar clientes por mail
    List<Cliente> findByCorreoElectronico(String mail);

    // Operación de actualización (Update)
    static Cliente save(Cliente cliente) {
        return null;
    }

    // Operación de eliminación (Delete) por ID
    static void deleteById(Long id) {

    }

    // Operación de lectura (Read) por ID
    static Cliente findById(Long id) {
        return null;
    }

    //método para la operación de creación (Create)
    static Cliente createCliente(Cliente cliente) {
        return null;
    }
}
