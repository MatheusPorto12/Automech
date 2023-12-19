package com.gabrielmatosmartins.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gabrielmatosmartins.models.Cliente;
import com.gabrielmatosmartins.models.Servicos;
import com.gabrielmatosmartins.repositories.ClienteRepositories;
import com.gabrielmatosmartins.repositories.ServicoRepositorie;

import jakarta.transaction.Transactional;

@Service
public class ServicosServices {

@Autowired
private ClienteRepositories clienteRepository;

@Autowired
private ServicoRepositorie servicoRepositorie;

public List<Servicos> getAll(){
    return servicoRepositorie.findAll();
}
public Servicos findByid(Integer id){
 Optional<Servicos> servicos= this.servicoRepositorie.findById(id);
 return servicos.orElseThrow(()-> new RuntimeException("Não foi possivel encontrar este servico de id= "+id));
}
@Transactional
public Servicos create(Servicos obj){
obj.setId(null);
this.servicoRepositorie.save(obj);
return obj;
}


@Transactional
public Servicos update(Servicos obj){
    Servicos newObj=this.findByid(obj.getId());
    newObj.setAtualizacao(obj.getAtualizacao());
    newObj.setDescricao(obj.getDescricao());
    newObj.setObs(obj.getObs());
    newObj.setPrazoServico(obj.getPrazoServico());
    newObj.setValor(obj.getValor());
    return this.servicoRepositorie.save(obj);

}
@Transactional
public void delete(Servicos obj){
findByid(obj.getId());
try{
this.servicoRepositorie.delete(obj);
}catch(Exception e){
throw new RuntimeException("Não foi possivel deletar entidades relacionadas");
}
}
}