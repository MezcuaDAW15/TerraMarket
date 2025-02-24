package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.dto.CategoriaPDTO;
import com.example.demo.model.dto.MercadoDTO;
import com.example.demo.model.dto.TiendaDTO;
import com.example.demo.model.dto.VentaDTO;
import com.example.demo.repository.dao.CategoriaPRepository;
import com.example.demo.repository.dao.VentaRepository;
import com.example.demo.repository.entity.CategoriaP;
import com.example.demo.repository.entity.Venta;

@Service
public class VentaServiceImpl implements VentaService {

    @Autowired
    private VentaRepository ventaRepository;
    @Autowired
    private CategoriaPRepository categoriaPRepository;

    private static final Logger log = LoggerFactory.getLogger(VentaServiceImpl.class);

    @Override
    public List<VentaDTO> findAllByCategoriasMercado(List<CategoriaPDTO> categoriasPDTO, MercadoDTO mercadoDTO) {
        log.info("VentaServiceImpl - findAllByCategoriasMercado: " + categoriasPDTO + " " + mercadoDTO);

        if (categoriasPDTO.isEmpty()) {
            List<CategoriaP> categoriasP = categoriaPRepository.findAll();
            categoriasPDTO.addAll(categoriasP.stream().map(CategoriaPDTO::convertToDTO).toList());

        }

        List<Venta> ventas = new ArrayList<Venta>();
        for (CategoriaPDTO categoriaPDTO : categoriasPDTO) {
            log.info("Categoria: " + categoriaPDTO);
            ventas.addAll(ventaRepository.findCheeperByCategoriasMercado(categoriaPDTO.getId(), mercadoDTO.getId()));
        }

        for (Venta venta : ventas) {
            log.info("Venta: " + venta);
        }
        List<VentaDTO> ventasDTO = new ArrayList<VentaDTO>();
        for (Venta venta : ventas) {
            VentaDTO ventaDTO = VentaDTO.convertToDto(venta);
            ventasDTO.add(ventaDTO);
        }

        return ventasDTO;
    }

    @Override
    public List<VentaDTO> findAllByProductoMercado(Long idProducto, Long idMercado) {
        log.info("VentaServiceImpl - findAllByProductoMercado: " + idProducto + " " + idMercado);

        List<Venta> ventas = ventaRepository.findAllByProductoMercado(idProducto, idMercado);
        List<VentaDTO> ventasDTO = new ArrayList<VentaDTO>();
        for (Venta venta : ventas) {
            VentaDTO ventaDTO = VentaDTO.convertToDto(venta);
            ventasDTO.add(ventaDTO);
        }

        return ventasDTO;
    }

    @Override
    public List<VentaDTO> findAllByCategoriasTienda(List<CategoriaPDTO> categoriasPDTO, TiendaDTO tiendaDTO) {
        log.info("VentaServiceImpl - findAllByCategoriasTienda: " + categoriasPDTO + " " + tiendaDTO);

        if (categoriasPDTO.isEmpty()) {
            List<CategoriaP> categoriasP = categoriaPRepository.findAll();
            categoriasPDTO.addAll(categoriasP.stream().map(CategoriaPDTO::convertToDTO).toList());

        }

        List<Venta> ventas = new ArrayList<Venta>();
        for (CategoriaPDTO categoriaPDTO : categoriasPDTO) {
            log.info("Categoria: " + categoriaPDTO);
            ventas.addAll(ventaRepository.findCheeperByCategoriasMercado(categoriaPDTO.getId(), tiendaDTO.getId()));
        }

        for (Venta venta : ventas) {
            log.info("Venta: " + venta);
        }
        List<VentaDTO> ventasDTO = new ArrayList<VentaDTO>();
        for (Venta venta : ventas) {
            VentaDTO ventaDTO = VentaDTO.convertToDto(venta);
            ventasDTO.add(ventaDTO);
        }

        return ventasDTO;
    }
}
