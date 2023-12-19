package com.horou.Tis.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.horou.Tis.Models.Avaliacao;
import java.util.List;

import com.horou.Tis.Services.AvaliacaoService;

@RestController
@RequestMapping("/Avaliacao")
@Validated
public class AvaliacaoController {

     @Autowired
    AvaliacaoService avaliacaoService;
    @GetMapping("/todos")
    public ResponseEntity<List<Avaliacao>> findAll(){
    List<Avaliacao>p= this.avaliacaoService.findAll();
    return ResponseEntity.ok().body(p);
}

@PostMapping("/todos")
    public ResponseEntity<Avaliacao> createAvaliacao(@RequestBody Avaliacao avaliacao) {
        Avaliacao createdAvaliacao = this.avaliacaoService.createAvaliacao(avaliacao);
        return ResponseEntity.ok().body(createdAvaliacao);
    }
    
    
    @GetMapping("/indicadores")
    public String getIndicadores() {
        Double avaliacaoMedia = this.avaliacaoService.getIndicadores();
        return "{\"valor\":" + avaliacaoMedia +"}";
    }

    
}
