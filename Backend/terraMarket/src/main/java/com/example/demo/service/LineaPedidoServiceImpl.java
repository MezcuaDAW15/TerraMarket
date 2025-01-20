package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.dto.LineaPedidoDTO;
import com.example.demo.model.dto.PedidoDTO;
import com.example.demo.repository.dao.LineaPedidoRepository;
import com.example.demo.repository.entity.LineaPedido;
import com.example.demo.repository.entity.Pedido;
import com.example.demo.web.controller.PedidosController;

@Service
public class LineaPedidoServiceImpl implements LineaPedidoService{

    private static final Logger log = LoggerFactory.getLogger(LineaPedidoServiceImpl.class);

    @Autowired
    LineaPedidoRepository lineaPedidoRepository;

    @Override
    public List<LineaPedidoDTO> findAllByPedido(PedidoDTO pedidoDTO) {
        
        // buscamos la lista en el repositorio
		List<LineaPedido> listaLineasPedido = lineaPedidoRepository.findAllByPedido(pedidoDTO.getId());
		log.info(PedidoServiceImpl.class.getSimpleName() + " - lista lineas pedido repositorio: " + listaLineasPedido);

		// la pasamos a dto
		List <LineaPedidoDTO> listaLineasPedidoDTO = new ArrayList<LineaPedidoDTO>();
		
		for(int i = 0; i < listaLineasPedido.size(); ++i) {
			listaLineasPedidoDTO.add(LineaPedidoDTO.convertToDTO(listaLineasPedido.get(i), pedidoDTO));
		}

        return listaLineasPedidoDTO;
    }

}
