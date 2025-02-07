package com.example.demo.repository.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.demo.repository.entity.Rol;

import jakarta.transaction.Transactional;

@Repository
@Transactional
public interface RolRepository extends JpaRepository<Rol, Long> {

    @Query(value ="SELECT * FROM roles WHERE nombre = :nombre", nativeQuery = true)
    Rol findByName(String nombre);

}
