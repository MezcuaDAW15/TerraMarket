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

    @Query(value = "SELECT v FROM Venta v JOIN v.producto p JOIN v.tienda t WHERE v.activo=true AND t.mercado.id= :idMercado AND p.categoriaP.id= :idCategoria AND v.precioVenta=(SELECT MIN(v2.precioVenta) FROM Venta v2 JOIN v2.tienda t2 WHERE v2.producto.id = v.producto.id AND v2.activo = true AND t2.mercado.id = t.mercado.id)")

    List<Venta> findCheeperByCategoriasMercado(@Param("idCategoria") Long idCategoria,
            @Param("idMercado") Long idMercado);

    @Query(value = "SELECT v FROM Venta v JOIN v.producto p JOIN v.tienda t WHERE v.activo=true AND t.mercado.id= :idMercado AND p.id= :idProducto")
    List<Venta> findAllByProductoMercado(Long idProducto, Long idMercado);

}
