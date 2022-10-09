package com.propiedadhorizontal.app.servicio;

import com.propiedadhorizontal.app.modelo.Pago;

import java.time.Year;
import java.util.List;

public interface PagosServicio {

    String guardarPago(Pago pago);

    String editarPago(Pago pago);

    List<Pago> obtenerPagos();

    Pago obtenerPagoPorAnio(Year anio);

    String eliminarPagoPorAnio(Year anio);
}
