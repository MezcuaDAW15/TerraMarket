package com.example.demo.model.dto;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.example.demo.repository.entity.CategoriaP;
import com.example.demo.repository.entity.CategoriaT;

import lombok.Data;

@Data
public class CategoriaTDTO {
    private Long id;
    private String nombre;
    private String descripcion;
    private String icono;
    private List<CategoriaPDTO> listaCategoriaP;

    private static final Logger log = LoggerFactory.getLogger(CategoriaTDTO.class);

    public static CategoriaTDTO convertToDTO(CategoriaT categoriaT) {
        CategoriaTDTO categoriaTDTO = new CategoriaTDTO();
        categoriaTDTO.setId(categoriaT.getId());
        categoriaTDTO.setNombre(categoriaT.getNombre());
        categoriaTDTO.setDescripcion(categoriaT.getDescripcion());
        categoriaTDTO.setIcono(categoriaT.getIcono());
        List<CategoriaP> categoriasP = categoriaT.getCategoriasP();
        if (categoriasP != null && !categoriasP.isEmpty()) {
            log.info("CategoriaTDTO - convertToDTO: Lista de categoriasP no vacia");
            List<CategoriaPDTO> listaCategoriaPDTO = new ArrayList<>();
            for (CategoriaP categoriaP : categoriaT.getCategoriasP()) {
                listaCategoriaPDTO.add(CategoriaPDTO.convertToDTO(categoriaP));
            }
            categoriaTDTO.setListaCategoriaP(listaCategoriaPDTO);

        } else {
            categoriaTDTO.setListaCategoriaP(new ArrayList<CategoriaPDTO>());
        }
        log.info("CategoriaTDTO - convertToDTO: Lista de categoriasP no vacia");

        return categoriaTDTO;

    }

    public static CategoriaT convertToEntity(CategoriaTDTO categoriaTDTO) {

        CategoriaT categoriaT = new CategoriaT();
        categoriaT.setId(categoriaTDTO.getId());
        categoriaT.setNombre(categoriaTDTO.getNombre());
        categoriaT.setDescripcion(categoriaTDTO.getDescripcion());
        categoriaT.setIcono(categoriaTDTO.getIcono());
        categoriaT.setCategoriasP(
                categoriaTDTO.getListaCategoriaP().stream()
                        .map(CategoriaPDTO::convertToEntity)
                        .collect(Collectors.toList()));
        return categoriaT;

    }
}
