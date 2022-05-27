package com.adriel.rural.controllers;

import java.util.List;

import com.adriel.rural.models.Animal;
import com.adriel.rural.services.AnimalService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController @RequestMapping(value = "/animais")
public class AnimalController {
    
    @Autowired
    AnimalService animalService;

    @GetMapping
    public List<Animal> findAll(){
        return animalService.findAll();
    }

    @GetMapping(value = "/{id}")
    public Animal findById(@PathVariable Long id){
        return animalService.findById(id);
    }

    @PostMapping
    public Animal save(@RequestBody Animal animal){
        return animalService.save(animal);
    }

    @DeleteMapping(value = "/{id}")
    public void delete(@PathVariable Long id){
        animalService.delete(id);
    }

    @PutMapping(value = "/{id}")
    public Animal update(@PathVariable Long id, @RequestBody Animal obj){
        return animalService.update(id, obj);
    }

}
