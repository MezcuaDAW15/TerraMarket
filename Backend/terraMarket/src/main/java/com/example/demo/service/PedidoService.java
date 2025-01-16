package com.example.demo.service;

import java.util.List;

import com.example.demo.model.dto.ClienteDTO;
import com.example.demo.model.dto.MetodoPagoDTO;
import com.example.demo.model.dto.PedidoDTO;
import com.example.demo.model.dto.PuntoRecogidaDTO;

public interface PedidoService {

    List<PedidoDTO> findAllByCliente(ClienteDTO clienteDTO);

    List<MetodoPagoDTO> findAllMetodoPago();

    List<PuntoRecogidaDTO> findAllPuntoRecogida();

    //void save(PedidoDTO pedidoDTO);

}
