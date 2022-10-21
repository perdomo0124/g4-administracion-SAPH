package com.propiedadhorizontal.propiedadhorizontal.Service;

import com.propiedadhorizontal.propiedadhorizontal.Modelo.Apto;
import java.util.List;

public interface ServiceApto {
    List<Apto> getListaApto();
    Apto crearApto(Apto apto);
    Apto ActualizarApto(Apto apto);
    Boolean EliminarApto(Long id);
}
