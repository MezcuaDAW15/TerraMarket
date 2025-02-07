package com.example.demo.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.dto.DireccionDTO;
import com.example.demo.repository.dao.DireccionRepository;
import com.example.demo.repository.entity.Direccion;

@Service
public class DireccionServiceImpl implements DireccionService {

    @Autowired
    DireccionRepository direccionRepository;

    @Override
    public DireccionDTO findById(DireccionDTO direccionDTO) {

        Optional<Direccion> direccionOp = direccionRepository.findById(direccionDTO.getId());

        if (direccionOp.isPresent()) {
            Direccion direccion = direccionOp.get();
            direccionDTO = DireccionDTO.convertToDTO(direccion);
            return direccionDTO;
        } else {
            return null;
        }

    }

}
