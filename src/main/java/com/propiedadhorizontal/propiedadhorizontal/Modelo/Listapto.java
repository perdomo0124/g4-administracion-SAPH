/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.propiedadhorizontal.propiedadhorizontal.Modelo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "listapto") //nombre de referencia en base de datos
public class Listapto {
    
     //ahora crearemos los atributos 
    @Id //le decimos que esta es la columna id de nuestra tabla
    @GeneratedValue(strategy = GenerationType.AUTO)//llave primaria lista apto , con generacion automatica
    @Column(name = "list_id_pk") //nombre de la columna en base de datos
    private Long idpk; 
    
    @Column(name = "list_apto",nullable = false) //le decimos que no permita valores nulos
    private int list; // si no se utiliza nombre, se pone el nombre del atributo
    
    @Column(name = "list_administracion",nullable = false)
    private int administracion; // id administracion que realizo el movimiento
  
    /**
     * manytoOne muchos a uno
     * Fecht carga perezosa
     * una relacions con la tabla producto join column
     * json ignore para que no genere error al cargar la lista perezosa
     **/
    @ManyToOne(fetch = FetchType.LAZY,optional = false)
    @JoinColumn(name = "list_idapto_fk")
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private Apto apto; // 
    
    @ManyToOne(fetch = FetchType.LAZY,optional = false)
    @JoinColumn(name = "list_idresidente_fk")
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private Residente residente;

    public Listapto() {
        
    }

    public Long getIdpk() {
        return idpk;
    }

    public void setIdpk(Long idpk) {
        this.idpk = idpk;
    }


    public int getList() {
        return list;
    }

    public void setList(int list) {
        this.list = list;
    }

    public int getAdministracion() {
        return administracion;
    }

    public void setAdministracion(int administracion) {
        this.administracion = administracion;
    }

    public Apto getApto() {
        return apto;
    }

    public void setApto(Apto apto) {
        this.apto = apto;
    }

    public Residente getResidente() {
        return residente;
    }

    public void setResidente(Residente residente) {
        this.residente = residente;
    }
}
