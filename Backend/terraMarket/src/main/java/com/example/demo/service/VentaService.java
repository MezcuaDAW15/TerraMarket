package com.example.demo.service;

import java.util.List;

import com.example.demo.model.dto.ProductoDTO;
import com.example.demo.model.dto.VentaDTO;

public interface VentaService {

    List<VentaDTO> findAllByProducto(ProductoDTO producto);

}
