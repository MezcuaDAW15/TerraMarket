package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
import com.example.demo.web.controller.ClienteController;

@Service
public class PedidoServiceImpl implements PedidoService{

	private static final Logger log = LoggerFactory.getLogger(PedidoServiceImpl.class);

    @Autowired
    PedidoRepository pedidoRepository;
	@Autowired
	MetodoPagoRepository metodoPagoRepository;
	@Autowired
	PuntoRecogidaRepository puntoRecogidaRepository;

    @Override
    public List<PedidoDTO> findAllByCliente(ClienteDTO clienteDTO) {
        // buscamos la lista en el repositorio
		List<Pedido> listaPedidos = pedidoRepository.findAllByCliente(clienteDTO.getId());
		log.info(PedidoServiceImpl.class.getSimpleName() + " - lista pedidos: " + listaPedidos);
		// la pasamos a dto
		List <PedidoDTO> listaPedidosDTO = new ArrayList<PedidoDTO>();
		
		for(int i = 0; i < listaPedidos.size(); ++i) {
			listaPedidosDTO.add(PedidoDTO.convertToDTO(listaPedidos.get(i), clienteDTO));
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
	/* 
	@Override
	public void save(PedidoDTO pedidoDTO) {
		
		log.info(PedidoServiceImpl.class.getSimpleName() + " - save: guardando direccion ");

		ClienteDireccion cd = new ClienteDireccion();
		cd = ClienteDireccionDTO.convertToEntity(cdDTO);
		
		clienteDireccionRepository.save(cd);
	}
	*/
}
