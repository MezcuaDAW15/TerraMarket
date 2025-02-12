package com.example.demo.web.restcontroller;

import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.demo.model.dto.ClienteDTO;
import com.example.demo.model.dto.PedidoDTO;
import com.example.demo.service.ClienteService;
import com.example.demo.service.PedidoService;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@CrossOrigin
@RestController
@RequestMapping("/ws/clientes/{idCliente}/pedidos")
public class PedidoRestController {

    private static final Logger log = LoggerFactory.getLogger(PedidoRestController.class);

    @Autowired
    private PedidoService pedidoService;
    @Autowired
    private ClienteService clienteService;

    @RequestMapping(method = RequestMethod.GET)
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

    @RequestMapping(method = RequestMethod.GET, path = "/buscarPedidoPendiente")
    public PedidoDTO buscarPedidoPendiente(@RequestParam Long idCliente) {

        log.info("PedidoRestController - buscarPedidoPendiente: Mostramos pedidos pendientes");

        // buscar cuentas del cliente en el servicio
        return pedidoService.findPedidoPendiente(idCliente);

    }

    @RequestMapping(method = RequestMethod.GET, path = "/{idPedido}")
    public PedidoDTO findById(@PathVariable("idPedido") Long idPedido) {

        log.info("PedidoRestController - buscarPedido por id");

        PedidoDTO  pedidoDTO= new PedidoDTO();
        pedidoDTO.setId(idPedido);
        // buscar cuentas del cliente en el servicio
        return pedidoService.findById(pedidoDTO);

    }
}
