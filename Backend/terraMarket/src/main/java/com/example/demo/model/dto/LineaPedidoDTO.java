package com.example.demo.model.dto;

import java.io.Serializable;
import java.util.Date;

import com.example.demo.repository.entity.LineaPedido;
import com.example.demo.repository.entity.Pedido;

import lombok.Data;

@Data
public class LineaPedidoDTO implements Serializable{

    private static final long serialVersionUID = 1L;
    private Long id;

    private VentaDTO ventaDTO;
    private PedidoDTO pedidoDTO;
    private int cantidad;
    private Date fecha;

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        LineaPedidoDTO other = (LineaPedidoDTO) obj;
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

    public static LineaPedidoDTO convertToDTO(LineaPedido lp, PedidoDTO pedidoDTO){

        LineaPedidoDTO lpDTO = new LineaPedidoDTO();
        lpDTO.setId(lp.getId());
        lpDTO.setVentaDTO(VentaDTO.convertToDto(lp.getVenta()));
        lpDTO.setPedidoDTO(pedidoDTO);
        lpDTO.setFecha(lp.getFecha());
        lpDTO.setCantidad(lp.getCantidad());

        return lpDTO;
    }

    public static LineaPedido convertToEntity(LineaPedidoDTO lpDTO, Pedido pedido){

        LineaPedido lp = new LineaPedido();
        lp.setId(lpDTO.getId());
        lp.setVenta(VentaDTO.convertToEntity(lpDTO.getVentaDTO()));
        lp.setPedido(pedido);
        lp.setFecha(lp.getFecha());
        lp.setCantidad(lp.getCantidad());

        return null;
    }

}
