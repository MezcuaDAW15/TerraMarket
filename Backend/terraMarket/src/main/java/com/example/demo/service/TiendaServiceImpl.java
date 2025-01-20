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
import com.example.demo.repository.entity.Mercado;
import com.example.demo.repository.entity.Tienda;

@Service
public class TiendaServiceImpl implements TiendaService {

    private static final Logger log = LoggerFactory.getLogger(TiendaServiceImpl.class);

    @Autowired
    TiendaRepository tiendaRepository;

    @Override
    public List<TiendaDTO> findAllByMercado(MercadoDTO mercadoDTO) {
        log.info("TiendaServiceImpl - findAllByMercado: Lista de todas las tiendas por mercado");
        List<TiendaDTO> listaTiendasPorMercado = new ArrayList<TiendaDTO>();

        tiendaRepository.findAllByMercado(mercadoDTO.getId()).forEach(tienda -> {
            TiendaDTO tiendaDTO = TiendaDTO.convertToDTO(tienda, mercadoDTO);
            listaTiendasPorMercado.add(tiendaDTO);
        });
        return listaTiendasPorMercado;
    }

    @Override
    public TiendaDTO findById(TiendaDTO tiendaDTO) {
        log.info("TiendaServiceImpl - findById: Buscar tienda");

        Optional<Tienda> tiendaOp = tiendaRepository.findById(tiendaDTO.getId());

        if (tiendaOp.isPresent()) {
            Tienda tienda = tiendaOp.get();
            MercadoDTO mercadoDTO = MercadoDTO.convertToDTO(tienda.getMercado());
            tiendaDTO = TiendaDTO.convertToDTO(tienda, mercadoDTO);
            return tiendaDTO;
        } else {
            return null;
        }
    }

    @Override
    public void save(TiendaDTO tiendaDTO) {
        log.info("TiendaServiceImpl - save: guardar tienda");
        Mercado mercado = MercadoDTO.convertToEntity(tiendaDTO.getMercadoDTO());
        Tienda tienda = TiendaDTO.convertToEntity(tiendaDTO, mercado);

        tiendaRepository.save(tienda);
    }

}
