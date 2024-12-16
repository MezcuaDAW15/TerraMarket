package com.example.demo.repository.entity;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name="pedidos")
public class Pedido {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

    @Column(name = "idcliente") 
    private int idCliente;

    @Column(name = "idpago") 
    private int idPago;

    @Column(name = "idpr") 
    private int idPR;

    @Column(name = "fecha_pedido") 
    private Date fechaPedido;

    @Column(name = "fecha_compra") 
    private Date fechaCompra;

    @Column(name = "fecha_entrega") 
    private Date fechaEntrega;

    @Column(name = "fecha_max_recogida") 
    private Date fechaMaxRecogida;

    @Column(name = "fecha_factura") 
    private Date fechaFactura;

    @Column(name = "num_factura") 
    private int numFactura;

    private boolean recogido;
    private float importe;
}
