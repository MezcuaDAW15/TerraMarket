package com.example.demo.web.restcontroller;

import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.example.demo.model.dto.MetodoPagoDTO;
import com.example.demo.service.PedidoService;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/ws/metodospago")
public class MetodoPagoRestController {

    @Autowired
    PedidoService pedidoService;

    private static final Logger log = LoggerFactory.getLogger(MercadoRestController.class);

    // mostrar lista metodos pago
    @RequestMapping(method = RequestMethod.GET)
    public List<MetodoPagoDTO> findAll() {

        log.info("MetodoPagoRestController - findAll");

        // buscar cuentas del cliente en el servicio
        List<MetodoPagoDTO> listaMedotoPagoDTO = pedidoService.findAllMetodoPago();

        return listaMedotoPagoDTO;
    }
}
