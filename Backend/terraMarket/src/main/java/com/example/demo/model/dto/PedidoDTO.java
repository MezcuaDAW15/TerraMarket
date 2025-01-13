package com.example.demo.model.dto;

import java.io.Serializable;
import java.util.Date;
import com.example.demo.repository.entity.Cliente;
import com.example.demo.repository.entity.Pedido;
import lombok.Data;
import lombok.ToString;

@Data
public class PedidoDTO implements Serializable{

    private static final long serialVersionUID = 1L;
    private Long id;
    
    @ToString.Exclude
    private ClienteDTO clienteDTO;
    private MetodoPagoDTO metodoPago;
    private PuntoRecogidaDTO puntoRecogidaDTO;
    private Date fechaPedido;
    private Date fechaCompra;
    private Date fechaEntrega;
    private Date fechaMaxRecogida;
    private Date fechaFactura;
    private Long numFactura;
    private EstadoPedidoDTO estado;
    private float importe;
    
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        PedidoDTO other = (PedidoDTO) obj;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        return true;
    }
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        return result;
    }
    
    public static PedidoDTO convertToDTO(Pedido pedido, ClienteDTO clienteDTO) {

		PedidoDTO pedidoDTO = new PedidoDTO();

		pedidoDTO.setId(pedido.getId());
		pedidoDTO.setClienteDTO(clienteDTO);
        pedidoDTO.setFechaPedido(pedido.getFechaPedido());
        pedidoDTO.setFechaCompra(pedido.getFechaCompra());
        pedidoDTO.setFechaEntrega(pedido.getFechaMaxRecogida());
        pedidoDTO.setNumFactura(pedido.getNumFactura());
        pedidoDTO.setImporte(pedido.getImporte());

        pedidoDTO.setMetodoPago(MetodoPagoDTO.convertToDTO(pedido.getMetodoPago()));
        pedidoDTO.setEstado(EstadoPedidoDTO.convertToDTO(pedido.getEstado()));
        pedidoDTO.setPuntoRecogidaDTO(PuntoRecogidaDTO.convertToDTO(pedido.getPuntoRecogida()));
        
		return pedidoDTO;
	}

    public static Pedido convertToEntity(PedidoDTO pedidoDTO) {

		Pedido pedido = new Pedido();
        Cliente cliente = ClienteDTO.convertToEntity(pedidoDTO.getClienteDTO());
		
        pedido.setId(pedidoDTO.getId());
		pedido.setCliente(cliente);
        pedido.setFechaPedido(pedidoDTO.getFechaPedido());
        pedido.setFechaCompra(pedidoDTO.getFechaCompra());
        pedido.setFechaEntrega(pedidoDTO.getFechaMaxRecogida());
        pedido.setNumFactura(pedidoDTO.getNumFactura());
        pedido.setImporte(pedidoDTO.getImporte());

        pedido.setMetodoPago(MetodoPagoDTO.convertToEntity(pedidoDTO.getMetodoPago()));
        pedido.setEstado(EstadoPedidoDTO.convertToEntity(pedidoDTO.getEstado()));
        pedido.setPuntoRecogida(PuntoRecogidaDTO.convertToEntity(pedidoDTO.getPuntoRecogidaDTO()));

		return pedido;
	}
}
