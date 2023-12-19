package com.automech.automech.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.automech.automech.models.Pecas;

@Repository
public interface PecasRepository extends JpaRepository<Pecas,Integer> {

    
}
