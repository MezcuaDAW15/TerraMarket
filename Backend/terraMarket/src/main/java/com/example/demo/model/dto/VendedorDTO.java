package com.example.demo.model.dto;

import java.io.Serializable;

import com.example.demo.repository.entity.Mercado;
import com.example.demo.repository.entity.Vendedor;

import lombok.Data;

@Data
public class VendedorDTO implements Serializable {

    private final static long serialVersionUID = 1L;
    private Long id;
    private String nombre;
    private String apellidos;
    private String dni;
    private String email;
    private String contrasena;
    private boolean activo;
    private TiendaDTO tiendaDTO;

    public static VendedorDTO convertToDTO(Vendedor vendedor) {
        VendedorDTO vendedorDTO = new VendedorDTO();
        vendedorDTO.setId(vendedor.getId());
        vendedorDTO.setApellidos(vendedor.getApellidos());
        vendedorDTO.setNombre(vendedor.getNombre());
        vendedorDTO.setDni(vendedor.getDni());
        vendedorDTO.setEmail(vendedor.getEmail());
        vendedorDTO.setContrasena(vendedor.getContrasena());
        vendedorDTO.setActivo(vendedor.isActivo());
        MercadoDTO mercadoDTO = MercadoDTO.convertToDTO(vendedor.getTienda().getMercado());
        vendedorDTO.setTiendaDTO(TiendaDTO.convertToDTO(vendedor.getTienda(), mercadoDTO));
        return vendedorDTO;
    }

    public static Vendedor convertToEntity(VendedorDTO vendedorDTO) {
        Vendedor vendedor = new Vendedor();
        vendedor.setId(vendedorDTO.getId());
        vendedor.setApellidos(vendedorDTO.getApellidos());
        vendedor.setNombre(vendedorDTO.getNombre());
        vendedor.setDni(vendedorDTO.getDni());
        vendedor.setEmail(vendedorDTO.getEmail());
        vendedor.setContrasena(vendedorDTO.getContrasena());
        vendedor.setActivo(vendedorDTO.isActivo());
        Mercado mercado = MercadoDTO.convertToEntity(vendedorDTO.getTiendaDTO().getMercadoDTO());
        vendedor.setTienda(TiendaDTO.convertToEntity(vendedorDTO.getTiendaDTO(), mercado));
        return vendedor;
    }

}
