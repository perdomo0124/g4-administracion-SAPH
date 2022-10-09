package com.propiedadhorizontal.app.modelo;


import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.Year;


@Entity
@Table(name = "pagos")
public class Pago {

    @Id
    private Long id;
    private String descripcion;
    private double valorBase;
    private Year anio;

    public Pago() {
    }

    public Pago(Long id, String descripcion, double valorBase, Year anio) {
        this.id = id;
        this.descripcion = descripcion;
        this.valorBase = valorBase;
        this.anio = anio;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public double getValorBase() {
        return valorBase;
    }

    public void setValorBase(double valorBase) {
        this.valorBase = valorBase;
    }

    public Year getAnio() {
        return anio;
    }

    public void setAnio(Year anio) {
        this.anio = anio;
    }
}
