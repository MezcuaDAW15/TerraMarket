package com.example.demo.service;

import java.util.List;

import com.example.demo.model.dto.ClienteDTO;

public interface ClienteService {

    public ClienteDTO findById(ClienteDTO cDTO);
    public List<ClienteDTO> findAll();
    //public int save(ClienteDTO clienteDTO);
    public int delete(ClienteDTO cDTO);
    public ClienteDTO save(ClienteDTO clienteDTO);
	public int login(ClienteDTO clienteDTO);
    public ClienteDTO findByUsername(String username);

}

