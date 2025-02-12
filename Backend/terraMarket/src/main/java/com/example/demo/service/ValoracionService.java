package com.example.demo.service;

import java.util.List;

import com.example.demo.model.dto.ValoracionDTO;

public interface ValoracionService {

    List<ValoracionDTO> findByTienda(ValoracionDTO valoracionDTO);
}
