package com.example.demo.model.dto;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import com.example.demo.repository.entity.Tienda;
import com.example.demo.repository.entity.Valoracion;
import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Data;

@Data
public class ValoracionDTO implements Serializable {

    private static final long serialVersionUID = 1L;
    private Long id;
    private String resena;
    private int puntuacion;
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss.SSS")
    private Date fecha;

    private TiendaDTO tienda;
    private ClienteDTO cliente;

    public static ValoracionDTO convertToDTO(Valoracion valoracion) {
        ValoracionDTO valoracionDTO = new ValoracionDTO();
        valoracionDTO.setId(valoracion.getId());
        valoracionDTO.setResena(valoracion.getResena());
        valoracionDTO.setPuntuacion(valoracion.getPuntuacion());
        valoracionDTO.setFecha(valoracion.getFecha());
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
        valoracion.setFecha(valoracionDTO.getFecha());
        Tienda tienda = new Tienda();
        tienda.setId(valoracionDTO.getTienda().getId());
        valoracion.setTienda(tienda);
        valoracion.setCliente(ClienteDTO.convertToEntity(valoracionDTO.getCliente()));
        return valoracion;
    }

}
