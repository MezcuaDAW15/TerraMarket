package com.example.demo.model.dto;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.example.demo.repository.entity.Cliente;
import lombok.Data;
import lombok.ToString;

@Data
public class ClienteDTO implements Serializable{

	private static final Logger log = LoggerFactory.getLogger(ClienteDTO.class);

    private final static long serialVersionUID = 1L;
    private Long id;
    private String nombre;
    private String apellidos;
    private String username;
    private Date fechaNacimiento;
    private String email;
    private String contrasena;
    private String cp;
    private boolean activo;
    @ToString.Exclude
    private List<PedidoDTO>listaPedidos;

    public static ClienteDTO convertToDTO(Cliente cliente) {

		ClienteDTO clienteDTO = new ClienteDTO();
		clienteDTO.setId(cliente.getId());
		clienteDTO.setNombre(cliente.getNombre());
		clienteDTO.setApellidos(cliente.getApellidos());
		clienteDTO.setUsername(cliente.getUsername());
		clienteDTO.setEmail(cliente.getEmail());
        clienteDTO.setContrasena(cliente.getContrasena());
		clienteDTO.setCp(cliente.getCp());
        clienteDTO.setActivo(cliente.isActivo());
		
		/*
		// Convertimos la lista de pedidos
		List<Pedido> listaPedidos = new ArrayList<Pedido>(cliente.getListaPedidos());

		for (int i = 0; i < listaPedidos.size(); i++) {
			PedidoDTO pedidoDTO = PedidoDTO.convertToDTO(listaPedidos.get(i), clienteDTO);
			clienteDTO.getListaPedidos().add(pedidoDTO);
		}
		 */
		log.info(ClienteDTO.class.getSimpleName() + " - convertToDTO() cliente lista pedidos " + cliente.toString());

        return clienteDTO;
    }
    // Convertir un DTO a una entidad
	public static Cliente convertToEntity(ClienteDTO clienteDTO) {

		Cliente cliente = new Cliente();

        cliente.setId(clienteDTO.getId());
		cliente.setNombre(clienteDTO.getNombre());
		cliente.setApellidos(clienteDTO.getApellidos());
		cliente.setUsername(clienteDTO.getUsername());
		cliente.setEmail(clienteDTO.getEmail());
        cliente.setContrasena(clienteDTO.getContrasena());
		cliente.setCp(clienteDTO.getCp());
        cliente.setActivo(clienteDTO.isActivo());
		/* 
		// Cargamos la lista de cuentas
		for (int i = 0; i < clienteDTO.getListaPedidos().size(); i++) {
			Pedido pedido = PedidoDTO.convertToEntity(clienteDTO.getListaPedidos().get(i));
			cliente.getListaPedidos().add(pedido);
		}
		*/
		return cliente;
	}
}
