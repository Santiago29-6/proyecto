package com.proyecto.proyecto.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.*;
import org.springframework.data.repository.query.Param;

import com.proyecto.proyecto.model.Role;
import com.proyecto.proyecto.model.User;

import jakarta.transaction.Transactional;

public interface UserRepository extends JpaRepository<User,Long>{

    Optional<User> findByUsername(String username);

    @Modifying
    @Transactional
    @Query("UPDATE User SET role=:role WHERE username=:username")
    void updateUserRole(@Param("username") String username, @Param("role") Role role);

}