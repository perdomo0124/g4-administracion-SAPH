package com.propiedadhorizontal.app.modelo;


import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
@Entity
@Table(name = "apartamentos")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Apartamento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private int metroCuadrados;
    private int numeroHabitaciones;
    private int numeroGarage;
    private String numeroApartamento;

}
