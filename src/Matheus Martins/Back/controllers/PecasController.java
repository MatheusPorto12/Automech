package com.automech.automech.controllers;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;


import com.automech.automech.models.Pecas;
import com.automech.automech.services.PeccasServices;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;



@RestController
@RequestMapping("/Pecas")
@Validated
public class PecasController {
    @Autowired
    PeccasServices peccasServices;

    @GetMapping("/todos")
    public ResponseEntity<List<Pecas>> findAll(){
    List<Pecas>p= this.peccasServices.findAll();
    return ResponseEntity.ok().body(p);

    }
    
  
    @GetMapping("/{id}")
    public ResponseEntity<Pecas> findById(@PathVariable Integer id){
        Pecas o = this.peccasServices.findById(id);
        return ResponseEntity.ok().body(o);

    }
    @PostMapping
    public ResponseEntity<Pecas> create(@RequestBody Pecas obj){
    obj=this.peccasServices.create(obj);
    URI uri=ServletUriComponentsBuilder.fromCurrentRequest().
    path("/{id}").buildAndExpand(obj.getIdpeca()).toUri();
    return ResponseEntity.created(uri).body(obj);
    }

   @PutMapping("/{id}")
   public ResponseEntity<Void> update(@RequestBody Pecas obj,@PathVariable Integer id){
    obj.setIdpeca(id);
    this.peccasServices.update(obj);
    return ResponseEntity.noContent().build();
   }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id){
        this.peccasServices.delete(id);
        return ResponseEntity.noContent().build();

    
   }
}




