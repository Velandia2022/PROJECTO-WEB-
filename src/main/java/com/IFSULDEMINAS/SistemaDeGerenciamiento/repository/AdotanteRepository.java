package com.IFSULDEMINAS.SistemaDeGerenciamiento.repository;

import com.IFSULDEMINAS.SistemaDeGerenciamiento.model.Adotante;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdotanteRepository extends JpaRepository<Adotante, Long> {
    // Puedes agregar métodos personalizados aquí si es necesario pero Por CRUD Se hace automatico
}
