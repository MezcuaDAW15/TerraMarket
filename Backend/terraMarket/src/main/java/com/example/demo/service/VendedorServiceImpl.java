package com.example.demo.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.dto.VendedorDTO;
import com.example.demo.repository.dao.VendedorRepository;
import com.example.demo.repository.entity.Vendedor;

@Service
public class VendedorServiceImpl implements VendedorService {

    @Autowired
    VendedorRepository vendedorRepository;

    @Override
    public VendedorDTO findById(VendedorDTO vendedorDTO) {

        Optional<Vendedor> vendedorOp = vendedorRepository.findById(vendedorDTO.getId());

        if (vendedorOp.isPresent()) {
            Vendedor vendedor = vendedorOp.get();
            vendedorDTO = VendedorDTO.convertToDTO(vendedor);
            return vendedorDTO;
        } else {
            return null;
        }
    }

}
