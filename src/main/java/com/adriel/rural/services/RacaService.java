package com.adriel.rural.services;

import java.util.List;

import com.adriel.rural.models.Raca;
import com.adriel.rural.repositories.RacaRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RacaService {
    
    @Autowired
    RacaRepository racaRepository;

    public List<Raca> findAll(){
        return racaRepository.findAll();
    }

    public Raca findById(Long id){
        return racaRepository.findById(id).get();
    }
    
    public Raca save(Raca raca) {
        return racaRepository.save(raca);
    }

    public void delete(Long id){
        racaRepository.deleteById(id);
    }

    public Raca update(Long id, Raca obj){
        Raca entity = racaRepository.getById(id);
        updateData(entity, obj);
        return racaRepository.save(entity);
    }

    private void updateData(Raca entity, Raca obj){
        entity.setNome(obj.getNome());
    }

}