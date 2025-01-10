package com.example.demo.model.dto;

import com.example.demo.repository.entity.Tienda;

import lombok.Data;

@Data
public class TiendaDTO {

    private Long id;
    private String nombre;
    private String logo;
    private String descripcion;
    private String imagen;
    private boolean activo;
    private MercadoDTO mercadoDTO;

    private Long idDireccion;

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

    public static TiendaDTO convertToDTO(Tienda tienda) {
        TiendaDTO tiendaDTO = new TiendaDTO();
        tiendaDTO.setId(tienda.getId());
        tiendaDTO.setNombre(tienda.getNombre());
        tiendaDTO.setLogo(tienda.getLogo());
        tiendaDTO.setDescripcion(tienda.getDescripcion());
        tiendaDTO.setImagen(tienda.getImagen());
        tiendaDTO.setActivo(tienda.isActivo());
        tiendaDTO.setMercadoDTO(MercadoDTO.convertToDTO(tienda.getMercado()));
        tiendaDTO.setIdDireccion(tienda.getIdDireccion());
        return tiendaDTO;
    }

    public static Tienda convertToEntity(TiendaDTO tiendaDTO) {
        Tienda tienda = new Tienda();
        tienda.setId(tiendaDTO.getId());
        tienda.setNombre(tiendaDTO.getNombre());
        tienda.setLogo(tiendaDTO.getLogo());
        tienda.setDescripcion(tiendaDTO.getDescripcion());
        tienda.setImagen(tiendaDTO.getImagen());
        tienda.setActivo(tiendaDTO.isActivo());
        tienda.setIdDireccion(tiendaDTO.getIdDireccion());
        return tienda;
    }

}
