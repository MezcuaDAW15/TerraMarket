package com.example.demo.repository.entity;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import lombok.Data;

@Data
@Entity
@Table(name = "mercados")
public class Mercado {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre;
    @Column(name = "direccion_f")
    private String direccionF;
    private String telefono;
    private String email;
    private String imagen;
    private boolean activo;
    @Column(name = "iddireccion")
    private Direccion direccion;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "mercado")
    List<Tienda> listaTiendas;

}
