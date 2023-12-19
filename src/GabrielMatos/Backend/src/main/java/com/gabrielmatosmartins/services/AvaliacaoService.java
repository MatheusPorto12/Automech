package com.gabrielmatosmartins.services;

import com.gabrielmatosmartins.models.Avaliacao;
import com.gabrielmatosmartins.repositories.AvaliacaoRepositories;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class AvaliacaoService {

    private final AvaliacaoRepositories avaliacaoRepository;

    @Autowired
    public AvaliacaoService(AvaliacaoRepositories avaliacaoRepository) {
        this.avaliacaoRepository = avaliacaoRepository;
    }


     public List<Avaliacao> findByIdCliente(Integer idCliente) {
        List<Avaliacao> avaliacoes = avaliacaoRepository.findByIdCliente(idCliente);
        if (avaliacoes.isEmpty()) {
            throw new RuntimeException("Nao foi possivel encontrar esta avaliacao do cliente id= "+idCliente);
        }
        return avaliacoes;
    }

    public List<Avaliacao> findByIdOficina(Integer idOficina) {
        List<Avaliacao> avaliacoes = avaliacaoRepository.findByIdOficina(idOficina);
        if (avaliacoes.isEmpty()) {
            throw new RuntimeException("Nao foi possivel encontrar esta avaliacao do cliente id= "+idOficina);
        }
        return avaliacoes;
    }
    
    public Avaliacao save(Avaliacao avaliacao) {
        return avaliacaoRepository.save(avaliacao);
    }

    public List<Avaliacao> findAll() {
        return avaliacaoRepository.findAll();
    }

    public Optional<Avaliacao> findById(Integer id) {
        return avaliacaoRepository.findById(id);
    }

    public Avaliacao update(Avaliacao avaliacao) {
        return avaliacaoRepository.save(avaliacao);
    }

    public void deleteById(Integer id) {
        avaliacaoRepository.deleteById(id);
    }

    
}