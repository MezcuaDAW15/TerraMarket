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
@Table(name="linea_pedidos")
public class LineaPedido {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idpedido")
    private Long idPedido;
    @Column(name = "idventa")
    private Long idVenta;
    private int cantidad;
    private Date fecha;

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        LineaPedido other = (LineaPedido) obj;
        if (idPedido == null) {
            if (other.idPedido != null)
                return false;
        } else if (!idPedido.equals(other.idPedido))
            return false;
        if (idVenta == null) {
            if (other.idVenta != null)
                return false;
        } else if (!idVenta.equals(other.idVenta))
            return false;
        return true;
    }
    
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((idPedido == null) ? 0 : idPedido.hashCode());
        result = prime * result + ((idVenta == null) ? 0 : idVenta.hashCode());
        return result;
    }

    
}
