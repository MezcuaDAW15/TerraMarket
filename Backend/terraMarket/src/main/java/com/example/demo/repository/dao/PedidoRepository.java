package com.example.demo.repository.dao;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.example.demo.repository.entity.Pedido;
import jakarta.transaction.Transactional;

@Repository
@Transactional
public interface PedidoRepository extends JpaRepository<Pedido, Long>{

    @Query(value = "SELECT * FROM pedidos WHERE idcliente = :idCliente", nativeQuery = true)
    public List<Pedido> findAllByCliente(@Param("idCliente") Long id);

}
