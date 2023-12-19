package com.gabrielmatosmartins.controllers;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.gabrielmatosmartins.models.Avaliacao;
import com.gabrielmatosmartins.services.AvaliacaoService;

@RestController
@RequestMapping("/avaliacao")
public class AvaliacaoController {
    
    @Autowired
    private AvaliacaoService avaliacaoService;

    @GetMapping("/{id}")
    public ResponseEntity<Avaliacao> findById(@PathVariable Integer id){
        Avaliacao a = this.avaliacaoService.findById(id)
            .orElseThrow(() -> new RuntimeException("Nao foi possivel encontrar esta avaliacao do cliente id= "+id));
        return ResponseEntity.ok().body(a);
    }

    @PostMapping
    public ResponseEntity<Void> create(@RequestBody Avaliacao a){
        Avaliacao savedAvaliacao = this.avaliacaoService.save(a);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}").buildAndExpand(savedAvaliacao.getIdAvaliacao()).toUri();

        return ResponseEntity.created(uri).build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> update(@RequestBody Avaliacao a, @PathVariable Integer id){
        a.setIdAvaliacao(id);
        this.avaliacaoService.update(a);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id){
        this.avaliacaoService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}