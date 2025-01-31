package com.example.demo.web.restcontroller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.dto.ProductoDTO;
import com.example.demo.model.dto.VentaDTO;
import com.example.demo.service.VentaService;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/ws/productos")
public class VentaRestController {

    @Autowired
    private VentaService ventaService;

    private static final Logger log = LoggerFactory.getLogger(VentaRestController.class);

    @RequestMapping(method = RequestMethod.GET)
    public List<VentaDTO> findAllByProducto(@RequestParam ProductoDTO producto) {
        log.info("ProductoRestController - findAll: Mostrando todos los productos");
        return ventaService.findAllByProducto(producto);
    }

}
