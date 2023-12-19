package com.gabrielmatosmartins.repositories;

import com.gabrielmatosmartins.models.Avaliacao;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AvaliacaoRepositories extends JpaRepository<Avaliacao, Integer> {

    List<Avaliacao> findByIdCliente(Integer idCliente);
    List<Avaliacao> findByIdOficina(Integer idOficina);

}