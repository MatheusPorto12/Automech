package com.horou.Tis.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.horou.Tis.Models.Pecas;

@Repository
public interface PecasRepository extends JpaRepository<Pecas,Integer> {

    
}
