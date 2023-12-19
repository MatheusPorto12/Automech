package com.mathias.tis.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.mathias.tis.models.Reparo;
import com.mathias.tis.services.ReparoService;

@RestController
@RequestMapping("/Reparo")
@Validated
public class ReparoController {
    
    @Autowired
    private ReparoService reparoService;

    @GetMapping("/Detalhes/{id}")
    public ResponseEntity<Reparo> findById(@PathVariable Integer id){
        Reparo objModel = this.reparoService.findById(id);
        return ResponseEntity.ok().body(objModel);
    }

    @PostMapping("/FinalizarReparo")
    public boolean endRepair(@RequestParam List<Integer> idReparo){
        int updateSuccess = this.reparoService.endRepair(idReparo);
        return updateSuccess > 0;
    }

}
