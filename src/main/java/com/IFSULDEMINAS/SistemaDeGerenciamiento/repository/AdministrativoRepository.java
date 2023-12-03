package com.IFSULDEMINAS.SistemaDeGerenciamiento.repository;

import com.IFSULDEMINAS.SistemaDeGerenciamiento.model.Administrativo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface AdministrativoRepository extends JpaRepository<Administrativo, Long> {

    // Puedes agregar métodos personalizados aquí si es necesario
}
