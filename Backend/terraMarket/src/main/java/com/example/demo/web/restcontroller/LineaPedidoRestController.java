package com.example.demo.web.restcontroller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.dto.ClienteDTO;
import com.example.demo.model.dto.LineaPedidoDTO;
import com.example.demo.model.dto.PedidoDTO;
import com.example.demo.repository.entity.Pedido;
import com.example.demo.service.ClienteService;
import com.example.demo.service.LineaPedidoService;
import com.example.demo.service.PedidoService;
import org.springframework.web.bind.annotation.PostMapping;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/ws/clientes/{idCliente}/pedidos")
public class LineaPedidoRestController {

    private static final Logger log = LoggerFactory.getLogger(PedidoRestController.class);

    @Autowired
    PedidoService pedidoService;

    @Autowired
    ClienteService clienteService;

    @Autowired
    LineaPedidoService lineaPedidoService;

    @PutMapping("/{id}/alterLineaPedido/{idLineaPedido}")
    public LineaPedidoDTO editarLineaPedido(@RequestBody Long cantidad, @PathVariable Long idCliente,
            @PathVariable Long id, @PathVariable Long idLineaPedido) {
        log.info("LineaPedidoRestController - editarLineaPedido: " + cantidad);
        ClienteDTO clienteDTO = new ClienteDTO();
        clienteDTO.setId(idCliente);

        return lineaPedidoService.editarLineaPedido(cantidad, idLineaPedido, clienteDTO);

    }

    @PostMapping("/{id}/alterLineaPedido")
    public LineaPedidoDTO crearLineaPedido(@RequestBody LineaPedidoDTO lineaPedidoDTO, @PathVariable Long idCliente,
            @PathVariable Long id) {
        log.info("LineaPedidoRestController - crearLineaPedido: " + lineaPedidoDTO);
        ClienteDTO clienteDTO = new ClienteDTO();
        clienteDTO.setId(idCliente);
        PedidoDTO pedidoDTO = new PedidoDTO();
        pedidoDTO.setId(id);
        lineaPedidoDTO.setPedido(pedidoDTO);

        return lineaPedidoService.crearLineaPedido(lineaPedidoDTO, clienteDTO);

    }

    @DeleteMapping("/{id}/alterLineaPedido/{idLineaPedido}")
    public LineaPedidoDTO borrarLineaPedido(@PathVariable Long idLineaPedido, @PathVariable Long idCliente) {
        log.info("LineaPedidoRestController - borrarLineaPedido: " + idLineaPedido);
        ClienteDTO clienteDTO = new ClienteDTO();
        clienteDTO.setId(idCliente);

        LineaPedidoDTO lineaPedidoDTO = new LineaPedidoDTO();
        lineaPedidoDTO.setId(idLineaPedido);

        return lineaPedidoService.borrarLineaPedido(lineaPedidoDTO, clienteDTO);

    }

}
