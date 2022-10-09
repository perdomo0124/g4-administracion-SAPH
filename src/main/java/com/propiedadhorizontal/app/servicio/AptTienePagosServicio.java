package com.propiedadhorizontal.app.servicio;


import com.propiedadhorizontal.app.modelo.ApartamentoTienePagos;

import java.time.Year;
import java.util.List;

public interface AptTienePagosServicio {

    String guardarApartamentoPagos(ApartamentoTienePagos aptPagos);

    String editarApartamentoPagos(ApartamentoTienePagos aptPagos);

    List<ApartamentoTienePagos> obtenerApartamentosPagos();

    ApartamentoTienePagos obtenerApartamentoPorNombre(String numeroApt,String nombreConjunto);

    String eliminarApartamentoPagoPorMesAnio(String numeroApt, String nombreConjunto, int mes, Year anio);
}
