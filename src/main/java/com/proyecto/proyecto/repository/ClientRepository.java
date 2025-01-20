package com.proyecto.proyecto.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.proyecto.proyecto.model.Client;

@Repository
public interface ClientRepository extends JpaRepository<Client, Long>{
    
}
