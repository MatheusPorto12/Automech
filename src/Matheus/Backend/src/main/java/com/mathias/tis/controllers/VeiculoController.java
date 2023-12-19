package com.mathias.tis.controllers;

import java.net.URI;
import java.util.List;

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

import com.mathias.tis.models.Cliente;
import com.mathias.tis.models.Veiculo;
import com.mathias.tis.services.ClienteService;
import com.mathias.tis.services.VeiculoService;

@RestController
@RequestMapping("/Veiculo")
public class VeiculoController {
    
    @Autowired
    private VeiculoService veiculoService;

    @Autowired
    private ClienteService clienteService;

    @GetMapping
    public ResponseEntity<List<Veiculo>> findAll(){
        List<Veiculo> v = this.veiculoService.getByStatus(0);
        return ResponseEntity.ok().body(v);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Veiculo> findById(@PathVariable Integer id){
        Veiculo v = this.veiculoService.findById(id);
        return ResponseEntity.ok().body(v);
    }

    @PostMapping("/{id}")
    public ResponseEntity<Void> create(@RequestBody Veiculo v, 
                                       @PathVariable Integer id){
        Cliente c = this.clienteService.findByUserId(id);
        v.setCliente(c);
        this.veiculoService.create(v);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}").buildAndExpand(c.getUserId()).toUri();

        return ResponseEntity.created(uri).build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> update(@RequestBody Veiculo v, @PathVariable Integer id){
        v.setId(id);
        this.veiculoService.update(v);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Veiculo> delete(@PathVariable Integer id){
        Veiculo v = this.veiculoService.delete(id);
        return ResponseEntity.ok().body(v);
    }
}
