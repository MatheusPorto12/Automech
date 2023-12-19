package com.automech.automech.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.automech.automech.models.Orcamento;
import com.automech.automech.models.Veiculo;
import com.automech.automech.repositories.OrcamentoRepository;
import com.automech.automech.repositories.VeiculoRepository;

import jakarta.transaction.Transactional;

@Service
public class OrcamentoServices {
    @Autowired
    private OrcamentoRepository orcamentoRepository;

    @Autowired
    private VeiculoRepository veiculoRepository;

    public List<Orcamento> findAll(){
        List<Orcamento> o= this.orcamentoRepository.findAll();
        return o;
    }
    
    public Orcamento findById(Integer id){
        Optional<Orcamento> o = this.orcamentoRepository.findById(id);
        return o.orElseThrow(()-> new RuntimeException("Não foi possivel encontrar o usuario por este ID"));
    }
    public List<Orcamento> findOrcamentosByCliente(Integer clienteid) {
        return orcamentoRepository.findOrcamentosByCliente(clienteid);
    }
    
    @Transactional
    public List<Orcamento> findOrcamentoAprovados(){
        List<Orcamento> o=this.orcamentoRepository.findByorcamentosAprovados();
        return o;
    }
    @Transactional
    public Orcamento create(Orcamento obj){
        Veiculo v= this.veiculoRepository.findById(obj.getVeiculo().getId())
        .orElseThrow(()-> new RuntimeException("Veiculo nao encontrado"));
        obj.setVeiculo(v);
        obj.setIdorcamento(obj.getIdorcamento());
        obj=this.orcamentoRepository.save(obj);
        return obj;
    }

    @Transactional
    public Orcamento update(Orcamento obj){
        Orcamento newObj=findById(obj.getIdorcamento());
        newObj.setProbelmasorcamento(obj.getProbelmasorcamento());
        newObj.setStatusorcamento(obj.getStatusorcamento());
        newObj.setValororcamento(obj.getValororcamento());
        return this.orcamentoRepository.save(newObj);
    }
    
    public void delete(Integer id){
     Orcamento o= findById(id);
     try {
        this.orcamentoRepository.delete(o);
     } catch (Exception e) {
        throw new RuntimeException("Não é possivel excluir pois o orcamento esta relacionado com mais entidades");
     }
    }

}
