package com.example.demo.web.restcontroller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestClient.ResponseSpec;

import java.util.List;
import com.example.demo.model.dto.ClienteDTO;
import com.example.demo.service.ClienteService;
import com.example.demo.web.controller.ClienteController;
import org.springframework.web.bind.annotation.PutMapping;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/ws/clientes")
public class ClienteRestController {

    private static final Logger log = LoggerFactory.getLogger(PedidoRestController.class);

    @Autowired
    ClienteService clienteService;

    // localizamos todos los clientes
    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<ClienteDTO>> findAll() {

        log.info("ClienteRestController - findAll: Mostramos todos los clientes");

        List<ClienteDTO> listaClientesDTO = clienteService.findAll();

        return new ResponseEntity<>(listaClientesDTO, HttpStatus.OK);
    }

    // Localizamos un cliente por id
    @RequestMapping(method = RequestMethod.GET, path = "/{idCliente}")
    public ResponseEntity<ClienteDTO> findById(@PathVariable("idCliente") Long idCliente) {

        log.info("ClienteRestController - findById: Localizamos el cliente con id:" + idCliente);

        ClienteDTO clienteDTO = new ClienteDTO();
        clienteDTO.setId(idCliente);
        clienteDTO = clienteService.findById(clienteDTO);

        if (clienteDTO == null) { // si no existe el cliente
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        } else { // si existe
            return new ResponseEntity<>(clienteDTO, HttpStatus.OK);
        }
    }

    // @PostMapping()
    // public ResponseEntity add(@RequestBody ClienteDTO clienteDTO) {

    // int resultado = clienteService.save(clienteDTO);

    // log.info(ClienteController.class.getSimpleName() + " - guardando cliente" +
    // clienteDTO.toString());

    // if (resultado == 1) {
    // return new ResponseEntity<>(HttpStatus.OK);
    // } else {
    // return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    // }
    // }

    // @PutMapping()
    // public ResponseEntity update(@RequestBody ClienteDTO clienteDTO) {

    // int resultado = clienteService.save(clienteDTO);

    // log.info(ClienteController.class.getSimpleName() + " - guardando cliente" +
    // clienteDTO.toString());

    // if (resultado == 1) {
    // return new ResponseEntity<>(HttpStatus.OK);
    // } else {
    // return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    // }
    // }

    @DeleteMapping("/delete/{idCliente}")
    public ResponseEntity delete(@PathVariable("idCliente") Long idCliente) {

        log.info(ClienteController.class.getSimpleName() + " - borrando cliente" + idCliente);

        ClienteDTO cDTO = new ClienteDTO();
        cDTO.setId(idCliente);
        cDTO = clienteService.findById(cDTO);
        int resultado = clienteService.delete(cDTO);

        if (resultado == 1) {
            return new ResponseEntity<>(HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @RequestMapping(path = "/registro", method = RequestMethod.POST)
    public ResponseEntity<ClienteDTO> registro(@RequestBody ClienteDTO clienteDTO) {
        log.info(this.getClass().getSimpleName() + " registro: registrar cliente con datos: {}", clienteDTO);

        ClienteDTO saved = this.clienteService.registro(clienteDTO);

        if (saved != null) {
            return ResponseEntity.ok(saved);
        } else {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
