package com.horou.Tis.Services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.horou.Tis.Models.Cliente;
import com.horou.Tis.Models.Veiculo;
import com.horou.Tis.Repositories.VeiculoRepository;


@Service
public class VeiculoService {
    
    @Autowired
    private VeiculoRepository veiculoRepository;

    @Autowired ClienteService clienteService;

    public Veiculo findById(Integer id){
        Optional<Veiculo> v = this.veiculoRepository.findById(id);
        return v.orElseThrow(() -> new RuntimeException(
            "Veiculo não encontrado"
        ));
    }

    public List<Veiculo> getAll(){
        List<Veiculo> v = this.veiculoRepository.findAll();
        return v;
    }

    public List<Veiculo> getByClientId(Integer id){
        Optional<List<Veiculo>> v = this.veiculoRepository.findByCliente_Usuario_id(id);
        return v.orElseThrow(() -> new RuntimeException(
            "Este cliente não possui nenhum veiculo"
        ));
    }

    @Transactional
    public Veiculo create(Veiculo v){
        Cliente c = this.clienteService.findByUserId(v.getCliente().getUserId());
        v.setId(null);
        v.setCliente(c);

        v = this.veiculoRepository.save(v);
        return v;
    }

    @Transactional
    public Veiculo update(Veiculo v){
        Veiculo newVeiculo = findById(v.getId());
        newVeiculo.setMarca(v.getMarca());
        newVeiculo.setModelo(v.getModelo());
        newVeiculo.setPlaca(v.getPlaca());
        
        return this.veiculoRepository.save(newVeiculo);
    }

    public void delete(Integer id){
        Veiculo v = findById(id);
        try{
            this.veiculoRepository.deleteById(v.getId());
        }catch(Exception e){
            throw new RuntimeException("Não é possível excluir, pois possui entidades relacionadas");
        }
    }

}
