package com.example.demo.service;

import java.util.List;

import com.example.demo.model.dto.CategoriaTDTO;
import com.example.demo.model.dto.TiendaDTO;

public interface CategoriaTService {

    List<CategoriaTDTO> findAll();

    public List<CategoriaTDTO> findAllByTienda(TiendaDTO tiendaDTO);
}
