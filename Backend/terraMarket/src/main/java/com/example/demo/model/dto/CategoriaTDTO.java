package com.example.demo.model.dto;

import java.util.List;
import java.util.stream.Collectors;

import com.example.demo.repository.entity.CategoriaT;

import lombok.Data;

@Data
public class CategoriaTDTO {
    private Long id;
    private String nombre;
    private String descripcion;
    private String icono;
    private List<CategoriaPDTO> listaCategoriaPDTO;

    public static CategoriaTDTO convertToDTO(CategoriaT categoriaT) {
        CategoriaTDTO categoriaTDTO = new CategoriaTDTO();
        categoriaTDTO.setId(categoriaT.getId());
        categoriaTDTO.setNombre(categoriaT.getNombre());
        categoriaTDTO.setDescripcion(categoriaT.getDescripcion());
        categoriaTDTO.setIcono(categoriaT.getIcono());
        categoriaTDTO.setListaCategoriaPDTO(
                categoriaT.getCategoriasP().stream()
                        .map(CategoriaPDTO::convertToDTO)
                        .collect(Collectors.toList()));
        return categoriaTDTO;

    }

    public static CategoriaT convertToEntity(CategoriaTDTO categoriaTDTO) {

        CategoriaT categoriaT = new CategoriaT();
        categoriaT.setId(categoriaTDTO.getId());
        categoriaT.setNombre(categoriaTDTO.getNombre());
        categoriaT.setDescripcion(categoriaTDTO.getDescripcion());
        categoriaT.setIcono(categoriaTDTO.getIcono());
        categoriaT.setCategoriasP(
                categoriaTDTO.getListaCategoriaPDTO().stream()
                        .map(CategoriaPDTO::convertToEntity)
                        .collect(Collectors.toSet()));
        return categoriaT;

    }
}
