package com.adriel.rural.services;

import java.util.List;

import com.adriel.rural.models.Animal;
import com.adriel.rural.repositories.AnimalRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AnimalService {
 
    @Autowired
    private AnimalRepository animalRepository;

    public List<Animal> findAll(){
        return animalRepository.findAll();
    }

    public Animal findById(Long id){
        return animalRepository.findById(id).get();
    }

    public Animal save(Animal animal){
        return animalRepository.save(animal);
    }

    public void delete(Long id){
        animalRepository.deleteById(id);
    }

    public Animal update(Long id, Animal obj){
        Animal entity = animalRepository.getById(id);
        updateData(entity, obj);
        return animalRepository.save(entity);
    }

    private void updateData(Animal entity, Animal obj) {
        entity.setNome(obj.getNome());
        entity.setSexo(obj.getSexo());
        entity.setDataAquisicao(obj.getDataAquisicao());
        entity.setDataVenda(obj.getDataVenda());
        entity.setValorAquisicao(obj.getValorAquisicao());
        entity.setValorVenda(obj.getValorVenda());
        entity.setImgAnimalUrl(obj.getImgAnimalUrl());        
    }

}