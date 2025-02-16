package com.example.demo.web.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.servlet.ModelAndView;
import com.example.demo.model.dto.MercadoDTO;
import com.example.demo.model.dto.TiendaDTO;
import com.example.demo.service.MercadoService;
import com.example.demo.service.TiendaService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class TiendaController {

    private static final Logger log = LoggerFactory.getLogger(TiendaController.class);

    @Autowired
    TiendaService tiendaService;

    @Autowired
    MercadoService mercadoService;

    @GetMapping("/mercados/{idMercado}/tiendas")
    public ModelAndView findAllByMercado(@PathVariable("idMercado") Long idMercado) {
        log.info("TiendaController - findAllByMercado: Lista de todos las tiendas por mercado");

        MercadoDTO mercadoDTO = new MercadoDTO();
        mercadoDTO.setId(idMercado);
        mercadoDTO = mercadoService.findById(mercadoDTO);
        List<TiendaDTO> listaTiendasPorMercado = tiendaService.findAllByMercado(mercadoDTO);

        ModelAndView mav = new ModelAndView("tiendas");

        mav.addObject("listaTiendasPorMercado", listaTiendasPorMercado);
        if (listaTiendasPorMercado.size() > 0) {
            mav.addObject("mercadoDTO", listaTiendasPorMercado.get(0).getMercado());
        }

        return mav;
    }

    @GetMapping("/mercados/{idMercado}/tiendas/{idTienda}")
    public ModelAndView findById(@PathVariable("idMercado") Long idMercado, @PathVariable("idTienda") Long idTienda) {
        log.info("TiendaController - findById: Muestra la tienda por id");

        MercadoDTO mercadoDTO = new MercadoDTO();
        mercadoDTO.setId(idMercado);
        mercadoService.findById(mercadoDTO);

        TiendaDTO tiendaDTO = new TiendaDTO();
        tiendaDTO.setId(idTienda);
        tiendaDTO.setMercado(mercadoDTO);

        tiendaDTO = tiendaService.findById(tiendaDTO);

        ModelAndView mav = new ModelAndView("tiendaview");
        mav.addObject("tiendaDTO", tiendaDTO);
        return mav;
    }

    @GetMapping("/mercados/{idMercado}/tiendas/add")
    public ModelAndView add(@PathVariable("idMercado") Long idMercado) {
        log.info("TiendaController - findById: Muestra la tienda por id");

        MercadoDTO mercadoDTO = new MercadoDTO();
        mercadoDTO.setId(idMercado);
        mercadoService.findById(mercadoDTO);

        TiendaDTO tiendaDTO = new TiendaDTO();
        tiendaDTO.setMercado(mercadoDTO);

        // tiendaDTO.setIdDireccion(mercadoDTO.getIdDireccion());

        ModelAndView mav = new ModelAndView("tiendaform");
        mav.addObject("tiendaDTO", tiendaDTO);
        mav.addObject("add", true);
        return mav;
    }

    @PostMapping("/mercados/{idMercado}/tiendas/save")
    public ModelAndView save(@ModelAttribute("tiendaDTO") TiendaDTO tiendaDTO,
            @PathVariable("idMercado") Long idMercado) {

        log.info("TiendaController - save: Guardamos la tienda " + tiendaDTO.getId());

        MercadoDTO mercadoDTO = new MercadoDTO();
        mercadoDTO.setId(idMercado);
        mercadoService.findById(mercadoDTO);

        tiendaDTO.setMercado(mercadoDTO);

        tiendaService.save(tiendaDTO);

        ModelAndView mav = new ModelAndView("redirect:/mercados/{idMercado}/tiendas");
        return mav;
    }

}
