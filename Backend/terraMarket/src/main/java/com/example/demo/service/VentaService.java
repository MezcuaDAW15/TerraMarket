package com.example.demo.service;

import java.util.List;
import java.util.Map;

import com.example.demo.model.dto.CategoriaPDTO;
import com.example.demo.model.dto.MercadoDTO;
import com.example.demo.model.dto.ProductoDTO;
import com.example.demo.model.dto.VentaDTO;

public interface VentaService {

    List<VentaDTO> findAllByCategoriasMercado(List<CategoriaPDTO> categoriasDTO, MercadoDTO mercadoDTO);

    List<VentaDTO> findAllByProductoMercado(Long idProducto, Long idMercado);

}
