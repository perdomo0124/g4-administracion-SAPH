package com.propiedadhorizontal.propiedadhorizontal.Controller;

import com.propiedadhorizontal.propiedadhorizontal.Modelo.Apto;
import com.propiedadhorizontal.propiedadhorizontal.ServiceImpl.ServiceAptoImpl;
import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

@RestController
@CrossOrigin(origins={"http://127.0.0.1:5502"})
@RequestMapping(value = "/apto")

public class AptoController {
   
      @Autowired
    private ServiceAptoImpl serviceApto;

    @GetMapping(value = "")
    public ResponseEntity<List<Apto>> ListaApto() {
        List<Apto> lista = serviceApto.getListaApto();
        return ResponseEntity.ok(lista);
    }

    @PostMapping(value = "")
    public ResponseEntity<Apto> CrearApto(@Valid @RequestBody Apto listapto, BindingResult result) {
        if (result.hasErrors()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, result.getFieldError()
                    .getDefaultMessage());
        }
        Apto crear = serviceApto.crearApto(listapto);
        return ResponseEntity.ok(crear);
    }

    @PutMapping(value = "")
    public ResponseEntity<Apto> ActualizarApto(@RequestBody Apto listapto) {
        Apto actualizar = serviceApto.ActualizarApto(listapto);
        return ResponseEntity.ok(actualizar);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<String> EliminarApto(@PathVariable("id") Long id) {
        if (id != null) {
            if (serviceApto.EliminarApto(id)) {
                return ResponseEntity.ok().body("Eliminado");
            }
        }

        return ResponseEntity.notFound().build();
    }
}
