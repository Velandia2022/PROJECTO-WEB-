package com.IFSULDEMINAS.SistemaDeGerenciamiento.services;

import com.IFSULDEMINAS.SistemaDeGerenciamiento.exceptions.AdministrativoNotFoundException;
import com.IFSULDEMINAS.SistemaDeGerenciamiento.model.Administrativo;
import com.IFSULDEMINAS.SistemaDeGerenciamiento.repository.AdministrativoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import java.util.List;

@Service
public class AdministrativoService {

    @Autowired
    private AdministrativoRepository administrativoRepository;

    public List<Administrativo> obtenerTodosLosAdministrativos() {
        return administrativoRepository.findAll();
    }

    public Administrativo buscarAdministrativoPorId(long administrativoId) {
        return (Administrativo) administrativoRepository.findById(administrativoId)
                .orElseThrow(() -> new AdministrativoNotFoundException("Administrativo no encontrado con ID: " + administrativoId));
    }

    public Administrativo crearAdministrativo(@Validated Administrativo nuevoAdministrativo) {
        return administrativoRepository.save(nuevoAdministrativo);
    }

    public Administrativo actualizarAdministrativo(long administrativoId,  Administrativo administrativoActualizado) {
        if (!administrativoRepository.existsById(administrativoId)) {
            throw new AdministrativoNotFoundException("Administrativo no encontrado con ID: " + administrativoId);
        }

        administrativoActualizado.setId(administrativoId);
        return administrativoRepository.save(administrativoActualizado);
    }

    public void eliminarAdministrativo(@Validated  long administrativoId) {
        if (!administrativoRepository.existsById(administrativoId)) {
            throw new AdministrativoNotFoundException("Administrativo no encontrado con ID: " + administrativoId);
        }

        administrativoRepository.deleteById(administrativoId);
    }
}