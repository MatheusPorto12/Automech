package com.gabrielmatosmartins.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gabrielmatosmartins.models.Servicos;

@Repository
public interface ServicoRepositorie extends JpaRepository<Servicos, Integer>{
    
}