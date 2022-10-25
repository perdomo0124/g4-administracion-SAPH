/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.propiedadhorizontal.propiedadhorizontal.Service;

import com.propiedadhorizontal.propiedadhorizontal.Modelo.Residente;
import java.util.List;

public interface ServiceResidente {
    
    List<Residente> getListaResidente();
    Residente crearResidente(Residente residente);
    Residente ActualizarResidente(Residente residente);
    Boolean EliminarResidente(Long id);
}
