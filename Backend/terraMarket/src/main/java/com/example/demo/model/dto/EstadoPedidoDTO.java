package com.example.demo.model.dto;

import java.io.Serializable;
import com.example.demo.repository.entity.EstadoPedido;
import lombok.Data;

@Data
public class EstadoPedidoDTO implements Serializable{

    private static final long serialVersionUID = 1L;
    private Long id;
    private String estado;


    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        EstadoPedidoDTO other = (EstadoPedidoDTO) obj;
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

    public static EstadoPedidoDTO convertToDTO(EstadoPedido estado) {

		EstadoPedidoDTO estadoDTO = new EstadoPedidoDTO();
		estadoDTO.setId(estado.getId());
        estadoDTO.setEstado(estado.getEstado());
		
        return estadoDTO;
    }

    public static EstadoPedido convertToEntity(EstadoPedidoDTO estadoDTO){

        EstadoPedido estado = new EstadoPedido();
        estado.setId(estadoDTO.getId());
        estado.setEstado(estadoDTO.getEstado());

        return estado;
    }
}
