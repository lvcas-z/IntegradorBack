package com.ZL.Integrador.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;


@Entity
@Getter
@Setter
@Table(name = "Pacientes")
public class Paciente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private  String nombre;
    private  String apellido;
    private String domicilio;
    private  String dni;
    private LocalDate fechaAlta;
}
