package com.propiedadhorizontal.app.controlador;

import com.propiedadhorizontal.app.modelo.Apartamento;
import com.propiedadhorizontal.app.servicio.ApartamentoServicioImpI;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.*;


@RequiredArgsConstructor
@RestController
@RequestMapping(value = "api/apartamentos")
public class ApartamentoControlador {

    private final ApartamentoServicioImpI aptService;

    @PostMapping(consumes=MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity guardarApartamento(@RequestBody Apartamento apt) {
        return ResponseEntity.ok(aptService.guardarApartamento(apt));
    }

    @GetMapping
    public ResponseEntity obtenerApartamentos() {
        return ResponseEntity.ok(aptService.obtenerApartamentoPorNombre(1L));
    }

}
