package com.IFSULDEMINAS.SistemaDeGerenciamiento.services;

import com.IFSULDEMINAS.SistemaDeGerenciamiento.exception.AdotanteNotFoundException;
import com.IFSULDEMINAS.SistemaDeGerenciamiento.model.Adotante;
import com.IFSULDEMINAS.SistemaDeGerenciamiento.repository.AdotanteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;


import java.util.List;

@Service
public class AdotanteService {

    @Autowired
    private AdotanteRepository adotanteRepository;

    public List<Adotante> obtenerTodosLosAdotantes() {
        return adotanteRepository.findAll();
    }

    public Adotante buscarAdotantePorId(long adotanteId) {
        return adotanteRepository.findById(adotanteId)
                .orElseThrow(() -> new AdotanteNotFoundException("Adotante no encontrado con ID: " + adotanteId));
    }

    public Adotante crearAdotante(@Validated Adotante nuevoAdotante) {
        // Agregar lógica de validación u otras operaciones antes de guardar si es necesario
        return adotanteRepository.save(nuevoAdotante);
    }

    public Adotante actualizarAdotante(long adotanteId, @Validated Adotante adotanteActualizado) {
        if (!adotanteRepository.existsById(adotanteId)) {
            throw new AdotanteNotFoundException("Adotante no encontrado con ID: " + adotanteId);
        }

        adotanteActualizado.setAdotanteID((int) adotanteId);
        return adotanteRepository.save(adotanteActualizado);
    }

    public void eliminarAdotante(long adotanteId) {
        if (!adotanteRepository.existsById(adotanteId)) {
            throw new AdotanteNotFoundException("Adotante no encontrado con ID: " + adotanteId);
        }

        adotanteRepository.deleteById(adotanteId);
    }
}
