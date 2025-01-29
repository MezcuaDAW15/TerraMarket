package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.hibernate.Hibernate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.dto.CategoriaTDTO;
import com.example.demo.repository.dao.CategoriaTRepository;
import com.example.demo.repository.entity.CategoriaT;

@Service
public class CategoriaTServiceImpl implements CategoriaTService {
    private static final Logger log = LoggerFactory.getLogger(CategoriaTServiceImpl.class.getName());

    @Autowired
    private CategoriaTRepository categoriaTRepository;

    @Override
    public List<CategoriaTDTO> findAll() {
        log.info("CategoriaTServiceImpl - findAll: Lista de todas las categorias");
        List<CategoriaT> listaCategorias = categoriaTRepository.findAll();

        for (int i = 0; i < listaCategorias.size(); i++) {
            log.info("-----" + listaCategorias.get(i + 1));
        }
        List<CategoriaTDTO> listaCategoriasDTO = new ArrayList<CategoriaTDTO>();

        listaCategoriasDTO = listaCategorias.stream()
                .map(CategoriaTDTO::convertToDTO)
                .collect(Collectors.toList());
        return listaCategoriasDTO;

    }

}
