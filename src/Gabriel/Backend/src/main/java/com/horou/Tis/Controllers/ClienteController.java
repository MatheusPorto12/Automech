package com.horou.Tis.Controllers;

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

import com.horou.Tis.Models.Cliente;
import com.horou.Tis.Models.Usuario;
import com.horou.Tis.Models.Veiculo;
import com.horou.Tis.Services.ClienteService;
import com.horou.Tis.Services.UsuarioService;

@RestController
@RequestMapping("/Cliente")
public class ClienteController {

    @Autowired
    private ClienteService clienteService;

    @Autowired
    private UsuarioService usuarioService;

    @GetMapping()
    public ResponseEntity<List<Cliente>> findAll(){
        List<Cliente> c = this.clienteService.getAll();
        return ResponseEntity.ok().body(c);
    }

    @GetMapping("/{id}/Veiculo")
    public ResponseEntity<List<Veiculo>> findAllByCliente(@PathVariable Integer id){
        Cliente c = this.clienteService.findByUserId(id);
        List<Veiculo> v = c.getVeiculos();
        return ResponseEntity.ok().body(v);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Cliente> findByUserId(@PathVariable Integer id){
        Cliente c = this.clienteService.findByUserId(id);
        return ResponseEntity.ok().body(c);
    }

    @PostMapping("/{id}")
    public ResponseEntity<Void> create(@RequestBody Cliente c, 
                                       @PathVariable Integer id){
        Usuario u = this.usuarioService.findById(id);
        c.setUsuario(u);
        this.clienteService.create(c);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}").buildAndExpand(c.getId()).toUri();

        return ResponseEntity.created(uri).build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> update(@RequestBody Cliente c, @PathVariable Integer id){
        Usuario u = this.usuarioService.findById(id);
        c.setUsuario(u);
        c.setId(id);
        this.clienteService.update(c);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id){
        this.clienteService.delete(id);
        return ResponseEntity.noContent().build();
    }


}
