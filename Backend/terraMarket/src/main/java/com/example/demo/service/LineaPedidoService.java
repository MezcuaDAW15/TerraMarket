package com.example.demo.service;

import java.util.List;

import com.example.demo.model.dto.LineaPedidoDTO;
import com.example.demo.model.dto.PedidoDTO;

public interface LineaPedidoService {

    List<LineaPedidoDTO> findAllByPedido(PedidoDTO pedidoDTO);
    
   
}
