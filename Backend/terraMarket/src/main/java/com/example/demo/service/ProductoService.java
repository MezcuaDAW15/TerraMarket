package com.example.demo.service;

import java.util.List;

import com.example.demo.model.dto.ProductoDTO;
import com.example.demo.repository.entity.Producto;

public interface ProductoService {

    List<ProductoDTO> findAll();

    ProductoDTO findById(ProductoDTO productoDTO);

    void delete(Long idProducto);

    ProductoDTO save(ProductoDTO productoDTO);

    List<ProductoDTO> findByCategories(List<Long> categories);

}
