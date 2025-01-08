package com.example.demo.web.restcontroller;

import java.util.List;

import org.slf4j.Logger;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.dto.ProductoDTO;
import com.example.demo.service.ProductoService;
import org.springframework.web.bind.annotation.RequestMethod;


@RestController
@RequestMapping("/ws/productos")
public class ProductoRestController {

    @Autowired
    private ProductoService productoService;


    private static final Logger log = LoggerFactory.getLogger(ProductoRestController.class);

    @RequestMapping(method=RequestMethod.GET)
    public List<ProductoDTO> findAll() {
        log.info("ProductoRestController - findAll: Mostrando todos los productos");
        return productoService.findAll();
    }
    


}
