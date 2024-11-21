package com.proyecto.proyecto.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.proyecto.proyecto.model.Estado;

@Repository
public interface EstadoRepository extends JpaRepository<Estado, Long>{
}
