
package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.dto.CategoriaPDTO;
import com.example.demo.model.dto.ProductoDTO;
import com.example.demo.repository.dao.CategoriaPRepository;
import com.example.demo.repository.dao.ProductoRepository;
import com.example.demo.repository.entity.CategoriaP;
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
    public ProductoDTO findById(ProductoDTO productoDTO) {
        log.info("ProductoServiceImpl - findById: Mostramos la info del producto ", productoDTO.getId());

        Producto p = productoRepository.findById(productoDTO.getId()).get();
        if (productoDTO.isImgRequest()) {
            return ProductoDTO.convertToDTO(p, true);
        } else {
            return ProductoDTO.convertToDTO(p);
        }
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

        /*
         * Desde el front traeremos los datos del producto y
         * la categoria a la que pertenece, pero solo el id.
         */

        productoDTO.setCategoriaP(CategoriaPDTO.convertToDTO(categoriaPRepository.findById(
                productoDTO.getCategoriaP().getId()).get()));
        log.info("ProductoServiceImpl - save: Guardamos el producto ", productoDTO);

        return ProductoDTO.convertToDTO(productoRepository.save(ProductoDTO.convertToEntity(productoDTO)));
    }

    @Override
    public List<ProductoDTO> findByCategories(List<Long> categories) {
        log.info("ProductoServiceImpl - findByCategories: Buscamos productos por categorias ", categories);
        List<CategoriaP> categorias = new ArrayList<>();
        for (Long id : categories) {
            CategoriaP categoria = new CategoriaP();
            categoria.setId(id);
            categorias.add(categoria);
        }
        List<ProductoDTO> productosDTO = new ArrayList<>();
        for (CategoriaP categoria : categorias) {
            productosDTO.addAll(productoRepository.findByCategory(categoria).stream().map(ProductoDTO::convertToDTO)
                    .collect(Collectors.toList()));
        }
        return productosDTO;
    }

}
