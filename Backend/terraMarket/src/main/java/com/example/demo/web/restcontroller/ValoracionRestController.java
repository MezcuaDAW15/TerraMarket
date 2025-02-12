package com.example.demo.web.restcontroller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.dto.TiendaDTO;
import com.example.demo.model.dto.ValoracionDTO;
import com.example.demo.service.ValoracionService;

@RestController
@RequestMapping("/ws/valoraciones")
public class ValoracionRestController {

    private static final Logger log = LoggerFactory.getLogger(ValoracionRestController.class);

    @Autowired
    ValoracionService valoracionService;

    // Listar por tienda
    @RequestMapping(method = RequestMethod.GET, path = "/tiendas/{idTienda}")
    public ResponseEntity<List<ValoracionDTO>> findByTienda(@PathVariable("idTienda") Long idTienda) {
        log.info("ValoracionRestController - findByTienda: Lista de todas las valoraciones por tienda");
        TiendaDTO tiendaDTO = new TiendaDTO();
        tiendaDTO.setId(idTienda);
        ValoracionDTO valoracionDTO = new ValoracionDTO();
        valoracionDTO.setTienda(tiendaDTO);
        List<ValoracionDTO> listaValTienda = valoracionService.findByTienda(valoracionDTO);

        return new ResponseEntity<>(listaValTienda, HttpStatus.OK);
    }

    // Agregar tienda
    @PostMapping()
    public ValoracionDTO addValoracion(@RequestBody ValoracionDTO valoracionDTO) {
        log.info("ValoracionRestController - add: Agregamos una nueva tienda");
        valoracionService.save(valoracionDTO);
        return valoracionDTO;
    }

}
