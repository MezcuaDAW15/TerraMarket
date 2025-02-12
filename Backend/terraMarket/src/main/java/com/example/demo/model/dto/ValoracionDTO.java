package com.example.demo.model.dto;

import java.io.Serializable;

import com.example.demo.repository.entity.Valoracion;

import lombok.Data;

@Data
public class ValoracionDTO implements Serializable {

    private static final long serialVersionUID = 1L;
    private Long id;
    private String resena;
    private int puntuacion;
    // todo falta la fecha
    private TiendaDTO tienda;
    private ClienteDTO cliente;

    public static ValoracionDTO convertToDTO(Valoracion valoracion) {
        ValoracionDTO valoracionDTO = new ValoracionDTO();
        valoracionDTO.setId(valoracion.getId());
        valoracionDTO.setResena(valoracion.getResena());
        valoracionDTO.setPuntuacion(valoracion.getPuntuacion());
        MercadoDTO mercado = MercadoDTO.convertToDTO(valoracion.getTienda().getMercado());
        valoracionDTO.setTienda(TiendaDTO.convertToDTO(valoracion.getTienda(), mercado));
        valoracionDTO.setCliente(ClienteDTO.convertToDTO(valoracion.getCliente()));
        return valoracionDTO;
    }

    public static Valoracion convertToEntity(ValoracionDTO valoracionDTO) {
        Valoracion valoracion = new Valoracion();
        valoracion.setId(valoracionDTO.getId());
        valoracion.setResena(valoracionDTO.getResena());
        valoracion.setPuntuacion(valoracionDTO.getPuntuacion());
        valoracion.setTienda(TiendaDTO.convertToEntity(valoracionDTO.getTienda()));
        valoracion.setCliente(ClienteDTO.convertToEntity(valoracionDTO.getCliente()));
        return valoracion;
    }

}
