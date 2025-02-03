package com.example.demo.web.restcontroller;

import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.dto.CategoriaPDTO;
import com.example.demo.model.dto.MercadoDTO;
import com.example.demo.model.dto.ProductoDTO;
import com.example.demo.model.dto.VentaDTO;
import com.example.demo.service.VentaService;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/ws/ventas")
public class VentaRestController {

    @Autowired
    private VentaService ventaService;

    private static final Logger log = LoggerFactory.getLogger(VentaRestController.class);

    @RequestMapping(method = RequestMethod.GET)
    public List<VentaDTO> findAllByProducto(@RequestParam Long[] categorias, @RequestParam Long mercado) {
        log.info("ProductoRestController - findAll: Mostrando todos los productos");
        MercadoDTO mercadoDTO = new MercadoDTO();
        mercadoDTO.setId(mercado);
        
        CategoriaPDTO[] categoriasDTO = new CategoriaPDTO[categorias.length];
        for (int i = 0; i < categorias.length; i++) {
            CategoriaPDTO categoriaDTO = new CategoriaPDTO();
            categoriaDTO.setId(categorias[i]);
            categoriasDTO[i] = categoriaDTO;
        }

        return ventaService.findAllByCategoriasMercado(categoriasDTO, mercadoDTO);
    }

}
