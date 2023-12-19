package com.mathias.tis.services;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mathias.tis.models.Reparo;
import com.mathias.tis.repositories.ReparoRepository;

import jakarta.transaction.Transactional;

@Service
public class ReparoService {
    
    @Autowired
    private ReparoRepository reparoRepository;

    public Reparo findById(Integer id){
        Optional<Reparo> reparo = this.reparoRepository.findById(id);
        return reparo.orElseThrow(() -> new RuntimeException("Reparo não encontrado - id: "+id+", Tipo: " + Reparo.class.getName()));
    }

    @Transactional
    public int endRepair(List<Integer> id){
        LocalDate dataAtual = LocalDate.now();
        for(Integer i : id){
            Reparo reparo = findById(i);
            reparo.setStatusreparo(2);
            reparo.setDatareparo(dataAtual);
        }
        return this.reparoRepository.endRepair(id, dataAtual);

    }

}
