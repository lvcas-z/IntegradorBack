package com.ZL.Integrador.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@ToString
@Entity
@Getter
@Setter
@Table(name = "Odontologos")
public class Odontologo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private  String nombre;
    private  String apellido;
    private  String matricula;
}
