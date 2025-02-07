package com.example.demo.web.controller;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import java.util.List;
import org.slf4j.Logger;
import com.example.demo.model.dto.ClienteDTO;
import com.example.demo.model.dto.RolDTO;
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
    // @PostMapping("clientes/save/{add}")
	// public ModelAndView save(@ModelAttribute("clienteDTO") ClienteDTO clienteDTO,
	// 		@PathVariable("add") boolean add) {

	// 	ModelAndView mav = new ModelAndView();

	// 	clienteService.save(clienteDTO);
		
	// 	log.info(ClienteController.class.getSimpleName() + " - guardando cliente" + clienteDTO.toString());
		
	// 	mav.setViewName("redirect:/clientes");
	// 	return mav; 
		
	// }
	
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

	// Alta de usuarios
	@GetMapping("/register")
		public ModelAndView register() {
		log.info("UsuarioController - register: Mostramos la pantalla de registro");
		ModelAndView mav = new ModelAndView("register");
		mav.addObject("clienteDTO", new ClienteDTO());
		// retornamos el ModelAndView
		return mav;
	}

	 // Alamcenar usuarios
	@PostMapping("/clientes/save")
	public ModelAndView save(@ModelAttribute("usuarioDTO") ClienteDTO clienteDTO,
	@RequestParam String[] roles) {
		log.info("ClienteController - save: Salvamos los datos del usuario:" + clienteDTO.toString());

		for (String param : roles) {
			RolDTO rolDTO = new RolDTO();
			rolDTO.setNombre(param);
			rolDTO.setClienteDTO(clienteDTO);
			clienteDTO.getRolesDTO().add(rolDTO);
		}
		log.error("ClienteController - save: Salvamos los datos del usuario:" + clienteDTO.toString());
		// Invocamos a la capa de servicios para que almacene los datos del usuario
		clienteService.save(clienteDTO);

		// Redireccionamos para volver a invocar a la raiz
		ModelAndView mav = new ModelAndView("redirect:/");
		return mav;
	}
}
