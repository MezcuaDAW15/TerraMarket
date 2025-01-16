package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.demo.model.dto.ClienteDTO;
import com.example.demo.model.dto.MetodoPagoDTO;
import com.example.demo.model.dto.PedidoDTO;
import com.example.demo.model.dto.PuntoRecogidaDTO;
import com.example.demo.repository.dao.MetodoPagoRepository;
import com.example.demo.repository.dao.PedidoRepository;
import com.example.demo.repository.dao.PuntoRecogidaRepository;
import com.example.demo.repository.entity.MetodoPago;
import com.example.demo.repository.entity.Pedido;
import com.example.demo.repository.entity.PuntoRecogida;

@Service
public class PedidoServiceImpl implements PedidoService{

    @Autowired
    PedidoRepository pedidoRepository;
	@Autowired
	MetodoPagoRepository metodoPagoRepository;
	@Autowired
	PuntoRecogidaRepository puntoRecogidaRepository;

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

	@Override
	public List<MetodoPagoDTO> findAllMetodoPago() {

		List<MetodoPago> listaMP = metodoPagoRepository.findAll();
		
		List<MetodoPagoDTO>listaMPDTO = new ArrayList<MetodoPagoDTO>();

		for (MetodoPago mp : listaMP) {
			MetodoPagoDTO mpDTO = MetodoPagoDTO.convertToDTO(mp);
			listaMPDTO.add(mpDTO);
		}

		return listaMPDTO;
	}

	@Override
	public List<PuntoRecogidaDTO> findAllPuntoRecogida() {
		
		List<PuntoRecogida> listaPR = puntoRecogidaRepository.findAll();
		
		List<PuntoRecogidaDTO>listaMPDTO = new ArrayList<PuntoRecogidaDTO>();

		for (PuntoRecogida pr : listaPR) {
			PuntoRecogidaDTO mpDTO = PuntoRecogidaDTO.convertToDTO(pr);
			listaMPDTO.add(mpDTO);
		}

		return listaMPDTO;

	}

}
