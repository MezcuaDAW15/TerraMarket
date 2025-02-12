package com.example.demo.repository.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

import com.example.demo.repository.entity.CategoriaP;
import com.example.demo.repository.entity.Producto;
import com.example.demo.model.dto.ProductoDTO;

import jakarta.transaction.Transactional;

@Repository
@Transactional
public interface ProductoRepository extends JpaRepository<Producto, Long> {

    @Query("SELECT p FROM Producto p WHERE p.categoriaP = :categorias")
    List<Producto> findByCategory(@Param("categorias") CategoriaP categoriaP);

}
