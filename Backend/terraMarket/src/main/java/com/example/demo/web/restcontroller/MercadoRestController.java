package com.example.demo.web.restcontroller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.dto.MercadoDTO;
import com.example.demo.service.MercadoService;

@RestController
@RequestMapping("/ws/mercados")
public class MercadoRestController {

    private static final Logger log = LoggerFactory.getLogger(MercadoRestController.class);

    @Autowired
    MercadoService mercadoService;

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<MercadoDTO>> findAll() {
        log.info("MercadoController - findAll: Lista todos los mercados");

        List<MercadoDTO> listaMercadosDTO = mercadoService.findAll();

        return new ResponseEntity<>(listaMercadosDTO, HttpStatus.OK);
    }

}
