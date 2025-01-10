package com.example.demo.web.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.ModelAndView;
import com.example.demo.model.dto.ClienteDTO;
import com.example.demo.model.dto.PedidoDTO;
import com.example.demo.service.ClienteService;
import com.example.demo.service.PedidoService;

@Controller
public class PedidosController {

	private static final Logger log = LoggerFactory.getLogger(PedidosController.class);

	@Autowired
	ClienteService clienteService;

	@Autowired
	PedidoService pedidoService;

    @GetMapping("/clientes/{idCliente}/pedidos")
	public ModelAndView findAll(@PathVariable("idCliente") Long idCliente) {
		
		// recuperar el cliente
		ClienteDTO clienteDTO = new ClienteDTO();
		clienteDTO.setId(idCliente);
		clienteDTO = clienteService.findById(clienteDTO);
		
		// buscar cuentas del cliente en el servicio
		List<PedidoDTO> listaPedidosDTO = pedidoService.findAllByCliente(clienteDTO);
		log.info(PedidosController.class.getSimpleName() + " -findAll() Lista pedidos" + clienteDTO.getNombre());
		
		ModelAndView mav = new ModelAndView("pedidosCliente");
		mav.addObject("listaPedidosDTO", listaPedidosDTO);
		mav.addObject("clienteDTO", clienteDTO);
		
		return mav;
	}
}
