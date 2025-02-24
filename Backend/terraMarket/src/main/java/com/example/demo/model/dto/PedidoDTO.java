package com.example.demo.model.dto;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.format.annotation.DateTimeFormat;

import com.example.demo.repository.entity.Cliente;
import com.example.demo.repository.entity.LineaPedido;
import com.example.demo.repository.entity.Pedido;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;
import lombok.ToString;

@Data
public class PedidoDTO implements Serializable {

    private static final long serialVersionUID = 1L;
    private Long id;

    @ToString.Exclude

    private ClienteDTO cliente;
    private MetodoPagoDTO metodoPago;
    private PuntoRecogidaDTO puntoRecogida;
    @DateTimeFormat(pattern = "dd-MM-yyyy")
    @JsonFormat(pattern = "dd-MM-yyyy")
    private Date fechaPedido;
    @DateTimeFormat(pattern = "dd-MM-yyyy")
    @JsonFormat(pattern = "dd-MM-yyyy")
    private Date fechaCompra;
    @DateTimeFormat(pattern = "dd-MM-yyyy")
    @JsonFormat(pattern = "dd-MM-yyyy")
    private Date fechaEntrega;
    @DateTimeFormat(pattern = "dd-MM-yyyy")
    @JsonFormat(pattern = "dd-MM-yyyy")
    private Date fechaMaxRecogida;
    private Date fechaFactura;
    private Long numFactura;
    private EstadoPedidoDTO estado;
    private float importe;
    private List<LineaPedidoDTO> lineaPedido;

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
        pedidoDTO.setCliente(clienteDTO);
        pedidoDTO.setFechaPedido(pedido.getFechaPedido());
        pedidoDTO.setFechaCompra(pedido.getFechaCompra());
        pedidoDTO.setFechaEntrega(pedido.getFechaMaxRecogida());
        pedidoDTO.setNumFactura(pedido.getNumFactura());
        pedidoDTO.setImporte(pedido.getImporte());

        pedidoDTO.setMetodoPago(MetodoPagoDTO.convertToDTO(pedido.getMetodoPago()));
        pedidoDTO.setEstado(EstadoPedidoDTO.convertToDTO(pedido.getEstado()));
        if (pedidoDTO.getPuntoRecogida() != null) {
            pedidoDTO.setPuntoRecogida(PuntoRecogidaDTO.convertToDTO(pedido.getPuntoRecogida()));

        }

        List<LineaPedidoDTO> listaLPDTO = pedido.getListaLineaPedido().stream()
                .map(lineaPedido -> {
                    LineaPedidoDTO lpDTO = new LineaPedidoDTO();
                    lpDTO = LineaPedidoDTO.convertToDTO(lineaPedido, pedidoDTO);
                    return lpDTO;
                })
                .collect(Collectors.toList());

        pedidoDTO.setLineaPedido(listaLPDTO);

        return pedidoDTO;
    }

    public static Pedido convertToEntity(PedidoDTO pedidoDTO) {

        Pedido pedido = new Pedido();
        Cliente cliente = ClienteDTO.convertToEntity(pedidoDTO.getCliente());

        pedido.setId(pedidoDTO.getId());
        pedido.setCliente(cliente);
        pedido.setFechaPedido(pedidoDTO.getFechaPedido());
        pedido.setFechaCompra(pedidoDTO.getFechaCompra());
        pedido.setFechaEntrega(pedidoDTO.getFechaMaxRecogida());
        pedido.setNumFactura(pedidoDTO.getNumFactura());
        pedido.setImporte(pedidoDTO.getImporte());

        pedido.setMetodoPago(MetodoPagoDTO.convertToEntity(pedidoDTO.getMetodoPago()));
        pedido.setEstado(EstadoPedidoDTO.convertToEntity(pedidoDTO.getEstado()));
        if (pedidoDTO.getPuntoRecogida() != null) {
            pedido.setPuntoRecogida(PuntoRecogidaDTO.convertToEntity(pedidoDTO.getPuntoRecogida()));

        }

        Set<LineaPedido> listaLP = pedidoDTO.getLineaPedido().stream()
                .map(lineaPedidoDTO -> {
                    LineaPedido lp = new LineaPedido();
                    lp = LineaPedidoDTO.convertToEntity(lineaPedidoDTO, pedido);
                    return lp;
                })
                .collect(Collectors.toSet());

        pedido.setListaLineaPedido(listaLP);

        return pedido;
    }
}
