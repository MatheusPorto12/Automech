package com.automech.automech.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.automech.automech.models.Servicos;
import com.automech.automech.repositories.ServicosRepository;

import jakarta.transaction.Transactional;

@Service
public class ServicoServices {

    @Autowired
    private ServicosRepository servicosRepository;

    public List<Servicos> findAll(){
        List <Servicos> s=this.servicosRepository.findAll();
        return s;
    }

    public Servicos findById(Integer id){
    Optional<Servicos> s =this.servicosRepository.findById(id);
    return s.orElseThrow(()-> new RuntimeException("Serviço nao encontrado"));
    }

    @Transactional
    public Servicos create(Servicos obj ){
        obj.setId(null);
        obj=this.servicosRepository.save(obj);
        return obj;
    }

    @Transactional
    public Servicos update(Servicos Obj){
       Servicos newObj= findById(Obj.getId());
       newObj.setObsServico(Obj.getObsServico());
       newObj.setPrazoServico(Obj.getPrazoServico());
       newObj.setDataServico(Obj.getDataServico());
       newObj.setValorServico(Obj.getValorServico());
       newObj.setDescricaoServico(Obj.getDescricaoServico());
       return this.servicosRepository.save(newObj);
       
    }
    public void delete(Integer id){
        Servicos s=findById(id);
        try {
            this.servicosRepository.delete(s);
        } catch (Exception e) {
            throw new RuntimeException("Não sera possivel excluir pois possui serviços ou entidades relacionadas.");
        }
    }



    }
    

