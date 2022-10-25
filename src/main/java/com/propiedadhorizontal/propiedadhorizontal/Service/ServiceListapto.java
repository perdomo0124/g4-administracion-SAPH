package com.propiedadhorizontal.propiedadhorizontal.Service;

import com.propiedadhorizontal.propiedadhorizontal.Modelo.Listapto;
import java.util.List;

public interface ServiceListapto {
    
    List<Listapto> getListaListapto();
    Listapto crearListapto(Listapto listapto);
    Listapto ActualizarStockListapto(Listapto listapto);
    Boolean EliminarListapto(Long id);
}
