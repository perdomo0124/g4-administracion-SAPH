/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.propiedadhorizontal.propiedadhorizontal.Modelo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Size;

@Entity
@Table(name = "residente")
public class Residente {
   @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "res_id_pk")
    private Long idpk;
    
    @Column(name = "res_nombre", nullable = false)
    private String nombre;
    
    /**
     * esta vez volvemos a utilizar la propiedad validation esta vez con size
     * que nos permite fijar la cantidad de carateres a aceptar
     * 
     * */
    @Column(name = "res_doc")
    @Size(min = 7,max = 11,message = "el documento solo se permiten un rango de 7 a 11 caracteres")
    private String doc;
    
    @Column(name = "res_tel")
    @Size(min = 8,max = 15,message = "el numero telefono o celular solo se "
            + "permiten un rango de 9 a 15 carateres")
    private String telefono;

    public Residente() {
    }

    
    
    public Long getIdpk() {
        return idpk;
    }

    public void setIdpk(Long idpk) {
        this.idpk = idpk;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDoc() {
        return doc;
    }

    public void setDoc(String doc) {
        this.doc = doc;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }  
}
