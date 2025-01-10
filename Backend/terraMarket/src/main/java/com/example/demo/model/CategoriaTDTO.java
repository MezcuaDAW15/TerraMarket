package com.example.demo.model;

import com.example.demo.repository.entity.CategoriaT;

import lombok.Data;

@Data
public class CategoriaTDTO {
    private Long id;
    private String nombre;
    private String descripcion;
    private String icono;
    public static CategoriaTDTO convertToDTO(CategoriaT categoriaT) {
        CategoriaTDTO categoriaTDTO = new CategoriaTDTO();
        categoriaTDTO.setId(categoriaT.getId());
        categoriaTDTO.setNombre(categoriaT.getNombre());
        categoriaTDTO.setDescripcion(categoriaT.getDescripcion());
        categoriaTDTO.setIcono(categoriaT.getIcono());
        return categoriaTDTO;

    }
    public static CategoriaT convertToEntity(CategoriaTDTO categoriaTDTO) {
        
        CategoriaT categoriaT = new CategoriaT();
        categoriaT.setId(categoriaTDTO.getId());
        categoriaT.setNombre(categoriaTDTO.getNombre());
        categoriaT.setDescripcion(categoriaTDTO.getDescripcion());
        categoriaT.setIcono(categoriaTDTO.getIcono());
        return categoriaT;

    }
}
