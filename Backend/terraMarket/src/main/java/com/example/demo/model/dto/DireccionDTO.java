package com.example.demo.model.dto;

import java.io.Serializable;
import com.example.demo.repository.entity.Direccion;
import lombok.Data;

@Data
public class DireccionDTO implements Serializable {

    private final static long serialVersionUID = 1L;
    private Long id;
    private String pais;
    private String provincia;
    private String ciudad;
    private String cp;
    private String calle;
    private String numero;
    private String puerta;
    private String piso;

    /* esto se va al aire */
    private boolean esMercado;
    private boolean esTienda;
    private boolean esPr;

    public static DireccionDTO convertToDTO(Direccion direccion) {

        DireccionDTO direccionDTO = new DireccionDTO();

        direccionDTO.setId(direccion.getId());
        direccionDTO.setPais(direccion.getPais());
        direccionDTO.setProvincia(direccion.getProvincia());
        direccionDTO.setCiudad(direccion.getCiudad());
        direccionDTO.setCp(direccion.getCp());
        direccionDTO.setCalle(direccion.getCalle());
        direccionDTO.setNumero(direccion.getNumero());
        direccionDTO.setPuerta(direccion.getPuerta());
        direccionDTO.setPiso(direccion.getPiso());

        direccionDTO.setEsMercado(direccion.isEsMercado());
        direccionDTO.setEsTienda(direccion.isEsTienda());
        direccionDTO.setEsPr(direccion.isEsPr());

        return direccionDTO;
    }

    public static Direccion convertToEntity(DireccionDTO direccionDTO) {

        Direccion direccion = new Direccion();

        direccion.setId(direccionDTO.getId());
        direccion.setPais(direccionDTO.getPais());
        direccion.setProvincia(direccionDTO.getProvincia());
        direccion.setCiudad(direccionDTO.getCiudad());
        direccion.setCp(direccionDTO.getCp());
        direccion.setCalle(direccionDTO.getCalle());
        direccion.setNumero(direccionDTO.getNumero());
        direccion.setPuerta(direccionDTO.getPuerta());
        direccion.setPiso(direccionDTO.getPiso());

        direccion.setEsMercado(direccionDTO.isEsMercado());
        direccion.setEsTienda(direccionDTO.isEsTienda());
        direccion.setEsPr(direccionDTO.isEsPr());

        return direccion;
    }
}
