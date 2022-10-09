package com.propiedadhorizontal.app.modelo;


import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "conjuntos_residenciales")
public class ConjuntoResidencial {

    @Id
    private Long id;
    private int estrato;
    private String direccionConjunto;
    private String nombreConjunto;

    public ConjuntoResidencial() {
    }

    public ConjuntoResidencial(Long id, int estrato, String direccionConjunto, String nombreConjunto) {
        this.id = id;
        this.estrato = estrato;
        this.direccionConjunto = direccionConjunto;
        this.nombreConjunto = nombreConjunto;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getEstrato() {
        return estrato;
    }

    public void setEstrato(int estrato) {
        this.estrato = estrato;
    }

    public String getDireccionConjunto() {
        return direccionConjunto;
    }

    public void setDireccionConjunto(String direccionConjunto) {
        this.direccionConjunto = direccionConjunto;
    }

    public String getNombreConjunto() {
        return nombreConjunto;
    }

    public void setNombreConjunto(String nombreConjunto) {
        this.nombreConjunto = nombreConjunto;
    }
}
