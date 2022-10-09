package com.propiedadhorizontal.app.servicio;

import com.propiedadhorizontal.app.modelo.Apartamento;
import com.propiedadhorizontal.app.modelo.ConjuntoResidencial;

import java.util.List;

public interface ConjuntoResidencialServicio {

    String guardarConjuntoResidencial(ConjuntoResidencial cResidencial);

    String editarApartamento(ConjuntoResidencial cResidencial);

    List<ConjuntoResidencial> obtenerConjuntosResidenciales();

    ConjuntoResidencial obtenerConjuntoResidencialPorNombre(String nombreCResidencial);

    String eliminarConjuntoResidencial(String nombreCResidencial);
}
