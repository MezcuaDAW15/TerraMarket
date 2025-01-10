package com.example.demo.service;

import java.util.List;

import com.example.demo.model.dto.ClienteDTO;
import com.example.demo.model.dto.PedidoDTO;

public interface PedidoService {

    List<PedidoDTO> findAllByCliente(ClienteDTO clienteDTO);

}
