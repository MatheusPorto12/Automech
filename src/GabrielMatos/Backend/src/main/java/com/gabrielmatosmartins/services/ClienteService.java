package com.gabrielmatosmartins.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.gabrielmatosmartins.models.Cliente;
import com.gabrielmatosmartins.models.Usuario;
import com.gabrielmatosmartins.repositories.ClienteRepositories;


@Service
public class ClienteService {
    
    @Autowired
    private ClienteRepositories clienteRepository;

    @Autowired 
    private UsuarioService usuarioService;

    public List<Cliente> getAll(){
        List<Cliente> c = this.clienteRepository.findAll();
        return c;
    } 

    @Transactional
    public Cliente create(Cliente c){
        Usuario u = this.usuarioService.findById(c.getUserId());

        c.setId(null);
        c.setUsuario(u);
        c = this.clienteRepository.save(c);
        return c;
    }

    public Cliente findByUserId(Integer id){
        Optional<Cliente> c = this.clienteRepository.findByUsuario_Id(id);
        return c.orElseThrow(() -> new RuntimeException(
            "Cliente não encontrado"
        ));
    }

    public Cliente findByEmail(String email){
        Optional<Cliente> c = this.clienteRepository.findByEmail(email);
        return c.orElseThrow(() -> new RuntimeException(
            "Cliente não encontrado"
        ));
    }

    @Transactional
    public Cliente update(Cliente c){
        Cliente newCliente = findByUserId(c.getUserId());
        newCliente.setSenha(c.getSenha());
        newCliente.setEmail(c.getEmail());
        newCliente.setEndereco(c.getEndereco());
        newCliente.setTelefone(c.getTelefone());

        return this.clienteRepository.save(newCliente);
    }

    public Cliente getCliente(Integer id) {
        return clienteRepository.findById(id).orElse(null);
    }

    public void delete(Integer id){
        Cliente c = findByUserId(id);

        try{
            this.clienteRepository.deleteById(c.getId());
        }catch(Exception e){
            throw new RuntimeException("Não é possível excluir, pois possui entidades relacionadas");
        }
    }
}