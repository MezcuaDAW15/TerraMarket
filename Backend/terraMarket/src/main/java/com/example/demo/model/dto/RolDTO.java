package com.example.demo.model.dto;

import java.io.Serializable;

import com.example.demo.repository.entity.Cliente;
import com.example.demo.repository.entity.Rol;
import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;
import lombok.ToString;

@Data
public class RolDTO implements Serializable{

    private static final long serialVersionUID = 1L;
    private Long id;
    private String nombre;
    @ToString.Exclude
    @JsonIgnore
    private ClienteDTO clienteDTO;

    // Convertir de entidad a DTO
    public static RolDTO converToDTO(Rol rol, ClienteDTO clienteDTO) {
        RolDTO rolDTO = new RolDTO();
        rolDTO.setId(rol.getId());
        rolDTO.setNombre(rol.getNombre());
        rolDTO.setClienteDTO(clienteDTO);
        return rolDTO;
    }

    public static Rol converToEntity(RolDTO rolDTO, Cliente cliente) {
        Rol rol = new Rol();
        rol.setId(rolDTO.getId());
        rol.setNombre(rolDTO.getNombre());
        rol.setCliente(cliente);
        return rol;
    }
}
