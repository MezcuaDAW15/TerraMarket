
package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.dto.CategoriaPDTO;
import com.example.demo.model.dto.ProductoDTO;
import com.example.demo.repository.dao.CategoriaPRepository;
import com.example.demo.repository.dao.ProductoRepository;
import com.example.demo.repository.entity.Producto;

@Service
public class ProductoServiceImpl implements ProductoService {

    private static final Logger log = LoggerFactory.getLogger(ProductoServiceImpl.class);

    @Autowired
    private ProductoRepository productoRepository;
    @Autowired
    private CategoriaPRepository categoriaPRepository;

    @Override
    public List<ProductoDTO> findAll() {
        log.info("ProductoServiceImpl - findAll: Lista de todos los productos");

        List<ProductoDTO> listaProductosDTO = new ArrayList<ProductoDTO>();
        List<Producto> listaProductos = productoRepository.findAll();
        listaProductos.forEach(producto -> {
            ProductoDTO productoDTO = ProductoDTO.convertToDTO(producto);
            listaProductosDTO.add(productoDTO);
        });
        return listaProductosDTO;

    }

    @Override
    public ProductoDTO findById(Long idProducto) {
        log.info("ProductoServiceImpl - findById: Mostramos la info del producto ", idProducto);

        Producto p = productoRepository.findById(idProducto).get();
        return ProductoDTO.convertToDTO(p);
    }

    @Override
    public void delete(Long idProducto) {
        log.info("ProductoServiceImpl - delete: Eliminamos el producto ", idProducto);
        productoRepository.deleteById(idProducto);
    }

    @Override
    public ProductoDTO save(ProductoDTO productoDTO) {
        if (productoDTO.getId() == null) {
            log.warn("El producto no tiene id asignado");
        }

        /*Desde el front traeremos los datos del producto y
         * la categoria a la que pertenece, pero solo el id.*/

        productoDTO.setCategoriaPDTO(CategoriaPDTO.convertToDTO(categoriaPRepository.findById(
            productoDTO.getCategoriaPDTO().getId()).get()));
        log.info("ProductoServiceImpl - save: Guardamos el producto ", productoDTO);


        return ProductoDTO.convertToDTO(productoRepository.save(ProductoDTO.convertToEntity(productoDTO)));
    }



}
