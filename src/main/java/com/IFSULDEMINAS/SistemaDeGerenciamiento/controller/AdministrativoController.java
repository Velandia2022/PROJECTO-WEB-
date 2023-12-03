package com.IFSULDEMINAS.SistemaDeGerenciamiento.controller;


import com.IFSULDEMINAS.SistemaDeGerenciamiento.exceptions.AdministrativoNotFoundException;
import com.IFSULDEMINAS.SistemaDeGerenciamiento.model.Administrativo;
import com.IFSULDEMINAS.SistemaDeGerenciamiento.services.AdministrativoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/administrativos")
public class AdministrativoController {

    @Autowired
    private AdministrativoService administrativoService;

    @GetMapping
    public ResponseEntity<List<Administrativo>> obtenerTodosLosAdministrativos() {
        List<Administrativo> administrativos = administrativoService.obtenerTodosLosAdministrativos();
        return ResponseEntity.ok(administrativos);
    }

    @GetMapping("/{administrativoId}")
    public ResponseEntity<Administrativo> buscarAdministrativoPorId(@PathVariable long administrativoId) {
        try {
            Administrativo administrativo = administrativoService.buscarAdministrativoPorId(administrativoId);
            return ResponseEntity.ok(administrativo);
        } catch (AdministrativoNotFoundException ex) {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public ResponseEntity<Administrativo> crearAdministrativo(@Validated @RequestBody Administrativo nuevoAdministrativo) {
        Administrativo administrativoCreado = administrativoService.crearAdministrativo(nuevoAdministrativo);
        return ResponseEntity.status(HttpStatus.CREATED).body(administrativoCreado);
    }

    @PutMapping("/{administrativoId}")
    public ResponseEntity<Administrativo> actualizarAdministrativo(
            @PathVariable long administrativoId, @RequestBody Administrativo administrativoActualizado) {
        try {
            Administrativo administrativo = administrativoService.actualizarAdministrativo(administrativoId, administrativoActualizado);
            return ResponseEntity.ok(administrativo);
        } catch (AdministrativoNotFoundException ex) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{administrativoId}")
    public ResponseEntity<Void> eliminarAdministrativo(@Validated @PathVariable long administrativoId) {
        try {
            administrativoService.eliminarAdministrativo(administrativoId);
            return ResponseEntity.noContent().build();
        } catch (AdministrativoNotFoundException ex) {
            return ResponseEntity.notFound().build();
        }
    }
}