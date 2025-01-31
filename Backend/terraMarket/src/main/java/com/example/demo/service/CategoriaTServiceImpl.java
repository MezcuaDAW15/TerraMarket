package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.dto.CategoriaPDTO;
import com.example.demo.model.dto.CategoriaTDTO;
import com.example.demo.repository.dao.CategoriaPRepository;
import com.example.demo.repository.dao.CategoriaTRepository;
import com.example.demo.repository.entity.CategoriaT;

@Service
public class CategoriaTServiceImpl implements CategoriaTService {
    @Autowired
    private CategoriaTRepository categoriaTRepository;
    @Autowired
    private CategoriaPService categoriaPService;

    @Override
    public List<CategoriaTDTO> findAll() {
        List<CategoriaTDTO> listaCategoriaTDTO = new ArrayList<CategoriaTDTO>();
        List<CategoriaT> listaCategorias = categoriaTRepository.findAll();
        for (CategoriaT categoria : listaCategorias) {
            List<CategoriaPDTO> listaCategoriaPDTO = categoriaPService.findByIdCategoriaT(categoria.getId());
            CategoriaTDTO categoriaDTO = CategoriaTDTO.convertToDTO(categoria);
            categoriaDTO.setListaCategoriaP(listaCategoriaPDTO);
            listaCategoriaTDTO.add(categoriaDTO);
        }
        return listaCategoriaTDTO;
    }

}
