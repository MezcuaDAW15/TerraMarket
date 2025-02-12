package com.example.demo.repository.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.demo.repository.entity.Tienda;

import jakarta.transaction.Transactional;

@Repository
@Transactional
public interface TiendaRepository extends JpaRepository<Tienda, Long> {

    @Query(value = "SELECT * FROM tiendas WHERE idmercado = :codigoMercado", nativeQuery = true)
    List<Tienda> findAllByMercado(@Param("codigoMercado") Long idMercado);

    @Query("SELECT t FROM Tienda t JOIN t.categorias c WHERE c.id = :categoriaId AND t.mercado.id = :mercadoId")
    List<Tienda> findAllByCategoriasMercado(@Param("categoriaId") Long categoriaId, @Param("mercadoId") Long mercadoId);
}
