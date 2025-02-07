package com.example.demo.web.controller;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
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
    @GetMapping("/clientes/add")
	public ModelAndView add() {
		log.info(ClienteController.class.getSimpleName() + " - registrando cliente nuevo");

		ModelAndView mav = new ModelAndView("clienteform");

		mav.addObject("clienteDTO", new ClienteDTO()); // pasamos el objeto al form
		mav.addObject("add", true);
		return mav;
	}
    // editar cliente
    @PostMapping("clientes/save/{add}")
	public ModelAndView save(@ModelAttribute("clienteDTO") ClienteDTO clienteDTO,
			@PathVariable("add") boolean add) {

		ModelAndView mav = new ModelAndView();

		clienteService.save(clienteDTO);
		
		log.info(ClienteController.class.getSimpleName() + " - guardando cliente" + clienteDTO.toString());
		
		mav.setViewName("redirect:/clientes");
		return mav; 
		
	}
	
	@GetMapping("/clientes/delete/{idCliente}")
	public ModelAndView delete(@PathVariable("idCliente") Long idCliente) {
		log.info(ClienteController.class.getSimpleName() + " - borrando cliente" + idCliente);
		
		ClienteDTO cDTO = new ClienteDTO();
		cDTO.setId(idCliente);
        cDTO = clienteService.findById(cDTO);
		clienteService.delete(cDTO);
		
		ModelAndView mav = new ModelAndView("redirect:/clientes");
		return mav;
	}
	
	@GetMapping("/clientes/update/{idCliente}")
	public ModelAndView update(@PathVariable("idCliente") Long idCliente) {
		log.info(ClienteController.class.getSimpleName() + " - editando cliente" + idCliente);
		
		ClienteDTO cDTO = new ClienteDTO();
		cDTO.setId(idCliente);
		cDTO = clienteService.findById(cDTO);
		
		ModelAndView mav = new ModelAndView("clienteform");
		mav.addObject("clienteDTO", cDTO);
		mav.addObject("add", false);
		return mav;
	}
}
