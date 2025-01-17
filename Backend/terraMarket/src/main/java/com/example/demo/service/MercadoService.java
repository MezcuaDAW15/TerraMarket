package com.example.demo.service;

import java.util.List;

import com.example.demo.model.dto.MercadoDTO;

public interface MercadoService {

    List<MercadoDTO> findAll();

    MercadoDTO findById(MercadoDTO mercadoDTO);
}
