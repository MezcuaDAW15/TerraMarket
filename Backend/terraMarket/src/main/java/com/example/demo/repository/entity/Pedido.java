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
	private Long id;
 
    private Cliente idCliente;
    private MetodoPago idPago;
    private PuntoRecogida idPR;

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
    private Long numFactura;

    private EstadoPedido estado;
    private float importe;

    //  lista de linea pedido!! relacion N a N con atributos

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Pedido other = (Pedido) obj;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        return true;
    }
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        return result;
    }

    
}
