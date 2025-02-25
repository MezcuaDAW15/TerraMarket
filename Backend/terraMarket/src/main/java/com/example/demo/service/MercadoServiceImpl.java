package com.example.demo.service;

import java.text.Normalizer;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.regex.Pattern;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.dto.MercadoDTO;
import com.example.demo.repository.dao.MercadoRepository;
import com.example.demo.repository.entity.Mercado;

@Service
public class MercadoServiceImpl implements MercadoService {

    private static final Logger log = LoggerFactory.getLogger(MercadoServiceImpl.class);

    @Autowired
    private MercadoRepository mercadoRepository;

    @Override
    public List<MercadoDTO> findAll() {
        log.info("MercadoServiceImpl - findAll: Lista de todos los mercados");
        List<MercadoDTO> listaMercadosDTO = new ArrayList<MercadoDTO>();
        mercadoRepository.findAll().forEach(mercado -> {
            MercadoDTO mercadoDTO = MercadoDTO.convertToDTO(mercado);
            listaMercadosDTO.add(mercadoDTO);
        });
        return listaMercadosDTO;
    }

    @Override
    public MercadoDTO findById(MercadoDTO mercadoDTO) {
        Optional<Mercado> mercado = mercadoRepository.findById(mercadoDTO.getId());
        if (mercado.isPresent()) {
            mercadoDTO = MercadoDTO.convertToDTO(mercado.get());
            return mercadoDTO;
        } else {
            return null;
        }

    }

    @Override
    public Map<Long, String> findRutas() {
        log.info("MercadoServiceImpl - findRutas: Localizamos las rutas de los mercados");
        Map<Long, String> rutas = new java.util.HashMap<>();
        List<Mercado> listaMercados = mercadoRepository.findAll();
        Pattern pattern = Pattern.compile("\\p{InCombiningDiacriticalMarks}+");

        for (Mercado mercado : listaMercados) {
            // Normalizamos y eliminamos las tildes en línea
            String ruta = Normalizer.normalize(mercado.getNombre(), Normalizer.Form.NFD);
            ruta = pattern.matcher(ruta).replaceAll("");
            ruta = ruta.toLowerCase().replace(" ", "-");
            rutas.put(mercado.getId(), ruta);
        }
        return rutas;
    }

}
