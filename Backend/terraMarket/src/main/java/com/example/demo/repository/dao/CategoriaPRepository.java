package com.example.demo.repository.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.demo.repository.entity.CategoriaP;

import jakarta.transaction.Transactional;

@Repository
@Transactional
public interface CategoriaPRepository extends JpaRepository<CategoriaP, Long> {

    @Query("SELECT c FROM CategoriaP c WHERE c.categoriaT.id = ?1")
    List<CategoriaP> findByIdCategoriaT(Long id);

}
