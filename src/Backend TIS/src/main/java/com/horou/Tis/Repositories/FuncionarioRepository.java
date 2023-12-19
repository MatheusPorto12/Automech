package com.horou.Tis.Repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.horou.Tis.Models.Funcionario;

@Repository
public interface FuncionarioRepository extends JpaRepository<Funcionario, Integer> {
    
    Optional<Funcionario> findByUsuario_Id(Integer id);

    @Query(value = "SELECT * FROM funcionario where emailfuncionario = :emailfuncionario", nativeQuery = true)
    Optional<Funcionario> findByEmail(@Param("emailfuncionario") String email);

}
