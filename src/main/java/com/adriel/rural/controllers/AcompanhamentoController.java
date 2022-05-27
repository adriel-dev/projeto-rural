package com.adriel.rural.controllers;

import java.util.List;

import com.adriel.rural.models.Acompanhamento;
import com.adriel.rural.services.AcompanhamentoService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController @RequestMapping(value = "/acompanhamentos")
public class AcompanhamentoController {

    @Autowired
    AcompanhamentoService acompanhamentoService;

    @GetMapping
    public List<Acompanhamento> findAll(){
        return acompanhamentoService.findAll();
    }

    @GetMapping(value = "/{id}")
    public Acompanhamento findById(@PathVariable Long id){
        return acompanhamentoService.findById(id);
    }

    @PostMapping
    public Acompanhamento save(@RequestBody Acompanhamento obj){
        return acompanhamentoService.save(obj);
    }

    @DeleteMapping(value = "/{id}")
    public void deleteById(@PathVariable Long id){
        acompanhamentoService.deleteById(id);
    }

    @PutMapping(value = "/{id}")
    public Acompanhamento update(@PathVariable Long id, @RequestBody Acompanhamento obj){
        return acompanhamentoService.update(id, obj);
    }
    
}
