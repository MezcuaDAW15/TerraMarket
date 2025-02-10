package com.example.demo.web.restcontroller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.dto.MercadoDTO;
import com.example.demo.service.MercadoService;

@CrossOrigin
@RestController
@RequestMapping("/ws/market")
public class MercadoRestController {
    @Autowired
    private MercadoService mercadoService;

    private static final Logger log = LoggerFactory.getLogger(MercadoRestController.class);

    @GetMapping("/{idMercado}")
    public ResponseEntity<MercadoDTO> findById(@PathVariable("idMercado") Long idMercado) {
        log.info("MercadoRestController - findById: Localizamos el mercado con id: " + idMercado);
        MercadoDTO mercadoDTO = new MercadoDTO();
        mercadoDTO.setId(idMercado);
        mercadoDTO = mercadoService.findById(mercadoDTO);
        if (mercadoDTO == null) {
            return ResponseEntity.notFound().build();
            // return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            return ResponseEntity.ok(mercadoDTO);
        }

    }

}
