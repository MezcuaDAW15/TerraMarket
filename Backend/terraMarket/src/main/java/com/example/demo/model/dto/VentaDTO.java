package com.example.demo.model.dto;

import java.io.Serializable;
import java.util.Date;

import com.example.demo.repository.entity.Venta;

import lombok.Data;

@Data
public class VentaDTO implements Serializable{

    private static final long serialVersionUID = 1L;
    private Long id;

    private ProductoDTO productoDTO;
    private TiendaDTO tiendaDTO;
    private Date fechaVenta;
    private double precioVenta;
    private double stock;
    private double precioKg;
    private double descuento;
    private String descripcion;
    private boolean activo;
    
    public static VentaDTO convertToDto(Venta venta){

        VentaDTO vDTO = new VentaDTO();

        vDTO.setId(venta.getId());
        vDTO.setProductoDTO(ProductoDTO.convertToDTO(venta.getProducto()));

        MercadoDTO mDTO = MercadoDTO.convertToDTO(venta.getTienda().getMercado());
        vDTO.setTiendaDTO(TiendaDTO.convertToDTO(venta.getTienda(), mDTO));

        vDTO.setFechaVenta(venta.getFechaVenta());
        vDTO.setPrecioVenta(venta.getPrecioVenta());
        vDTO.setStock(venta.getStock());
        vDTO.setPrecioKg(venta.getPrecioKg());
        vDTO.setDescuento(venta.getDescuento());
        vDTO.setDescripcion(venta.getDescripcion());
        vDTO.setActivo(venta.isActivo());

        return vDTO;
    }
}
