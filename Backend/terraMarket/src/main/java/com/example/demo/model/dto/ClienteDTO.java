package com.example.demo.model.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.format.annotation.DateTimeFormat;
import com.example.demo.repository.entity.Cliente;
import com.example.demo.repository.entity.Rol;
import com.fasterxml.jackson.annotation.JsonIgnore;
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
	@DateTimeFormat(iso = DateTimeFormat.ISO.DATE, pattern = "yyyy-MM-dd")
	private Date fechaNacimiento;
    private String email;
    private String contrasena;
    private String cp;
    private boolean activo;
    @ToString.Exclude
	@JsonIgnore
    private List<PedidoDTO>listaPedidos;

	@ToString.Exclude
	@JsonIgnore
 	private List<RolDTO> rolesDTO;

    public static ClienteDTO convertToDTO(Cliente cliente) {

		ClienteDTO clienteDTO = new ClienteDTO();
		clienteDTO.setId(cliente.getId());
		clienteDTO.setNombre(cliente.getNombre());
		clienteDTO.setApellidos(cliente.getApellidos());
		clienteDTO.setUsername(cliente.getUsername());
		clienteDTO.setEmail(cliente.getEmail());
        clienteDTO.setContrasena(cliente.getContrasena());
		clienteDTO.setFechaNacimiento(cliente.getFechaNacimiento());
		clienteDTO.setCp(cliente.getCp());
        clienteDTO.setActivo(cliente.isActivo());

		// for (int i = 0; i < cliente.getRoles().size(); i++) {
		// 	RolDTO rolDTO = RolDTO.converToDTO(cliente.getRoles().get(i), clienteDTO);
		// 	clienteDTO.getRolesDTO().add(rolDTO);
		// }
		for (Rol rol : cliente.getRoles()) {
			RolDTO rolDTO = RolDTO.converToDTO(rol, clienteDTO);
			clienteDTO.getRolesDTO().add(rolDTO);
		}
		
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
		cliente.setFechaNacimiento(clienteDTO.getFechaNacimiento());
		cliente.setCp(clienteDTO.getCp());
        cliente.setActivo(clienteDTO.isActivo());

		for (int i = 0; i < clienteDTO.getRolesDTO().size(); i++) {
			Rol rol = RolDTO.converToEntity(clienteDTO.getRolesDTO().get(i), cliente);
			cliente.getRoles().add(rol);
		}
		
		return cliente;
	}

	public ClienteDTO() {
		super();
		this.rolesDTO = new ArrayList<RolDTO>();
	}
}
