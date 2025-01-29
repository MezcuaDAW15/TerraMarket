package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.dto.ClienteDTO;
import com.example.demo.repository.dao.ClienteRepository;
import com.example.demo.repository.entity.Cliente;

@Service
public class ClienteServiceImpl implements ClienteService{

    private static final Logger log = LoggerFactory.getLogger(ClienteServiceImpl.class);

    @Autowired
    ClienteRepository clienteRepository;

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

    @Override
    public void save(ClienteDTO clienteDTO) {
        
		log.info(ClienteServiceImpl.class.getSimpleName() + " save() - clienteDto: " + clienteDTO.toString());
		Cliente c = ClienteDTO.convertToEntity(clienteDTO);
		log.info(ClienteServiceImpl.class.getSimpleName() + " save() - cliente: " + c.toString());
		c.setActivo(true);
        clienteRepository.save(c);
    }

    @Override
    public void delete(ClienteDTO cDTO) {
        log.info(ClienteServiceImpl.class.getSimpleName() + " - borramos el cliente" + cDTO.toString());

		Cliente cliente = new Cliente();
		cliente = ClienteDTO.convertToEntity(cDTO);
        cliente.setActivo(false);

		clienteRepository.save(cliente);
    }

}
