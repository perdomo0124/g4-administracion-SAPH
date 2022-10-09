package com.propiedadhorizontal.app.servicio;

import com.propiedadhorizontal.app.modelo.Apartamento;

import java.util.List;

public interface ApartamentoServicio {

    String guardarApartamento(Apartamento apt);

    String editarApartamento(Apartamento apt);

    List<Apartamento> obtenerApartamentos();

    Apartamento obtenerApartamentoPorNombre(Long id);

    String eliminarApartamento(String numeroApt,String nombreConjunto);

}
