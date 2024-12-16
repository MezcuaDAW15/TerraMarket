package com.example.demo.repository.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "direcciones")
public class Direccion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String pais;

    private String provincia;

    private String ciudad;

    private String cp;

    private String calle;

    private String numero;

    private String puerta;

    private String piso;

    @Column(name = "es_mercado")
    private boolean esMercado;

    @Column(name = "es_tienda")
    private boolean esTienda;

    @Column(name = "es_pr")
    private boolean esPr;

}
