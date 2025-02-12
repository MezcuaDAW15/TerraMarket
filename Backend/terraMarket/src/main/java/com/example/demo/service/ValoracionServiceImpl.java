package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.dto.ValoracionDTO;
import com.example.demo.repository.dao.ValoracionRepository;

@Service
public class ValoracionServiceImpl implements ValoracionService {

    private static final Logger log = LoggerFactory.getLogger(TiendaServiceImpl.class);

    @Autowired
    ValoracionRepository valoracionRepository;

    @Override
    public List<ValoracionDTO> findByTienda(ValoracionDTO valoracionDTO) {
        log.info("ValoracionServiceImpl - findByTienda: Lista de todas las valoraciones por tienda");
        List<ValoracionDTO> listaValPorTienda = new ArrayList<ValoracionDTO>();

        valoracionRepository.findByTienda(valoracionDTO.getTienda().getId()).forEach(valoracion -> {
            ValoracionDTO valoracionDTO2 = ValoracionDTO.convertToDTO(valoracion);
            listaValPorTienda.add(valoracionDTO2);
        });
        return listaValPorTienda;
    }

}
