package com.example.demo.service;

import java.util.List;

import com.example.demo.model.dto.ClienteDTO;

public interface ClienteService {

    public ClienteDTO findById(ClienteDTO cDTO);
    public List<ClienteDTO> findAll();
    public void save(ClienteDTO clienteDTO);
    public void delete(ClienteDTO cDTO);
    
}

