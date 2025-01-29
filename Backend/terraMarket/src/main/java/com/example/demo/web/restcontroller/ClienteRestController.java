package com.example.demo.web.restcontroller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;
import com.example.demo.model.dto.ClienteDTO;
import com.example.demo.service.ClienteService;

@RestController
@RequestMapping("/ws/clientes")
public class ClienteRestController {

    private static final Logger log = LoggerFactory.getLogger(PedidoRestController.class);

    @Autowired
    ClienteService clienteService;

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<ClienteDTO>> findAll() {

        log.info("ClienteRestController - findAll: Mostramos todos los clientes");

        List<ClienteDTO> listaClientesDTO = clienteService.findAll();

        return new ResponseEntity<>(listaClientesDTO, HttpStatus.OK);
    }

    // Localizamos un cliente por id
    @RequestMapping(method = RequestMethod.GET, path = "/{idCliente}")
    public ResponseEntity<ClienteDTO> findById(@PathVariable("idCliente") Long idCliente){

        log.info("ClienteRestController - findById: Localizamos el cliente con id:" + idCliente);

        ClienteDTO clienteDTO = new ClienteDTO();
        clienteDTO.setId(idCliente);
        clienteDTO = clienteService.findById(clienteDTO);

        if(clienteDTO == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            return new ResponseEntity<>(clienteDTO, HttpStatus.OK);
        }
    }
}
