package com.IFSULDEMINAS.SistemaDeGerenciamiento.repository;

import com.IFSULDEMINAS.SistemaDeGerenciamiento.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {

    // Metodos

}
