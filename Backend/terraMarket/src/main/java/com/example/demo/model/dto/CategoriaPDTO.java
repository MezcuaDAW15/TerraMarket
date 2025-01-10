package com.example.demo.model.dto;

import com.example.demo.model.CategoriaTDTO;
import com.example.demo.repository.entity.CategoriaP;

import lombok.Data;

@Data
public class CategoriaPDTO {
    private Long id;
    private String nombre;
    private String descripcion;
    private CategoriaTDTO categoriaTDTO;
    public static CategoriaPDTO convertToDTO(CategoriaP categoriaP) {
        CategoriaPDTO categoriaPDTO = new CategoriaPDTO();
        categoriaPDTO.setId(categoriaP.getId());
        categoriaPDTO.setNombre(categoriaP.getNombre());
        categoriaPDTO.setDescripcion(categoriaP.getDescripcion());
        categoriaPDTO.setCategoriaTDTO(CategoriaTDTO.convertToDTO(categoriaP.getCategoriaT()));
        return categoriaPDTO;

    }
    public static CategoriaP convertToEntity(CategoriaPDTO categoriaPDTO) {
        
        CategoriaP categoriaP = new CategoriaP();
        categoriaP.setId(categoriaPDTO.getId());
        categoriaP.setNombre(categoriaPDTO.getNombre());
        categoriaP.setDescripcion(categoriaPDTO.getDescripcion());
        categoriaP.setCategoriaT(CategoriaTDTO.convertToEntity(categoriaPDTO.getCategoriaTDTO()));
        return categoriaP;

    }


}
