package com.example.demo.repository.entity;

import java.sql.Blob;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Lob;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.ToString;

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

    @Lob
    @Column(columnDefinition = "LONGBLOB")
    private byte[] imagen;
    private boolean activo;

    @ManyToOne
    @JoinColumn(name = "iddireccion")
    @ToString.Exclude
    private Direccion direccion;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "mercado")
    @ToString.Exclude
    List<Tienda> listaTiendas;

}
