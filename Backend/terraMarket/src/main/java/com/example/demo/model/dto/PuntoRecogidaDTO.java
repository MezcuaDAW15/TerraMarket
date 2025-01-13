package com.example.demo.model.dto;

import java.io.Serializable;
import com.example.demo.repository.entity.PuntoRecogida;
import lombok.Data;

@Data
public class PuntoRecogidaDTO implements Serializable{

    private static final long serialVersionUID = 1L;
    private Long id;
    private DireccionDTO direccionDTO;

    public static PuntoRecogidaDTO convertToDTO(PuntoRecogida pr) {

		PuntoRecogidaDTO prDTO = new PuntoRecogidaDTO();

		prDTO.setId(pr.getId());
		prDTO.setDireccionDTO(DireccionDTO.convertToDTO(pr.getDireccion()));
        
		return prDTO;
	}

    public static PuntoRecogida convertToEntity(PuntoRecogidaDTO prDTO) {

		PuntoRecogida pr = new PuntoRecogida();

		pr.setId(prDTO.getId());
		pr.setDireccion(DireccionDTO.convertToEntity(prDTO.getDireccionDTO()));
        
		return pr;
	}
}
