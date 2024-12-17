package com.example.demo.web.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.servlet.ModelAndView;

import com.fasterxml.jackson.annotation.JsonCreator.Mode;

import ch.qos.logback.core.model.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class IndexController {
    public static final Logger log = LoggerFactory.getLogger(IndexController.class);

    @Value("${aplicacion.nombre}")
    private String nombreAplicacion;

    @GetMapping("/")
    public ModelAndView index() {
        log.info("IndexController - index: Mostramos la pagina inicial");

        ModelAndView mav = new ModelAndView("index");
        mav.addObject("titulo", nombreAplicacion);

        return mav;
    }
}
