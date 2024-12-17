package com.example.demo.service;

import java.util.List;

import com.example.demo.model.dto.ProductoDTO;

public interface ProductoService {

    List<ProductoDTO> findAll();

    ProductoDTO findById(Long idProducto);

    void delete(Long idProducto);

}
