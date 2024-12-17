package com.example.demo.web.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.model.dto.ProductoDTO;
import com.example.demo.service.ProductoService;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class ProductosController {
    private static final Logger log = LoggerFactory.getLogger(ProductosController.class);

    @Autowired
    private ProductoService productoService;

    // Listar los productos
    @GetMapping("/productos")
    public ModelAndView findAll() {

        log.info("ProductosController - findAll: Mostramos todos los productos");

        ModelAndView mav = new ModelAndView("productos");
        List<ProductoDTO> listaProductosDTO = productoService.findAll();
        mav.addObject("listaProductosDTO", listaProductosDTO);

        return mav;
    }

    @GetMapping("/productos/{idProducto}")
    public ModelAndView findById( @PathVariable("idProducto") Long idProducto) {

        log.info("ProductosController - findByid: Mostramos la info del producto ", idProducto);

        ProductoDTO productoDTO = productoService.findById(idProducto);
        ModelAndView mav = new ModelAndView("productoview");
        mav.addObject("productoDTO", productoDTO);

        return mav;
    }

    @GetMapping("productos/{idProducto}/delete")
    public ModelAndView delete (@PathVariable("idProducto") Long idProducto) {
        
        log.info("ProductosController - delete: Eliminamos el producto ", idProducto);
        productoService.delete(idProducto);
        ModelAndView mav = new ModelAndView("redirect:/productos");
        return mav;
    }

    

}
