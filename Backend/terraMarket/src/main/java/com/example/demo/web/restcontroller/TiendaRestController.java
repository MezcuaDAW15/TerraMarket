package com.example.demo.web.restcontroller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.dto.MercadoDTO;
import com.example.demo.model.dto.TiendaDTO;
import com.example.demo.service.DireccionService;
import com.example.demo.service.MercadoService;
import com.example.demo.service.TiendaService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/ws/mercados/{idMercado}/tiendas")
public class TiendaRestController {

    private static final Logger log = LoggerFactory.getLogger(TiendaRestController.class);

    @Autowired
    TiendaService tiendaService;

    @Autowired
    MercadoService mercadoService;

    @Autowired
    DireccionService direccionService;

    // Listar
    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<TiendaDTO>> findAllByMercado(@PathVariable("idMercado") Long idMercado) {
        log.info("TiendaRestController - findAllByMercado: Lista de todos las tiendas por mercado");

        MercadoDTO mercadoDTO = new MercadoDTO();
        mercadoDTO.setId(idMercado);
        mercadoDTO = mercadoService.findById(mercadoDTO);
        List<TiendaDTO> listaTiendasPorMercado = tiendaService.findAllByMercado(mercadoDTO);

        return new ResponseEntity<>(listaTiendasPorMercado, HttpStatus.OK);
    }

    // Ver tienda
    @RequestMapping(method = RequestMethod.GET, path = "/{idTienda}")
    public ResponseEntity<TiendaDTO> findById(@PathVariable("idMercado") Long idMercado,
            @PathVariable("idTienda") Long idTienda) {
        log.info("TiendaRestController - findById: Muestra la tienda por id");

        MercadoDTO mercadoDTO = new MercadoDTO();
        mercadoDTO.setId(idMercado);
        mercadoService.findById(mercadoDTO);

        TiendaDTO tiendaDTO = new TiendaDTO();
        tiendaDTO.setId(idTienda);
        tiendaDTO.setMercadoDTO(mercadoDTO);

        tiendaDTO = tiendaService.findById(tiendaDTO);

        if (tiendaDTO == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            return new ResponseEntity<>(tiendaDTO, HttpStatus.OK);
        }
    }

    // Agregar tienda
    @PostMapping()
    public TiendaDTO postMethodName(@RequestBody TiendaDTO tiendaDTO) {
        log.info("TiendaRestController - add: Agregamos una nueva tienda");
        tiendaService.save(tiendaDTO);
        return tiendaDTO;
    }

}
