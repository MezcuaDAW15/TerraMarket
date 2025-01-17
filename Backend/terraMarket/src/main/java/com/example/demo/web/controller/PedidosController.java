package com.example.demo.web.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import com.example.demo.model.dto.ClienteDTO;
import com.example.demo.model.dto.DireccionDTO;
import com.example.demo.model.dto.MetodoPagoDTO;
import com.example.demo.model.dto.PedidoDTO;
import com.example.demo.model.dto.ProductoDTO;
import com.example.demo.model.dto.PuntoRecogidaDTO;
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
		log.info(PedidosController.class.getSimpleName() + " -findAll() Lista pedidos" + clienteDTO.getListaPedidos());
		
		ModelAndView mav = new ModelAndView("pedidosCliente");
		mav.addObject("listaPedidosDTO", listaPedidosDTO);
		mav.addObject("clienteDTO", clienteDTO);
		
		return mav;
	}

	// realizar pedido
	@GetMapping("/clientes/{idCliente}/pedidos/add")
	public ModelAndView add(@PathVariable("idCliente") Long idCliente) {
		
		// recuperar el cliente
		ClienteDTO clienteDTO = new ClienteDTO();
		clienteDTO.setId(idCliente);
		clienteDTO = clienteService.findById(clienteDTO);
		
		// seleccion metodo pago
		List<MetodoPagoDTO>listaMpDTO = pedidoService.findAllMetodoPago();

		// seleccion punto recogida
		List<PuntoRecogidaDTO>listaPrDTO = pedidoService.findAllPuntoRecogida();

		ModelAndView mav = new ModelAndView("pedidoform");
		mav.addObject("pedidoDTO", new PedidoDTO());
		mav.addObject("clienteDTO", clienteDTO);
		mav.addObject("listaMetodoPagoDTO", listaMpDTO);
		mav.addObject("listaPuntoRecogidaDTO", listaPrDTO);
		
		return mav;
	}

	@PostMapping("/clientes/{idCliente}/pedidos/save")
	public ModelAndView saveExistente(@PathVariable Long idCliente, 
		@ModelAttribute("pedidoDTO") PedidoDTO pedidoDTO, 
		@RequestParam("selectMP") Long idMP, @RequestParam("selectPR") Long idPR) {

		log.info(PedidosController.class.getSimpleName() + " - save: guardamos un pedido para cliente id: " + idCliente);
		
		// cliente
		ClienteDTO clienteDTO = new ClienteDTO();
		clienteDTO.setId(idCliente);
		clienteDTO = clienteService.findById(clienteDTO);

		// metodo de pago
		MetodoPagoDTO mpDTO = new MetodoPagoDTO();
		mpDTO.setId(idMP);

		// punto de recogida
		PuntoRecogidaDTO prDTO = new PuntoRecogidaDTO();
		prDTO.setId(idPR);

		// pedido
		pedidoDTO.setClienteDTO(clienteDTO);
		pedidoDTO.setMetodoPago(mpDTO);
		pedidoDTO.setPuntoRecogidaDTO(prDTO);

		// guardamos en el servicio
		//direccionService.save(pedidoDTO);
			
		ModelAndView mav = new ModelAndView("redirect:/clientes/{idCliente}/direcciones");
		
		return mav;
	}
}
