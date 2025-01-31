package com.example.demo.service;

import java.util.List;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.dto.ProductoDTO;
import com.example.demo.model.dto.VentaDTO;
import com.example.demo.repository.dao.VentaRepository;
import com.example.demo.repository.entity.Producto;
import com.example.demo.repository.entity.Venta;

@Service
public class VentaServiceImpl implements VentaService {

    @Autowired
    private VentaRepository ventaRepository;

    private static final Logger log = LoggerFactory.getLogger(VentaServiceImpl.class);

    @Override
    public List<VentaDTO> findAllByProducto(ProductoDTO productoDTO) {

        Producto producto = ProductoDTO.convertToEntity(productoDTO);

        List<Venta> ventas = ventaRepository.findAllByProducto(producto);

        return ventas.stream().map(venta -> VentaDTO.convertToDto(venta))
                .collect(Collectors.toList());

    }

}
