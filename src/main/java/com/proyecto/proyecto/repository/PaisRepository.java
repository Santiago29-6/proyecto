package com.proyecto.proyecto.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.proyecto.proyecto.model.Pais;

@Repository
public interface PaisRepository extends JpaRepository<Pais, Long>{

}
