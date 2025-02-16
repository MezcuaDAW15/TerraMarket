package com.example.demo.service;

import java.util.List;

import com.example.demo.model.dto.ClienteDTO;
import com.example.demo.model.dto.LineaPedidoDTO;
import com.example.demo.model.dto.PedidoDTO;

public interface LineaPedidoService {

    List<LineaPedidoDTO> findAllByPedido(PedidoDTO pedidoDTO);

    LineaPedidoDTO editarLineaPedido(Long cantidad, Long idLineaPedido, ClienteDTO clienteDTO);

    LineaPedidoDTO borrarLineaPedido(LineaPedidoDTO lineaPedidoDTO, ClienteDTO clienteDTO);

    LineaPedidoDTO crearLineaPedido(LineaPedidoDTO lineaPedidoDTO, ClienteDTO clienteDTO);

}
