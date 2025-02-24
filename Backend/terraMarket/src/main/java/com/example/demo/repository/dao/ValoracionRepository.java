package com.example.demo.repository.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import com.example.demo.repository.entity.Valoracion;

public interface ValoracionRepository extends JpaRepository<Valoracion, Long> {

    @Query(value = "SELECT * FROM valoraciones WHERE idtienda = :codigoTienda", nativeQuery = true)
    List<Valoracion> findByTienda(@Param("codigoTienda") Long idtienda);

}
