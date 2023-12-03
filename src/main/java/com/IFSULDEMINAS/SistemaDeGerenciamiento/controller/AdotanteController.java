package com.IFSULDEMINAS.SistemaDeGerenciamiento.controller;
import com.IFSULDEMINAS.SistemaDeGerenciamiento.exception.AdotanteNotFoundException;
import com.IFSULDEMINAS.SistemaDeGerenciamiento.model.Adotante;
import com.IFSULDEMINAS.SistemaDeGerenciamiento.service.AdotanteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/adotantes")
public class AdotanteController {

    @Autowired
    private AdotanteService adotanteService;

    @GetMapping
    public ResponseEntity<List<Adotante>> obtenerTodosLosAdotantes() {
        List<Adotante> adotantes = adotanteService.obtenerTodosLosAdotantes();
        return ResponseEntity.ok(adotantes);
    }

    @GetMapping("/{adotanteID}")
    public ResponseEntity<Adotante> buscarAdotantePorId(@PathVariable long adotanteID) {
        try {
            Adotante adotante = adotanteService.buscarAdotantePorId(adotanteID);
            return ResponseEntity.ok(adotante);
        } catch (AdotanteNotFoundException ex) {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public ResponseEntity<Adotante> crearAdotante(@Validated @RequestBody Adotante nuevoAdotante) {
        Adotante adotanteCreado = adotanteService.crearAdotante(nuevoAdotante);
        return ResponseEntity.status(HttpStatus.CREATED).body(adotanteCreado);
    }

    @PutMapping("/{adotanteID}")
    public ResponseEntity<Adotante> actualizarAdotante(@Validated @PathVariable long adotanteID, @RequestBody Adotante adotanteActualizado) {
        try {
            Adotante adotante = adotanteService.actualizarAdotante(adotanteID, adotanteActualizado);
            return ResponseEntity.ok(adotante);
        } catch (AdotanteNotFoundException ex) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{adotanteID}")
    public ResponseEntity<Void> eliminarAdotante(@PathVariable long adotanteID) {
        try {
            adotanteService.eliminarAdotante(adotanteID);
            return ResponseEntity.noContent().build();
        } catch (AdotanteNotFoundException ex) {
            return ResponseEntity.notFound().build();
        }
    }
}