package com.gabrielmatosmartins.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gabrielmatosmartins.models.Usuario;

@Repository
public interface UsuarioRepositories extends JpaRepository<Usuario, Integer> {
    
}