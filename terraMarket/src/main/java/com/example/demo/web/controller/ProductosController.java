package com.example.demo.web.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.model.dto.ProductoDTO;
import com.example.demo.service.ProductoService;

@Controller
public class ProductosController {
    private static final Logger log = LoggerFactory.getLogger(ProductosController.class);

    @Autowired
    private ProductoService productoService;

    // Listar los clientes
    @GetMapping("/productos")
    public ModelAndView findAll() {

        log.info("ProductosController - findAll: Mostramos todos los productos");

        ModelAndView mav = new ModelAndView("productos");
        List<ProductoDTO> listaProductosDTO = productoService.findAll();
        mav.addObject("listaProductosDTO", listaProductosDTO);

        return mav;
    }

}
