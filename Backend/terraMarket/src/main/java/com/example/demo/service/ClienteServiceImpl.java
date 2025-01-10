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
		}

        return cDTO;
    }

    @Override
    public List<ClienteDTO> findAll() {
		
		//solicitamos lista de entidades al repositorio 
		List<Cliente>listaClientes = clienteRepository.findAll();
		List<ClienteDTO>listaClientesDTO = new ArrayList<ClienteDTO>();	
		
        log.info(ClienteServiceImpl.class.getSimpleName() + " -findAll() lista Entidades " + listaClientes);

		for(Cliente c : listaClientes) {
			ClienteDTO cDTO = ClienteDTO.convertToDTO(c);
			listaClientesDTO.add(cDTO);
		}

        log.info(ClienteServiceImpl.class.getSimpleName() + " -findAll() lista DTO " + listaClientesDTO);
		
		return listaClientesDTO;
    }

}
