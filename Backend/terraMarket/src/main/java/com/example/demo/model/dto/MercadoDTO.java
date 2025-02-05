package com.example.demo.model.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import com.example.demo.repository.entity.Mercado;
import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;

@Data
public class MercadoDTO implements Serializable {

    private static final long serialVersionUID = 1L;
    private Long id;
    private String nombre;
    private String direccionF;
    private String telefono;
    private String email;
    private String imagen;
    private boolean activo;
    private DireccionDTO direccion;
    @JsonIgnore
    List<TiendaDTO> listaTiendas;

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        MercadoDTO other = (MercadoDTO) obj;
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

    public static MercadoDTO convertToDTO(Mercado mercado) {
        MercadoDTO mercadoDTO = new MercadoDTO();
        mercadoDTO.setId(mercado.getId());
        mercadoDTO.setNombre(mercado.getNombre());
        mercadoDTO.setDireccionF(mercado.getDireccionF());
        mercadoDTO.setTelefono(mercado.getTelefono());
        mercadoDTO.setEmail(mercado.getEmail());
        mercadoDTO.setImagen(mercado.getImagen());
        mercadoDTO.setActivo(mercado.isActivo());
        mercadoDTO.setDireccion(DireccionDTO.convertToDTO(mercado.getDireccion()));
        List<TiendaDTO> listaTDTO = new ArrayList<TiendaDTO>();
        mercado.getListaTiendas().forEach(tienda -> {
            listaTDTO.add(TiendaDTO.convertToDTO(tienda, mercadoDTO));
        });

        mercadoDTO.setListaTiendas(listaTDTO);
        return mercadoDTO;
    }

    public static Mercado convertToEntity(MercadoDTO mercadoDTO) {
        Mercado mercado = new Mercado();
        mercado.setId(mercadoDTO.getId());
        mercado.setNombre(mercadoDTO.getNombre());
        mercado.setDireccionF(mercadoDTO.getDireccionF());
        mercado.setTelefono(mercadoDTO.getTelefono());
        mercado.setEmail(mercadoDTO.getEmail());
        mercado.setImagen(mercadoDTO.getImagen());
        mercado.setActivo(mercadoDTO.isActivo());

        mercado.setDireccion(DireccionDTO.convertToEntity(mercadoDTO.getDireccion()));

        return mercado;
    }

}
