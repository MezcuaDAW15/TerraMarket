package com.example.demo.repository.entity;

import java.util.Date;
import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.ToString;

@Data
@Entity
@Table(name="ventas")
public class Venta {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
	
	@ManyToOne
	@JoinColumn(name = "idproducto")
    @ToString.Exclude
    private Producto producto;
	
	@ManyToOne
	@JoinColumn(name = "idtienda")
    @ToString.Exclude
    private Tienda tienda;
	
	@Column(name = "fecha_venta")
	private Date fechaVenta;
	@Column(name = "precio")
    private double precioVenta;
    private double stock;
    @Column(name = "precio_kg")
    private double precioKg;
    private double descuento;
    private String descripcion;
    private boolean activo;
    
    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "venta")
    @ToString.Exclude
    private Set<LineaPedido> listaLineasPedido;
}
