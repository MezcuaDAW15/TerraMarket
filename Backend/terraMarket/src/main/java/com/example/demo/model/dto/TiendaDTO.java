package com.example.demo.model.dto;

import java.io.Serializable;
import java.util.Base64;
import java.util.List;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.example.demo.repository.entity.Tienda;
import com.fasterxml.jackson.annotation.JsonIgnore;

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
    @JsonIgnore
    private MercadoDTO mercado;

    private DireccionDTO direccion;
    private List<CategoriaTDTO> categoriaT;

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
        if (tienda.getImagen() != null) {
            tiendaDTO.setImagen(Base64.getEncoder().encodeToString(tienda.getImagen()));
        }
        tiendaDTO.setActivo(tienda.isActivo());
        tiendaDTO.setMercado(mercadoDTO);
        tiendaDTO.setDireccion(DireccionDTO.convertToDTO(tienda.getDireccion()));

        return tiendaDTO;
    }

    public static Tienda convertToEntity(TiendaDTO tiendaDTO) {
        log.info("TiendaDTo - convertToEntity: convirtiendo a entidad");
        Tienda tienda = new Tienda();
        tienda.setId(tiendaDTO.getId());
        tienda.setNombre(tiendaDTO.getNombre());
        tienda.setLogo(tiendaDTO.getLogo());
        tienda.setDescripcion(tiendaDTO.getDescripcion());
        // tienda.setImagen(tiendaDTO.getImagen());
        tienda.setActivo(tiendaDTO.isActivo());
        tienda.setMercado(MercadoDTO.convertToEntity(tiendaDTO.getMercado()));
        tienda.setDireccion(DireccionDTO.convertToEntity(tiendaDTO.getDireccion()));

        if (tiendaDTO.getCategoriaT() != null) {
            tienda.setCategorias(tiendaDTO.getCategoriaT().stream()
                    .map(CategoriaTDTO::convertToEntity)
                    .collect(Collectors.toSet()));
        }

        return tienda;
    }

}
