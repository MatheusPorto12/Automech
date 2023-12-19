package com.horou.Tis.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.horou.Tis.Models.Avaliacao;;

@Repository
public interface AvaliacaoRepository extends JpaRepository<Avaliacao,Integer>{

    @Query("SELECT AVG(a.notaavaliacao) FROM Avaliacao a")
    Double findAverageRating();
}
