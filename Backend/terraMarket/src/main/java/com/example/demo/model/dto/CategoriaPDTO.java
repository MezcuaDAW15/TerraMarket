package com.example.demo.model.dto;

import com.example.demo.repository.entity.CategoriaP;
import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;

@Data
public class CategoriaPDTO {
    private Long id;
    private String nombre;
    private String descripcion;
    @JsonIgnore
    public static CategoriaPDTO convertToDTO(CategoriaP categoriaP) {
        CategoriaPDTO categoriaPDTO = new CategoriaPDTO();
        categoriaPDTO.setId(categoriaP.getId());
        categoriaPDTO.setNombre(categoriaP.getNombre());
        categoriaPDTO.setDescripcion(categoriaP.getDescripcion());
        return categoriaPDTO;

    }
    public static CategoriaP convertToEntity(CategoriaPDTO categoriaPDTO) {
        
        CategoriaP categoriaP = new CategoriaP();
        categoriaP.setId(categoriaPDTO.getId());
        categoriaP.setNombre(categoriaPDTO.getNombre());
        categoriaP.setDescripcion(categoriaPDTO.getDescripcion());
        return categoriaP;

    }


}
