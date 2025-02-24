package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.time.LocalDateTime;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.demo.model.dto.ClienteDTO;
import com.example.demo.model.dto.MetodoPagoDTO;
import com.example.demo.model.dto.PedidoDTO;
import com.example.demo.model.dto.PuntoRecogidaDTO;
import com.example.demo.repository.dao.ClienteRepository;
import com.example.demo.repository.dao.EstadoPedidoRepository;
import com.example.demo.repository.dao.MetodoPagoRepository;
import com.example.demo.repository.dao.PedidoRepository;
import com.example.demo.repository.dao.PuntoRecogidaRepository;
import com.example.demo.repository.entity.Cliente;
import com.example.demo.repository.entity.EstadoPedido;
import com.example.demo.repository.entity.MetodoPago;
import com.example.demo.repository.entity.Pedido;
import com.example.demo.repository.entity.PuntoRecogida;

@Service
public class PedidoServiceImpl implements PedidoService {

	private static final Logger log = LoggerFactory.getLogger(PedidoServiceImpl.class);

	@Autowired
	PedidoRepository pedidoRepository;

	@Autowired
	EstadoPedidoRepository estadoPedidoRepository;
	@Autowired
	ClienteRepository clienteRepository;
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
		List<PedidoDTO> listaPedidosDTO = new ArrayList<PedidoDTO>();

		for (int i = 0; i < listaPedidos.size(); ++i) {
			listaPedidosDTO.add(PedidoDTO.convertToDTO(listaPedidos.get(i), clienteDTO));
		}

		return listaPedidosDTO;
	}

	@Override
	public List<MetodoPagoDTO> findAllMetodoPago() {

		List<MetodoPago> listaMP = metodoPagoRepository.findAll();

		List<MetodoPagoDTO> listaMPDTO = new ArrayList<MetodoPagoDTO>();

		for (MetodoPago mp : listaMP) {
			MetodoPagoDTO mpDTO = MetodoPagoDTO.convertToDTO(mp);
			listaMPDTO.add(mpDTO);
		}

		return listaMPDTO;
	}

	@Override
	public List<PuntoRecogidaDTO> findAllPuntoRecogida() {

		List<PuntoRecogida> listaPR = puntoRecogidaRepository.findAll();

		List<PuntoRecogidaDTO> listaMPDTO = new ArrayList<PuntoRecogidaDTO>();

		for (PuntoRecogida pr : listaPR) {
			PuntoRecogidaDTO mpDTO = PuntoRecogidaDTO.convertToDTO(pr);
			listaMPDTO.add(mpDTO);
		}

		return listaMPDTO;

	}
	/*
	 * @Override
	 * public void save(PedidoDTO pedidoDTO) {
	 * 
	 * log.info(PedidoServiceImpl.class.getSimpleName() +
	 * " - save: guardando direccion ");
	 * 
	 * ClienteDireccion cd = new ClienteDireccion();
	 * cd = ClienteDireccionDTO.convertToEntity(cdDTO);
	 * 
	 * clienteDireccionRepository.save(cd);
	 * }
	 */

	@Override
	public PedidoDTO findById(PedidoDTO pedidoDTO) {

		log.info(PedidoServiceImpl.class.getSimpleName() + " - findById(): buscando Pedido " + pedidoDTO.getId());

		Optional<Pedido> pedido = pedidoRepository.findById(pedidoDTO.getId());

		Cliente cliente = new Cliente();
		cliente = pedido.get().getCliente();

		if (pedido.isPresent()) {
			pedidoDTO = PedidoDTO.convertToDTO(pedido.get(), ClienteDTO.convertToDTO(cliente));
		}

		return pedidoDTO;
	}

	@Override
	public PedidoDTO findPedidoPendiente(Long idCliente) {

		log.info(PedidoServiceImpl.class.getSimpleName()
				+ " - findPedidoPendiente(): buscando Pedido pendiente del cliente " + idCliente);

		Pedido pedido = pedidoRepository.findPedidoPendiente(idCliente);
		if (pedido == null) {
			pedido = new Pedido();
			pedido.setCliente(this.clienteRepository.findById(idCliente).get());
			pedido.setEstado(this.estadoPedidoRepository.findById(1L).get());
			pedido.setFechaPedido(java.sql.Timestamp.valueOf(LocalDateTime.now()));
			pedido.setMetodoPago(this.metodoPagoRepository.findById(1L).get());
			this.pedidoRepository.save(pedido);

		}
		ClienteDTO clienteDTO = new ClienteDTO();
		clienteDTO.setId(idCliente);

		return PedidoDTO.convertToDTO(pedido, clienteDTO);
	}

	@Override
	public void actualizarTotalPedido(Long id) {
		log.info(PedidoServiceImpl.class.getSimpleName() + " - actualizarTotalPedido: " + id);
		Pedido pedido = pedidoRepository.findById(id).get();
		pedido.setImporte(pedidoRepository.calcularTotalPedido(id).floatValue());
		pedidoRepository.save(pedido);
	}

}
