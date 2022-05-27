package com.adriel.rural.services;

import java.util.List;

import com.adriel.rural.models.Especie;
import com.adriel.rural.repositories.EspecieRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EspecieService {

    @Autowired
    EspecieRepository especieRepository;

    public List<Especie> findAll(){
        return especieRepository.findAll();
    }

    public Especie findById(Long id){
        return especieRepository.findById(id).get();
    }

    public Especie save(Especie entity){
        return especieRepository.save(entity);
    }

    public void delete(Long id){
        especieRepository.deleteById(id);
    }

    public Especie update(Long id, Especie obj){
        Especie entity = especieRepository.getById(id);
        updateData(entity, obj);
        return especieRepository.save(entity); 
    }

    private void updateData(Especie entity, Especie obj) {
        entity.setNome(obj.getNome());
    }

}
