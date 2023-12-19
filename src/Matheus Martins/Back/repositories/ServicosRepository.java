package com.automech.automech.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.automech.automech.models.Servicos;

@Repository
public interface ServicosRepository extends JpaRepository<Servicos,Integer> {
    
}
