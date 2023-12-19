package com.mathias.tis.repositories;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.mathias.tis.models.Reparo;

public interface ReparoRepository  extends JpaRepository<Reparo, Integer> {
    
    @Modifying
    @Query(value = "UPDATE reparo SET statusReparo = 2, dataReparo = :dataAtual where idReparo in (:id)", nativeQuery = true)
    int endRepair(@Param("id") List<Integer> id, @Param("dataAtual") LocalDate dataAtual);
}
