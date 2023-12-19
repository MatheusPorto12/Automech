package com.horou.Tis.Services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.horou.Tis.Models.Pecas;
import com.horou.Tis.Repositories.PecasRepository;

@Service
public class PeccasServices {
    @Autowired
    private PecasRepository pecasRepository;

    public List<Pecas> findAll(){
     List<Pecas> p= this.pecasRepository.findAll();
     return p;
        
    }
    public Pecas findById(Integer id){
      Optional <Pecas> p= this.pecasRepository.findById(id);
      return p.orElseThrow(()-> new RuntimeException("Não foi possivel encontrar essa peça pelo id"));
    }
    public Pecas create(Pecas obj){
    obj.setIdpeca(null);
    obj=pecasRepository.save(obj);
    return obj;
    }
    public Pecas update(Pecas obj){
        Pecas newObj= this.findById(obj.getIdpeca());
        newObj.setDescricaopeca(obj.getDescricaopeca());
        newObj.setTipopeca(obj.getTipopeca());
        newObj.setValorpeca(obj.getValorpeca());
        newObj.setQuantidadepecas(obj.getQuantidadepecas());
        return newObj;

    }
    public void delete(Integer id){
     Pecas p= findById(id);
     try {
        this.pecasRepository.delete(p);
     } catch (Exception e) {
        throw new RuntimeException("Não é possivel excluir pois o orcamento esta relacionado com mais entidades");
     }
    }
}
