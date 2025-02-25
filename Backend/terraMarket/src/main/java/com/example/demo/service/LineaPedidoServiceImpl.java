package com.example.demo.service;

import java.time.Instant;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.dto.ClienteDTO;
import com.example.demo.model.dto.LineaPedidoDTO;
import com.example.demo.model.dto.MercadoDTO;
import com.example.demo.model.dto.PedidoDTO;
import com.example.demo.model.dto.TiendaDTO;
import com.example.demo.repository.dao.LineaPedidoRepository;
import com.example.demo.repository.dao.MercadoRepository;
import com.example.demo.repository.dao.PedidoRepository;
import com.example.demo.repository.dao.TiendaRepository;
import com.example.demo.repository.dao.VentaRepository;
import com.example.demo.repository.entity.LineaPedido;
import com.example.demo.repository.entity.Mercado;
import com.example.demo.repository.entity.Tienda;

@Service
public class LineaPedidoServiceImpl implements LineaPedidoService {

    private static final Logger log = LoggerFactory.getLogger(LineaPedidoServiceImpl.class);

    @Autowired
    LineaPedidoRepository lineaPedidoRepository;
    @Autowired
    VentaRepository ventaRepository;
    @Autowired
    PedidoRepository pedidoRepository;
    @Autowired
    TiendaRepository tiendaRepository;
    @Autowired
    MercadoRepository mercadoRepository;
    @Autowired
    PedidoService pedidoService;

    @Override
    public List<LineaPedidoDTO> findAllByPedido(PedidoDTO pedidoDTO) {

        // buscamos la lista en el repositorio
        List<LineaPedido> listaLineasPedido = lineaPedidoRepository.findAllByPedido(pedidoDTO.getId());
        log.info(PedidoServiceImpl.class.getSimpleName() + " - lista lineas pedido repositorio: " + listaLineasPedido);

        // la pasamos a dto
        List<LineaPedidoDTO> listaLineasPedidoDTO = new ArrayList<LineaPedidoDTO>();

        for (int i = 0; i < listaLineasPedido.size(); ++i) {
            LineaPedidoDTO lpDTO = LineaPedidoDTO.convertToDTO(listaLineasPedido.get(i), pedidoDTO);
            listaLineasPedidoDTO.add(lpDTO);
        }

        return listaLineasPedidoDTO;
    }

    @Override
    public LineaPedidoDTO editarLineaPedido(Long cantidad, Long idLineaPedido, ClienteDTO clienteDTO) {
        log.info("LineaPedidoServiceImpl - editarLineaPedido: " + idLineaPedido + " añadiendo: " + cantidad);
        LineaPedido lineaPedido = lineaPedidoRepository.findById(idLineaPedido).get();
        if (cantidad < 0 && lineaPedido.getCantidad() + cantidad <= 0) {
            // si la cantidad es negativa y la cantidad resultante es 0 o negativa,
            // eliminamos la
            // linea
            lineaPedidoRepository.delete(lineaPedido);
            this.pedidoService.actualizarTotalPedido(lineaPedido.getPedido().getId());
            return null;

        } else {
            lineaPedido.setCantidad(lineaPedido.getCantidad() + cantidad);
            lineaPedidoRepository.save(lineaPedido);
            this.pedidoService.actualizarTotalPedido(lineaPedido.getPedido().getId());

            PedidoDTO pedidoDTO = new PedidoDTO();
            pedidoDTO.setId(lineaPedido.getPedido().getId());
            return LineaPedidoDTO.convertToDTO(lineaPedido,
                    pedidoService.findById(pedidoDTO));
        }

    }

    @Override
    public LineaPedidoDTO borrarLineaPedido(LineaPedidoDTO lineaPedidoDTO, ClienteDTO clienteDTO) {
        log.info("LineaPedidoServiceImpl - borrarLineaPedido: " + lineaPedidoDTO.getId());
        LineaPedido lineaPedido = lineaPedidoRepository.findById(lineaPedidoDTO.getId()).get();
        lineaPedidoRepository.delete(lineaPedido);
        PedidoDTO pedidoDTO = new PedidoDTO();
        pedidoDTO.setId(lineaPedido.getPedido().getId());
        return null;
    }

    @Override
    public LineaPedidoDTO crearLineaPedido(LineaPedidoDTO lineaPedidoDTO, ClienteDTO clienteDTO) {
        log.info("LineaPedidoServiceImpl - crearLineaPedido: " + lineaPedidoDTO);
        PedidoDTO pedidoDTO = PedidoDTO.convertToDTO(
                pedidoRepository.findById(lineaPedidoDTO.getPedido().getId()).get(), clienteDTO);
        lineaPedidoDTO.setPedido(pedidoDTO);
        MercadoDTO mercadoDTO = pedidoDTO.getLineaPedido().get(0).getVenta().getTienda().getMercado();

        Tienda tienda = tiendaRepository.findById(lineaPedidoDTO.getVenta().getTienda().getId()).get();
        lineaPedidoDTO.getVenta().setTienda(TiendaDTO.convertToDTO(tienda, mercadoDTO));
        LineaPedido lineaPedido = LineaPedidoDTO.convertToEntity(lineaPedidoDTO,
                PedidoDTO.convertToEntity(lineaPedidoDTO.getPedido()));

        List<LineaPedido> listaLineasPedido = lineaPedidoRepository.findAllByPedido(lineaPedidoDTO.getPedido().getId());

        for (LineaPedido lp : listaLineasPedido) {
            if (lp.getVenta().getId() == lineaPedido.getVenta().getId()) {
                lp.setCantidad(lp.getCantidad() + lineaPedido.getCantidad());
                lineaPedidoRepository.save(lp);
                return LineaPedidoDTO.convertToDTO(lp, lineaPedidoDTO.getPedido());
            }
        }

        lineaPedidoRepository.save(lineaPedido);
        return lineaPedidoDTO;
    }
}
