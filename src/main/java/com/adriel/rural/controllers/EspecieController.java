package com.adriel.rural.controllers;

import java.util.List;

import com.adriel.rural.models.Especie;
import com.adriel.rural.services.EspecieService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController @RequestMapping(value = "/especies")
public class EspecieController {
    
    @Autowired
    EspecieService especieService;

    @GetMapping
    public List<Especie> findAll(){
        return especieService.findAll();
    }

    @GetMapping(value = "/{id}")
    public Especie findById(@PathVariable Long id){
        return especieService.findById(id);
    }

    @PostMapping
    public Especie save(@RequestBody Especie entity){
        return especieService.save(entity);
    }

    @DeleteMapping(value = "/{id}")
    public void delete(@PathVariable Long id){
        especieService.delete(id);
    }

    @PutMapping(value = "/{id}")
    public Especie update(@PathVariable Long id, @RequestBody Especie obj){
        return especieService.update(id, obj);
    }

}
