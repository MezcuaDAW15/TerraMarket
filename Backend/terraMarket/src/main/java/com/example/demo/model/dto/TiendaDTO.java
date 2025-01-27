package com.example.demo.model.dto;

import java.io.Serializable;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.example.demo.repository.entity.Mercado;
import com.example.demo.repository.entity.Tienda;
import com.fasterxml.jackson.annotation.JsonBackReference;

import lombok.Data;

@Data
public class TiendaDTO implements Serializable {

    private static final Logger log = LoggerFactory.getLogger(TiendaDTO.class);
    private static final long serialVersionUID = 1L;
    private Long id;
    private String nombre;
    private String logo;
    private String descripcion;
    private String imagen;
    private boolean activo;
    @JsonBackReference
    private MercadoDTO mercadoDTO;
    private DireccionDTO direccionDTO;

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        TiendaDTO other = (TiendaDTO) obj;
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

    public static TiendaDTO convertToDTO(Tienda tienda, MercadoDTO mercadoDTO) {
        TiendaDTO tiendaDTO = new TiendaDTO();
        tiendaDTO.setId(tienda.getId());
        tiendaDTO.setNombre(tienda.getNombre());
        tiendaDTO.setLogo(tienda.getLogo());
        tiendaDTO.setDescripcion(tienda.getDescripcion());
        tiendaDTO.setImagen(tienda.getImagen());
        tiendaDTO.setActivo(tienda.isActivo());
        tiendaDTO.setMercadoDTO(mercadoDTO);
        tiendaDTO.setDireccionDTO(DireccionDTO.convertToDTO(tienda.getDireccion()));

        return tiendaDTO;
    }

    public static Tienda convertToEntity(TiendaDTO tiendaDTO) {
        log.info("TiendaDTO - convertToEntity: convirtiendo a entidad");
        Tienda tienda = new Tienda();
        tienda.setId(tiendaDTO.getId());
        tienda.setNombre(tiendaDTO.getNombre());
        tienda.setLogo(tiendaDTO.getLogo());
        tienda.setDescripcion(tiendaDTO.getDescripcion());
        tienda.setImagen(tiendaDTO.getImagen());
        tienda.setActivo(tiendaDTO.isActivo());
        tienda.setMercado(MercadoDTO.convertToEntity(tiendaDTO.getMercadoDTO()));
        tienda.setDireccion(DireccionDTO.convertToEntity(tiendaDTO.getDireccionDTO()));

        return tienda;
    }

}
