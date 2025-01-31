package com.example.demo.web.restcontroller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.dto.CategoriaPDTO;
import com.example.demo.service.CategoriaPService;


@RestController
@RequestMapping("/ws/categoriasp")
public class CategoriaPRestController {
    @Autowired
    private CategoriaPService categoriaPService;

    private static final Logger log = LoggerFactory.getLogger(CategoriaPRestController.class);

    @RequestMapping(method=RequestMethod.GET)
    public List<CategoriaPDTO> findAll() {
        log.info("CategoriaPRestController - findAll: Mostrando todas las categorias");
        return categoriaPService.findAll();
    }
    

}
