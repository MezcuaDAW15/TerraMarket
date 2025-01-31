package com.example.demo.web.restcontroller;

import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.model.dto.ClienteDTO;
import com.example.demo.model.dto.LineaPedidoDTO;
import com.example.demo.model.dto.PedidoDTO;
import com.example.demo.service.ClienteService;
import com.example.demo.service.LineaPedidoService;
import com.example.demo.service.PedidoService;
import org.springframework.web.bind.annotation.RequestMethod;

@CrossOrigin
@RestController
@RequestMapping("/ws/pedidos")
public class PedidoRestController {

    private static final Logger log = LoggerFactory.getLogger(PedidoRestController.class);

    @Autowired
    private PedidoService pedidoService;
    @Autowired
    private ClienteService clienteService;
    @Autowired
	LineaPedidoService lineaPedidoService;

    @RequestMapping(method = RequestMethod.GET, path = "/clientes/{idCliente}/pedidos")
    public List<PedidoDTO> findAllByCliente(@PathVariable("idCliente") Long idCliente) {

        log.info("PedidoRestController - findAllByCliente: Mostramos pedidos del cliente " + idCliente);

        // recuperar el cliente
		ClienteDTO clienteDTO = new ClienteDTO();
		clienteDTO.setId(idCliente);
		clienteDTO = clienteService.findById(clienteDTO);

        // buscar cuentas del cliente en el servicio
		List<PedidoDTO> listaPedidosDTO = pedidoService.findAllByCliente(clienteDTO);

        return listaPedidosDTO;
    }

    @RequestMapping(method = RequestMethod.GET, path = "/clientes/{idCliente}/pedidos/{idPedido}")
	public ResponseEntity<List<LineaPedidoDTO>> view(@PathVariable("idCliente") Long idCliente, @PathVariable("idPedido") Long idPedido) {
		
		// recuperar el cliente
		ClienteDTO clienteDTO = new ClienteDTO();
		clienteDTO.setId(idCliente);
		clienteDTO = clienteService.findById(clienteDTO);
		
		// recuperar el pedido
		PedidoDTO pedidoDTO = new PedidoDTO();
		pedidoDTO.setId(idPedido);
		pedidoDTO = pedidoService.findById(pedidoDTO, clienteDTO);

		pedidoDTO.setCliente(clienteDTO);

		// recuperar lineas del pedido
		List<LineaPedidoDTO>listaLineasPedidoDTO = lineaPedidoService.findAllByPedido(pedidoDTO);
		
		if(!listaLineasPedidoDTO.isEmpty()) { 
            return new ResponseEntity<>(listaLineasPedidoDTO, HttpStatus.OK);
        } else {
			return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
		}
	}

}

