package com.example.demo.service;

import java.util.List;

import com.example.demo.model.dto.CategoriaPDTO;
import com.example.demo.repository.entity.CategoriaP;
import com.example.demo.repository.entity.Producto;

public interface CategoriaPService {

    List<CategoriaPDTO> findAll();
    
}
