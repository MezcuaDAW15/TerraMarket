package com.example.demo.model.dto;

import java.io.Serializable;
import java.util.Date;

import com.example.demo.repository.entity.Venta;
import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;

@Data
public class VentaDTO implements Serializable {

    private static final long serialVersionUID = 1L;
    private Long id;

    @JsonIgnore
    private ProductoDTO productoDTO;
    @JsonIgnore
    private TiendaDTO tiendaDTO;
    private Date fechaVenta;
    private double precioVenta;
    private double stock;
    private double precioKg;
    private double descuento;
    private String descripcion;
    private boolean activo;

    public static VentaDTO convertToDto(Venta venta) {

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

    public static Venta convertToEntity(VentaDTO ventaDTO) {

        Venta venta = new Venta();

        venta.setId(ventaDTO.getId());
        venta.setProducto(ProductoDTO.convertToEntity(ventaDTO.getProductoDTO()));

        // MercadoDTO mDTO = MercadoDTO.convertToDTO(venta.getTienda().getMercado());
        venta.setTienda(TiendaDTO.convertToEntity(ventaDTO.getTiendaDTO()));

        venta.setFechaVenta(ventaDTO.getFechaVenta());
        venta.setPrecioVenta(ventaDTO.getPrecioVenta());
        venta.setStock(ventaDTO.getStock());
        venta.setPrecioKg(ventaDTO.getPrecioKg());
        venta.setDescuento(ventaDTO.getDescuento());
        venta.setDescripcion(ventaDTO.getDescripcion());
        venta.setActivo(ventaDTO.isActivo());

        return venta;
    }
}
