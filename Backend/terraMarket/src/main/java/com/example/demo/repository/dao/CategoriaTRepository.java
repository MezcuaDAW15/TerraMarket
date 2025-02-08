package com.example.demo.repository.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.demo.repository.entity.CategoriaT;

import jakarta.transaction.Transactional;

@Repository
@Transactional
public interface CategoriaTRepository extends JpaRepository<CategoriaT, Long> {

    @Query("SELECT c FROM CategoriaT c JOIN c.tiendas t WHERE t.id = :idTienda")
    List<CategoriaT> findAllByTienda(@Param("idTienda") Long idTienda);

}
