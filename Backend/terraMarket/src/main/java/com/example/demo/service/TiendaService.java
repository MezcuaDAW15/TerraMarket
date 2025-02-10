package com.example.demo.service;

import java.util.List;

import com.example.demo.model.dto.CategoriaTDTO;
import com.example.demo.model.dto.MercadoDTO;
import com.example.demo.model.dto.TiendaDTO;
import com.example.demo.model.dto.VentaDTO;

public interface TiendaService {

    List<TiendaDTO> findAllByMercado(MercadoDTO mercadoDTO);

    TiendaDTO findById(TiendaDTO tiendaDTO);

    void save(TiendaDTO tiendaDTO);

    List<TiendaDTO> findAllByCategoriasMercado(List<CategoriaTDTO> categoriasDTO, MercadoDTO mercadoDTO);
}
