package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.dto.MercadoDTO;
import com.example.demo.model.dto.TiendaDTO;
import com.example.demo.repository.dao.TiendaRepository;
import com.example.demo.repository.entity.Tienda;

@Service
public class TiendaServiceImpl implements TiendaService {

    private static final Logger log = LoggerFactory.getLogger(TiendaServiceImpl.class);

    @Autowired
    TiendaRepository tiendaRepository;

    @Override
    public List<TiendaDTO> findAllByMercado(MercadoDTO mercadoDTO) {
        log.info("TiendaServiceImpl - findAllByMercado: Lista de todos las tiendas por mercado");
        List<TiendaDTO> listaTiendasPorMercado = new ArrayList<TiendaDTO>();

        tiendaRepository.findAllByMercado(mercadoDTO.getId()).forEach(tienda -> {
            TiendaDTO tiendaDTO = TiendaDTO.convertToDTO(tienda, mercadoDTO);
            listaTiendasPorMercado.add(tiendaDTO);
        });
        return listaTiendasPorMercado;
    }

    @Override
    public TiendaDTO findById(TiendaDTO tiendaDTO) {
        Optional<Tienda> tienda = tiendaRepository.findById(tiendaDTO.getId());

        if (tienda.isPresent()) {
            tiendaDTO = TiendaDTO.convertToDTO(tienda.get(), tiendaDTO.getMercadoDTO());
            return tiendaDTO;
        } else {
            return null;
        }
    }

}
