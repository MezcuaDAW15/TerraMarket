package com.example.demo.web.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class IndexController {
    public static final Logger log = LoggerFactory.getLogger(IndexController.class);

    @Value("${aplicacion.nombre}")
    private String nombreAplicacion;

    @GetMapping("/")
    public ModelAndView index(@AuthenticationPrincipal User user) {
        log.info("IndexController - index: Mostramos la pagina inicial");

        ModelAndView mav = new ModelAndView("index");
        mav.addObject("titulo", nombreAplicacion);

        return mav;
    }
}
