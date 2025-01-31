package com.example.demo.repository.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.demo.repository.entity.Producto;
import com.example.demo.repository.entity.Venta;

import jakarta.transaction.Transactional;

@Transactional
@Repository
public interface VentaRepository extends JpaRepository<Venta, Long> {

    @Query("SELECT v FROM Venta v WHERE v.producto = :producto")
    List<Venta> findAllByProducto(@Param("producto") Producto producto);
}
