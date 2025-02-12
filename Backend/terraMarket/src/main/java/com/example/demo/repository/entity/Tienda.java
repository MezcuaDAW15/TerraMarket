package com.example.demo.repository.entity;

import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.Lob;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.ToString;

@Data
@Entity
@Table(name = "tiendas")
public class Tienda {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre;
    private String logo;
    private String descripcion;
    @Lob
    @Column(columnDefinition = "LONGBLOB")
    private byte[] imagen;
    private boolean activo;

    @ManyToOne
    @JoinColumn(name = "idmercado")
    @ToString.Exclude
    private Mercado mercado;

    @ManyToOne
    @JoinColumn(name = "iddireccion")
    @ToString.Exclude
    private Direccion direccion;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "tienda")
    @ToString.Exclude
    private Set<Venta> listaVentas;
    @ManyToMany
    @JoinTable(name = "rel_categorias_tienda", joinColumns = @JoinColumn(name = "id_tienda"), inverseJoinColumns = @JoinColumn(name = "id_categoria"))
    private Set<CategoriaT> categorias;

    public Tienda() {
        this.mercado = new Mercado();
        this.direccion = new Direccion();
    }

}
