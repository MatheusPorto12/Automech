package com.automech.automech.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.automech.automech.models.Orcamento;




@Repository
public interface OrcamentoRepository extends JpaRepository<Orcamento,Integer> {
    @Query(value = "SELECT orcamento.* FROM orcamento INNER JOIN veiculo ON orcamento.veiculo_idveiculo = veiculo.idVeiculo INNER JOIN cliente ON veiculo.cliente_usuario_idUsuario = cliente.usuario_idUsuario WHERE cliente.usuario_idUsuario = :clienteid", nativeQuery = true)
    List<Orcamento> findOrcamentosByCliente(@Param("clienteid") Integer clienteid); 

    @Query(value = "SELECT o FROM Orcamento o WHERE o.statusorcamento = 2")
    List<Orcamento> findByorcamentosAprovados();

    
}
