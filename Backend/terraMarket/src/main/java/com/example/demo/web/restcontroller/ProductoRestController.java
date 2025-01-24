package com.example.demo.web.restcontroller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.dto.ProductoDTO;
import com.example.demo.service.ProductoService;




@RestController
@RequestMapping("/ws/productos")
public class ProductoRestController {

    @Autowired
    private ProductoService productoService;
    
    private static final Logger log = LoggerFactory.getLogger(ProductoRestController.class);

    @RequestMapping(method=RequestMethod.GET)
    public List<ProductoDTO> findAll() {
        log.info("ProductoRestController - findAll: Mostrando todos los productos");
        return productoService.findAll();
    }

    @GetMapping("/productos/{id}")
    public ProductoDTO findById(@PathVariable Long id) {
        log.info("ProductoRestController - findById: " + id);
        return productoService.findById(id);
    }


    @PostMapping("/productos")
    public ResponseEntity<ProductoDTO> add(@RequestBody ProductoDTO productoDTO) {
        log.info("ProductoRestController - add: " + productoDTO);
        productoDTO = productoService.save(productoDTO);
        if (productoDTO == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        } else {
            return new ResponseEntity<>(productoDTO, HttpStatus.OK);
        }
    }

    @PutMapping("/productos")
    public ResponseEntity<ProductoDTO> update(@RequestBody ProductoDTO productoDTO) {
        log.info("ProductoRestController - update: " + productoDTO);
        ProductoDTO productoExDTO = productoService.findById(productoDTO.getId());
        if (productoExDTO == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            productoDTO = productoService.save(productoDTO);
            return new ResponseEntity<>(productoDTO, HttpStatus.OK);
        }
    }
    @DeleteMapping("/productos")
    public ResponseEntity<ProductoDTO> delete(@RequestBody ProductoDTO productoDTO) {
        log.info("ProductoRestController - delete: " + productoDTO);
        ProductoDTO productoExDTO = productoService.findById(productoDTO.getId());
        if (productoExDTO == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            productoService.delete(productoDTO.getId());
            return new ResponseEntity<>(productoDTO, HttpStatus.OK);
        }
    }

}
