
package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.dto.ProductoDTO;
import com.example.demo.repository.dao.ProductoRepository;

@Service
public class ProductoServiceImpl implements ProductoService {

    	private static final Logger log = LoggerFactory.getLogger(ProductoServiceImpl.class);

    @Autowired
    private ProductoRepository productoRepository;

    @Override
    public List<ProductoDTO> findAll() {
        log.info("ProductoServiceImpl - findAll: Lista de todos los productos");

        List<ProductoDTO> listaProductosDTO = new ArrayList<ProductoDTO>();

        productoRepository.findAll().forEach(producto -> {
            ProductoDTO productoDTO = ProductoDTO.convertToDTO(producto);
            listaProductosDTO.add(productoDTO);
        });
        return listaProductosDTO;

    }

    @Override
    public ProductoDTO findById(Long idProducto) {
        log.info("ProductoServiceImpl - findById: Mostramos la info del producto ", idProducto);

        return ProductoDTO.convertToDTO(productoRepository.findById(idProducto).get());
    }

    @Override
    public void delete(Long idProducto) {
        log.info("ProductoServiceImpl - delete: Eliminamos el producto ", idProducto);
        productoRepository.deleteById(idProducto);
    }

    @Override
    public void save(ProductoDTO productoDTO) {
        if (productoDTO.getId() == null) {
            log.warn("El producto no tiene id asignado");
        }
        log.info("ProductoServiceImpl - save: Guardamos el producto ", productoDTO);
        productoRepository.save(ProductoDTO.convertToEntity(productoDTO));
    }

}
