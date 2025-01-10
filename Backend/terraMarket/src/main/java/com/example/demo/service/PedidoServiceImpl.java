package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.demo.model.dto.ClienteDTO;
import com.example.demo.model.dto.PedidoDTO;
import com.example.demo.repository.dao.PedidoRepository;
import com.example.demo.repository.entity.Pedido;

@Service
public class PedidoServiceImpl implements PedidoService{

    @Autowired
    PedidoRepository pedidoRepository;

    @Override
    public List<PedidoDTO> findAllByCliente(ClienteDTO clienteDTO) {
        // buscamos la lista en el repositorio
		List<Pedido> listaCuentas = pedidoRepository.findAllByCliente(clienteDTO.getId());
		
		// la pasamos a dto
		List <PedidoDTO> listaPedidosDTO = new ArrayList<PedidoDTO>();
		
		for(int i = 0; i < listaCuentas.size(); ++i) {
			listaPedidosDTO.add(PedidoDTO.convertToDTO(listaCuentas.get(i), clienteDTO));
		}
		
		return listaPedidosDTO;
    }

}
