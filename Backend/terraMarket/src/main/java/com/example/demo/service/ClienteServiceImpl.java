package com.example.demo.service;

import java.time.Instant;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import com.example.demo.model.dto.ClienteDTO;
import com.example.demo.model.dto.RolDTO;
import com.example.demo.repository.dao.ClienteRepository;
import com.example.demo.repository.dao.RolRepository;
import com.example.demo.repository.entity.Cliente;
import com.example.demo.repository.entity.Rol;
import com.example.demo.utils.EncriptaPassword;

@Service
public class ClienteServiceImpl implements ClienteService, UserDetailsService{

    private static final Logger log = LoggerFactory.getLogger(ClienteServiceImpl.class);

    @Autowired
    ClienteRepository clienteRepository;
    @Autowired
    RolRepository rolRepository;

    @Override
    public ClienteDTO findById(ClienteDTO cDTO) {

        log.info(ClienteServiceImpl.class.getSimpleName() + " - buscando cliente " + cDTO.toString());
		
		Optional<Cliente> cliente = clienteRepository.findById(cDTO.getId());
		if(cliente.isPresent()) {
			cDTO = ClienteDTO.convertToDTO(cliente.get());
            return cDTO;
		} else {
            return null;
        }

        
    }

    @Override
    public List<ClienteDTO> findAll() {
		
		//solicitamos lista de entidades al repositorio 
		List<Cliente>listaClientes = clienteRepository.findAll();
		List<ClienteDTO>listaClientesDTO = new ArrayList<ClienteDTO>();	
		
        log.info(ClienteServiceImpl.class.getSimpleName() + " -findAll() lista Entidades ");

		for(Cliente c : listaClientes) {
			ClienteDTO cDTO = ClienteDTO.convertToDTO(c);
			listaClientesDTO.add(cDTO);
		}
		
		return listaClientesDTO;
    }

    // @Override
    // public int save(ClienteDTO clienteDTO) {
        
	// 	log.info(ClienteServiceImpl.class.getSimpleName() + " save() - clienteDto: " + clienteDTO.toString());
	// 	Cliente c = ClienteDTO.convertToEntity(clienteDTO);
	// 	log.info(ClienteServiceImpl.class.getSimpleName() + " save() - cliente: " + c.toString());
	// 	c.setActivo(true);

    //     c = clienteRepository.save(c);

    //     if (c != null) {
    //         return 1;
    //     } else {
    //         return 0;
    //     }
    // }
    @Override
    public void save(ClienteDTO clienteDTO) {
        log.info("UsuarioServiceImpl - save: salvamos el usuario : " + clienteDTO.toString());
        Cliente cliente = new Cliente();
        clienteDTO.setContrasena(EncriptaPassword.encriptarPassword(clienteDTO.getContrasena()));

        cliente = ClienteDTO.convertToEntity(clienteDTO);
        cliente.setFechaNacimiento(Date.from(Instant.now()));
        cliente.setActivo(true);
        clienteRepository.save(cliente);
        log.info("UsuarioServiceImpl - save: salvamos el usuario ENTIDAD: " + cliente.toString());
    }


    @Override
    public int delete(ClienteDTO cDTO) {
        log.info(ClienteServiceImpl.class.getSimpleName() + " - borramos el cliente" + cDTO.toString());

		Cliente cliente = new Cliente();
		cliente = ClienteDTO.convertToEntity(cDTO);
        cliente.setActivo(false);
        if (clienteRepository.existsById(cDTO.getId())){
            clienteRepository.save(cliente);
            return 1;
        } else {
            return 0;
        }
		
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        log.info("UsuarioServiceImpl - loadUserByUsername: " + username);

        Cliente usuario = clienteRepository.findByUsername(username);
        if(usuario != null) {

            List<GrantedAuthority> listaPermisos = new ArrayList<GrantedAuthority>();
            List<Rol> listaRoles = new ArrayList<Rol>(usuario.getRoles());

            for(Rol rol:listaRoles) {
                listaPermisos.add(new SimpleGrantedAuthority(rol.getNombre()));
            }

            return new User(usuario.getUsername(), usuario.getContrasena(), listaPermisos);
        } else {
            throw new UsernameNotFoundException(username);
        }
    }

}
