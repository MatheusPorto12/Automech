package com.gabrielmatosmartins.controllers;

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

import com.gabrielmatosmartins.models.Cliente;
import com.gabrielmatosmartins.models.Servicos;
import com.gabrielmatosmartins.services.EmailService;
import com.gabrielmatosmartins.services.ServicosServices;

import jakarta.mail.MessagingException;



@RestController
@RequestMapping("/Servico")
public class ServicosController {
    @Autowired
    private ServicosServices servicosServices;
    private EmailService emailService;

    @GetMapping("/Servicos")    
    public ResponseEntity <List<Servicos>> getAll(){
        List<Servicos> servicosList=this.servicosServices.getAll();
        return ResponseEntity.ok().body(servicosList);
    }
    @GetMapping("/{id}")
    public ResponseEntity<Servicos> findById(@PathVariable Integer id){
    Servicos obj=this.servicosServices.findByid(id);
    return ResponseEntity.ok().body(obj);
    }

    @PostMapping
    public ResponseEntity<Void> create(@RequestBody Servicos obj){
        this.servicosServices.create(obj);
        URI uri=ServletUriComponentsBuilder.fromCurrentRequest()
        .path("/{id}").buildAndExpand(obj.getId()).toUri();
        return ResponseEntity.created(uri).build();     
    }
      @PutMapping("/{id}")
    public ResponseEntity<Void> update(@RequestBody Servicos obj, @PathVariable Integer id) throws MessagingException{
    obj.setId(id);
    this.servicosServices.update(obj);

    Cliente cliente = (Cliente) obj.getCliente();
    String subject = "Atualização do status do serviço";
    String email = cliente.getEmail(); 
    String content = "O status do seu serviço foi atualizado para: " + obj.getstatusServico(); 
    
    
    try {
        emailService.sendEmailToClient(subject, email, content);
    } catch (MessagingException e) {
        throw new MessagingException("Ocorreu um erro ao enviar o e-mail para o cliente.", e);
    }

    return ResponseEntity.noContent().build();   
}
 @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id){
     Servicos obj= this.servicosServices.findByid(id);
     servicosServices.delete(obj);
     return ResponseEntity.noContent().build();
    }
}

    
