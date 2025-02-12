package com.example.demo.repository.entity;

import java.util.List;
import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "categorias_tienda")
public class CategoriaT {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;

    private String descripcion;

    private String icono;

    @OneToMany(mappedBy = "categoriaT", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private List<CategoriaP> categoriasP;

    @ManyToMany(mappedBy = "categorias")
    private Set<Tienda> tiendas;

}
