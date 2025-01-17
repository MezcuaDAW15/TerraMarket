package com.example.demo.model.dto;

import java.io.Serializable;
import com.example.demo.repository.entity.MetodoPago;
import lombok.Data;

@Data
public class MetodoPagoDTO implements Serializable{

    private final static long serialVersionUID = 1L;
    private Long id;
    private String nombre;
    private String descripcion;

    public static MetodoPagoDTO convertToDTO(MetodoPago mp) {

		MetodoPagoDTO mpDTO = new MetodoPagoDTO();
		mpDTO.setId(mp.getId());
        mpDTO.setNombre(mp.getNombre());
		mpDTO.setDescripcion(mp.getDescripcion());

        return mpDTO;
    }

    public static MetodoPago convertToEntity(MetodoPagoDTO mpDTO){

        MetodoPago mp = new MetodoPago();
        mp.setId(mpDTO.getId());
        mp.setNombre(mpDTO.getNombre());
		mp.setDescripcion(mpDTO.getDescripcion());

        return mp;
    }
}
