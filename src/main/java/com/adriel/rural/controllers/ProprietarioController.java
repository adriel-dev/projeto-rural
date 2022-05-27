package com.adriel.rural.controllers;

import java.util.List;

import com.adriel.rural.models.Proprietario;
import com.adriel.rural.services.ProprietarioService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController @RequestMapping(value = "/proprietarios")
public class ProprietarioController {
    
    @Autowired
    ProprietarioService proprietarioService;

    @GetMapping
    public List<Proprietario> findAll() {
        return proprietarioService.findAll();
    }

    @GetMapping(value = "/{id}")
    public Proprietario findById(@PathVariable Long id){
        return proprietarioService.findById(id);
    }

    @PostMapping
    public Proprietario save(@RequestBody Proprietario obj){
        return proprietarioService.save(obj);
    }

    @PutMapping(value = "/{id}")
    public Proprietario update(@PathVariable Long id, @RequestBody Proprietario obj){
        return proprietarioService.update(id, obj);
    }

    @DeleteMapping(value = "/{id}")
    public void deleteById(@PathVariable Long id){
        proprietarioService.deleteById(id);
    }

}