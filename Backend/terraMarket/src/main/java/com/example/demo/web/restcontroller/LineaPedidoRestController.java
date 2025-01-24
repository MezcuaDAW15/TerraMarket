package com.example.demo.web.restcontroller;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.model.dto.ClienteDTO;
import com.example.demo.model.dto.LineaPedidoDTO;
import com.example.demo.model.dto.PedidoDTO;
import com.example.demo.repository.entity.LineaPedido;
import com.example.demo.service.ClienteService;
import com.example.demo.service.LineaPedidoService;
import com.example.demo.service.PedidoService;
import com.example.demo.service.PedidoServiceImpl;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;


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

    // TODO preguntar ayudaa
}
