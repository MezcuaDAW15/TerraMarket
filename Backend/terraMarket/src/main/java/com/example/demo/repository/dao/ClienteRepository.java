package com.example.demo.repository.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.demo.repository.entity.Cliente;

import jakarta.transaction.Transactional;

@Repository
@Transactional
public interface ClienteRepository extends JpaRepository<Cliente, Long>{
	
	//@Query(value = "SELECT * FROM clientes WHERE username = :username", nativeQuery = true)
	//Cliente findByUsername(String username);
	
	@Query(value = "SELECT * FROM clientes WHERE username = :username", nativeQuery = true)
	Cliente findByUsername(@Param("username") String username);
	
}