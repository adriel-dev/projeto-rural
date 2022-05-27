package com.adriel.rural.controllers;

import java.util.List;

import com.adriel.rural.models.Raca;
import com.adriel.rural.services.RacaService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController @RequestMapping(value = "/racas")
public class RacaController {  

    @Autowired
    RacaService racaService;

    @GetMapping
    public List<Raca> findAll(){
        return racaService.findAll();
    }

    @GetMapping(value = "/{id}")
    public Raca findById(@PathVariable Long id){
        return racaService.findById(id);
    }

    @PostMapping
    public Raca save(@RequestBody Raca raca){
        return racaService.save(raca);  
    }

    @PutMapping(value = "/{id}")
    public Raca update(@PathVariable Long id, @RequestBody Raca obj){
        return racaService.update(id, obj);
    }

    @DeleteMapping(value = "/{id}")
    public void delete(@PathVariable Long id){
        racaService.delete(id);
    }

}