package com.example.demo.web.controller;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;
import java.util.List;
import org.slf4j.Logger;
import com.example.demo.model.dto.ClienteDTO;
import com.example.demo.service.ClienteService;

@Controller
public class ClienteController {

    private static final Logger log = LoggerFactory.getLogger(ClienteController.class);

    @Autowired
    ClienteService clienteService;

    @GetMapping("/clientes")
	public ModelAndView findAll() {
		log.info(ClienteController.class.getSimpleName() + " -findAll() Lista clientes");

		ModelAndView mav = new ModelAndView("clientes");
		List<ClienteDTO> listaClientesDTO = clienteService.findAll();
		mav.addObject("listaClientesDTO", listaClientesDTO);
		
		return mav;
	}

    // nuevo cliente
    // editar cliente
    // desactivar cuenta usuario
}
