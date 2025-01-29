package com.example.demo.repository.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.demo.repository.entity.CategoriaT;

import jakarta.transaction.Transactional;

@Repository
@Transactional
public interface CategoriaTRepository extends JpaRepository<CategoriaT, Long> {

    @Query("SELECT c FROM CategoriaT c")
    List<Optional<CategoriaT>> findAllWithCategoriasP();
}
