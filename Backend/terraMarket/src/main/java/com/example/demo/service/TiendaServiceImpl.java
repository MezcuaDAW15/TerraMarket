package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.dto.CategoriaTDTO;
import com.example.demo.model.dto.MercadoDTO;
import com.example.demo.model.dto.TiendaDTO;
import com.example.demo.model.dto.VentaDTO;
import com.example.demo.repository.dao.CategoriaTRepository;
import com.example.demo.repository.dao.TiendaRepository;
import com.example.demo.repository.entity.CategoriaT;
import com.example.demo.repository.entity.Tienda;
import com.example.demo.repository.entity.Venta;

@Service
public class TiendaServiceImpl implements TiendaService {

    private static final Logger log = LoggerFactory.getLogger(TiendaServiceImpl.class);

    @Autowired
    TiendaRepository tiendaRepository;
    @Autowired
    CategoriaTRepository categoriaTRepository;
    @Autowired
    CategoriaTService categoriaTService;

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
        log.info("TiendaServiceImpl - findById: Buscar tienda");
        Optional<Tienda> tienda = tiendaRepository.findById(tiendaDTO.getId());

        if (tienda.isPresent()) {
            tiendaDTO = TiendaDTO.convertToDTO(tienda.get(), tiendaDTO.getMercado());
            return tiendaDTO;
        } else {
            return null;
        }
    }

    @Override
    public void save(TiendaDTO tiendaDTO) {
        log.info("TiendaServiceImpl - save: guardar tienda");
        Tienda tienda = TiendaDTO.convertToEntity(tiendaDTO);

        tiendaRepository.save(tienda);
    }

    @Override
    public List<TiendaDTO> findAllByCategoriasMercado(List<CategoriaTDTO> categoriasTDTO, MercadoDTO mercadoDTO) {
        if (categoriasTDTO.isEmpty()) {
            List<CategoriaT> categoriasT = categoriaTRepository.findAll();
            categoriasTDTO.addAll(categoriasT.stream().map(CategoriaTDTO::convertToDTO).toList());

        }

        List<Tienda> tiendas = new ArrayList<Tienda>();
        for (CategoriaTDTO categoriaTDTO : categoriasTDTO) {
            log.info("Categoria: " + categoriaTDTO);
            tiendas.addAll(tiendaRepository.findAllByCategoriasMercado(categoriaTDTO.getId(), mercadoDTO.getId()));
        }

        List<TiendaDTO> tiendasDTO = new ArrayList<TiendaDTO>();
        for (Tienda tienda : tiendas) {
            TiendaDTO tiendaDTO = TiendaDTO.convertToDTO(tienda, mercadoDTO);
            tiendaDTO.setCategoriaT(categoriaTService.findAllByTienda(tiendaDTO));
            tiendasDTO.add(tiendaDTO);
        }

        return tiendasDTO;
    }

}
