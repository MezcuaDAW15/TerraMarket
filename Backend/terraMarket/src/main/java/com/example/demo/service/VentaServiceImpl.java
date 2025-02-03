package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.dto.CategoriaPDTO;
import com.example.demo.model.dto.MercadoDTO;
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
    public List<VentaDTO> findAllByCategoriasMercado(CategoriaPDTO[] categoriasPDTO, MercadoDTO mercadoDTO) {
        log.info("VentaServiceImpl - findAllByCategoriasMercado: " + categoriasPDTO + " " + mercadoDTO);

        // Se pide a la base de datos las ventas de los productos que pertenecen a las
        // categorias seleccionadas y que esten el mercado seleccionado
        // Se guardan y se piden esos productos a la base de datos
        // Se guardan y se devuelven en un mapa donde la clave es el producto y el valor
        // es la venta
        if (categoriasPDTO == null || categoriasPDTO.length == 0 || mercadoDTO == null) {
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

}
