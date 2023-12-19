package com.gabrielmatosmartins.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.gabrielmatosmartins.models.Cliente;

@Repository
public interface ClienteRepositories extends JpaRepository<Cliente, Integer> {

    Optional<Cliente> findByUsuario_Id(Integer id);

    @Query(value = "SELECT * FROM cliente where emailcliente = :emailcliente", nativeQuery = true)
    Optional<Cliente> findByEmail(@Param("emailcliente") String email);
}
    
