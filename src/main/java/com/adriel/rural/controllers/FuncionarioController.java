package com.adriel.rural.controllers;

import java.util.List;

import com.adriel.rural.models.Funcionario;
import com.adriel.rural.services.FuncionarioService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PutMapping;


@RestController @RequestMapping(value = "/funcionarios")
public class FuncionarioController {
    
    @Autowired
    FuncionarioService funcionarioService;

    @GetMapping
    public List<Funcionario> findAll(){
        return funcionarioService.findAll();
    }

    @GetMapping(value = "/{id}")
    public Funcionario findById(@PathVariable Long id){
        return funcionarioService.findById(id);
    }

    @PostMapping
    public Funcionario save(@RequestBody Funcionario obj){
        return funcionarioService.save(obj);
    }

    @DeleteMapping(value = "/{id}")
    public void deleteById(@PathVariable Long id){
        funcionarioService.deleteById(id);
    }

    @PutMapping(value="/{id}")
    public Funcionario update(@PathVariable Long id, @RequestBody Funcionario obj) {
        return funcionarioService.update(id, obj);
    }

}
