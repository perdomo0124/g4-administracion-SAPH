package com.propiedadhorizontal.app.servicio;

import com.propiedadhorizontal.app.modelo.Apartamento;
import com.propiedadhorizontal.app.repositorio.EntityRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.NoSuchElementException;


@Service
@Repository
@RequiredArgsConstructor
public class ApartamentoServicioImpI implements ApartamentoServicio{


    private final EntityRepository eRepository;

    @Override
    public String guardarApartamento(Apartamento apt) {

        eRepository.save(apt);
        return "Hemos guardado el apartamento correctamente";
    }

    @Override
    public String editarApartamento(Apartamento apt) {
        return null;
    }

    @Override
    public List<Apartamento> obtenerApartamentos() {
        return null;
    }

    @Override
    public Apartamento obtenerApartamentoPorNombre(Long id) {
        return eRepository.findById(id).orElseThrow(NoSuchElementException::new);
    }

    @Override
    public String eliminarApartamento(String numeroApt, String nombreConjunto) {
        return null;
    }

}
