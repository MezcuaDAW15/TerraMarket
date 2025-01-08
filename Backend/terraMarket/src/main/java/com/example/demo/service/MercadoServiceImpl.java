package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.dto.MercadoDTO;
import com.example.demo.repository.dao.MercadoRepository;

@Service
public class MercadoServiceImpl implements MercadoService{

    private static final Logger log = LoggerFactory.getLogger(MercadoServiceImpl.class);

    @Autowired
    private MercadoRepository mercadoRepository;

    @Override
    public List<MercadoDTO> findAll() {
        log.info("MercadoServiceImpl - findAll: Lista de todos los mercados");
        List<MercadoDTO> listaMercadosDTO = new ArrayList<MercadoDTO>();
        mercadoRepository.findAll().forEach(mercado -> {
            MercadoDTO mercadoDTO = MercadoDTO.convertToDTO(mercado);
            listaMercadosDTO.add(mercadoDTO);
        });
        return listaMercadosDTO;
    }

}
