package com.adriel.rural.controllers;

import java.util.List;

import com.adriel.rural.models.Fazenda;
import com.adriel.rural.services.FazendaService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



@RestController @RequestMapping(value = "/fazendas")
public class FazendaController {

    @Autowired
    FazendaService fazendaService;

    @GetMapping
    public List<Fazenda> findAll(){
        return fazendaService.findAll();
    }

    @GetMapping(value="/{id}")
    public Fazenda findById(@PathVariable Long id) {
        return fazendaService.findById(id);
    }

    @PostMapping
    public Fazenda save(@RequestBody Fazenda obj) {
        return fazendaService.save(obj);
    }

    @DeleteMapping(value = "/{id}")
    public void deleteById(@PathVariable Long id){
        fazendaService.deleteById(id);
    }
    
    @PutMapping(value = "/{id}")
    public Fazenda update(@PathVariable Long id, @RequestBody Fazenda obj){
        return fazendaService.update(id, obj);
    }

}
