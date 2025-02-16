package com.example.demo.web.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.model.dto.MercadoDTO;
import com.example.demo.service.MercadoService;

@Controller
public class MercadoController {

    private static final Logger log = LoggerFactory.getLogger(MercadoController.class);

    @Autowired
    MercadoService mercadoService;

    // Listar mercados
    @GetMapping("/mercados")
    public ModelAndView findAll() {
        log.info("MercadoController - findAll: Lista todos los mercados");
        // Recoger la lista de mercados y añadirla a la vista
        List<MercadoDTO> listaMercadosDTO = mercadoService.findAll();
        ModelAndView mav = new ModelAndView("mercados");
        mav.addObject("listaMercadosDTO", listaMercadosDTO);

        return mav;
    }

}
