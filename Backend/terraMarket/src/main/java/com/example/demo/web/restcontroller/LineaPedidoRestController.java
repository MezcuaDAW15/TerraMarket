package com.example.demo.web.restcontroller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.dto.ClienteDTO;
import com.example.demo.model.dto.PedidoDTO;
import com.example.demo.service.ClienteService;
import com.example.demo.service.LineaPedidoService;
import com.example.demo.service.PedidoService;


@RestController
@RequestMapping("/ws//clientes/{idCliente}/pedidos/view")
public class LineaPedidoRestController {

    private static final Logger log = LoggerFactory.getLogger(PedidoRestController.class);

    @Autowired
    PedidoService pedidoService;

    @Autowired
    ClienteService clienteService;

    @Autowired
    LineaPedidoService lineaPedidoService;

    
}
