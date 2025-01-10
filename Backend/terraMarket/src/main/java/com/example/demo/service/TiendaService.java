package com.example.demo.service;

import java.util.List;

import com.example.demo.model.dto.MercadoDTO;
import com.example.demo.model.dto.TiendaDTO;

public interface TiendaService {

    List<TiendaDTO> findAllByMercado(MercadoDTO mercadoDTO);
}
