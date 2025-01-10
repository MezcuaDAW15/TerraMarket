package com.example.demo.web.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.model.dto.MercadoDTO;
import com.example.demo.model.dto.TiendaDTO;
import com.example.demo.service.TiendaService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class TiendaController {

    private static final Logger log = LoggerFactory.getLogger(TiendaController.class);

    @Autowired
    TiendaService tiendaService;

    @GetMapping("/mercados/{idMercado}/tiendas")
    public ModelAndView findAllByMercado(@PathVariable("idMercado") Long idMercado) {
        log.info("TiendaController - findAllByMercado: Lista de todos las tiendas por mercado");

        MercadoDTO mercadoDTO = new MercadoDTO();
        mercadoDTO.setId(idMercado);

        List<TiendaDTO> listaTiendasPorMercado = tiendaService.findAllByMercado(mercadoDTO);

        ModelAndView mav = new ModelAndView("tiendas");

        mav.addObject("listaTiendasPorMercado", listaTiendasPorMercado);
        if (listaTiendasPorMercado.size() > 0) {
            mav.addObject("mercadoDTO", listaTiendasPorMercado.get(0).getMercadoDTO());
        }

        return mav;
    }
}
