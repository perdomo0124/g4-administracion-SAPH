package com.propiedadhorizontal.propiedadhorizontal.Controller;

import com.propiedadhorizontal.propiedadhorizontal.Modelo.Listapto;
import com.propiedadhorizontal.propiedadhorizontal.ServiceImpl.ServiceListaptoImpl;
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
@RequestMapping(value = "/listapto")

public class ListaptoController {
    
    @Autowired
    private ServiceListaptoImpl serviceListapto;
    
    @GetMapping(value = "")
    public ResponseEntity<List<Listapto>> ListaListapto(){
        List<Listapto> lista = serviceListapto.getListaListapto();
        return ResponseEntity.ok(lista);
    }
    
    @PostMapping(value = "")
    public ResponseEntity<Listapto> CrearListapto(@Valid @RequestBody Listapto 
            listapto,BindingResult result){
        if(result.hasErrors()){
            throw  new ResponseStatusException(HttpStatus.NOT_FOUND,result.getFieldError()
                    .getDefaultMessage());
        }
        Listapto crear = serviceListapto.crearListapto(listapto);
        return ResponseEntity.ok(crear);
    }
    
    @PutMapping(value = "")
    public ResponseEntity<Listapto> ActualizarStock(@RequestBody Listapto listapto){
        Listapto actualizar = serviceListapto.ActualizarStockListapto(listapto);
        return ResponseEntity.ok(actualizar);
    }
    @DeleteMapping(value = "/{id}")
    public ResponseEntity<String> EliminarListapto(@PathVariable("id") Long id){
        if(id != null){
            if( serviceListapto.EliminarListapto(id)){
                 return ResponseEntity.ok().body("Eliminado");
            }
        }
      
        return ResponseEntity.notFound().build();
    }
}
