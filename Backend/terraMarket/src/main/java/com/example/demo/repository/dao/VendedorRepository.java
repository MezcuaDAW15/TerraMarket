package com.example.demo.repository.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.repository.entity.Vendedor;

import jakarta.transaction.Transactional;

@Repository
@Transactional
public interface VendedorRepository extends JpaRepository<Vendedor, Long> {

}
