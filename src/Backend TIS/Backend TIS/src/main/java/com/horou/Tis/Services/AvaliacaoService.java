package com.horou.Tis.Services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.horou.Tis.Models.Avaliacao;
import com.horou.Tis.Repositories.AvaliacaoRepository;


@Service
public class AvaliacaoService {
    
    @Autowired
    private AvaliacaoRepository avaliacaoRepository;

    public List<Avaliacao> findAll(){
     List<Avaliacao> p= this.avaliacaoRepository.findAll();
     return p;
        
    }
    public Avaliacao findById(Integer id){
      Optional <Avaliacao> p= this.avaliacaoRepository.findById(id);
      return p.orElseThrow(()-> new RuntimeException("Não foi possivel encontrar essa avaliação pelo id"));
    }
    public Avaliacao create(Avaliacao obj){
    obj.setIdavaliacao(null);
    obj=avaliacaoRepository.save(obj);
    return obj;
    }
    public Avaliacao update(Avaliacao obj){
        Avaliacao newObj= this.findById(obj.getIdavaliacao());
        newObj.setIdcliente(obj.getIdcliente());
        newObj.setNotaavaliacao(obj.getNotaavaliacao());
        newObj.setTextoavaliacao(obj.getTextoavaliacao());
        newObj.setOficinas_idoficinas(obj.getOficinas_idoficinas());
        return newObj;
    }


    public Avaliacao createAvaliacao(Avaliacao obj){
      obj.setIdavaliacao(null);
      obj = avaliacaoRepository.save(obj);
      return obj;
  }



    public void delete(Integer id){
     Avaliacao p= findById(id);
     try {
        this.avaliacaoRepository.delete(p);
     } catch (Exception e) {
        throw new RuntimeException("Não é possivel excluir a avaliação pois ela esta relacionado com mais entidades");
     }
    }

    public Double findAverageRating() {
      return avaliacaoRepository.findAverageRating();
  }

  public Double getIndicadores() {
    Double media = this.findAverageRating();
    return media;
}

}
