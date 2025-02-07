package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.dto.CategoriaPDTO;
import com.example.demo.repository.dao.CategoriaPRepository;
import com.example.demo.repository.entity.CategoriaP;

@Service
public class CategoriaPServiceImpl implements CategoriaPService {
    private static final Logger log = LoggerFactory.getLogger(CategoriaPServiceImpl.class.getName());

    @Autowired
    private CategoriaPRepository categoriaPRepository;

    @Override
    public List<CategoriaPDTO> findAll() {
        log.info("CategoriaPServiceImpl - findAll: Lista de todas las categorias");
        List<CategoriaP> listaCategorias = categoriaPRepository.findAll();
        List<CategoriaPDTO> listaCategoriasDTO = new ArrayList<CategoriaPDTO>();
        listaCategorias.forEach(categoria -> {
            CategoriaPDTO categoriaDTO = CategoriaPDTO.convertToDTO(categoria);
            listaCategoriasDTO.add(categoriaDTO);
        });
        return listaCategoriasDTO;


    }

    @Override
    public List<CategoriaPDTO> findByIdCategoriaT(Long id) {
        log.info("CategoriaPServiceImpl - findByIdCategoriaT: Lista de categorias por id de categoriaT");
        List<CategoriaP> listaCategorias = categoriaPRepository.findByIdCategoriaT(id);
        List<CategoriaPDTO> listaCategoriasDTO = new ArrayList<CategoriaPDTO>();
        listaCategorias.forEach(categoria -> {
            CategoriaPDTO categoriaDTO = CategoriaPDTO.convertToDTO(categoria);
            listaCategoriasDTO.add(categoriaDTO);
        });
        return listaCategoriasDTO;
    }



}
