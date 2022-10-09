package com.propiedadhorizontal.app.modelo;


import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "apartamento_tiene_pagos")
public class ApartamentoTienePagos {

    @Id
    private Long id;
    private Long idApt;
    private Long idPago;
    private double valorTotal;
    private int mes;

    public ApartamentoTienePagos() {
    }

    public ApartamentoTienePagos(Long id, Long idApt, Long idPago, double valorTotal, int mes) {
        this.id = id;
        this.idApt = idApt;
        this.idPago = idPago;
        this.valorTotal = valorTotal;
        this.mes = mes;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getIdApt() {
        return idApt;
    }

    public void setIdApt(Long idApt) {
        this.idApt = idApt;
    }

    public Long getIdPago() {
        return idPago;
    }

    public void setIdPago(Long idPago) {
        this.idPago = idPago;
    }

    public double getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(double valorTotal) {
        this.valorTotal = valorTotal;
    }

    public int getMes() {
        return mes;
    }

    public void setMes(int mes) {
        this.mes = mes;
    }
}
