package com.adriel.rural.services;

import java.util.List;

import com.adriel.rural.models.Fazenda;
import com.adriel.rural.repositories.FazendaRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FazendaService {
    
    @Autowired
    FazendaRepository fazendaRepository;

    public List<Fazenda> findAll(){
        return fazendaRepository.findAll();
    }

    public Fazenda findById(Long id){
        return fazendaRepository.findById(id).get();
    }

    public Fazenda save(Fazenda obj){
        return fazendaRepository.save(obj);
    }

    public void deleteById(Long id){
        fazendaRepository.deleteById(id);
    }

    public Fazenda update(Long id, Fazenda obj){
        Fazenda entity = fazendaRepository.getById(id);
        updateData(entity, obj);
        return fazendaRepository.save(entity);
    }

    private void updateData(Fazenda entity, Fazenda obj) {
        entity.setNomeFazenda(obj.getNomeFazenda());
        entity.setProprietario(obj.getProprietario());
        entity.setEndereco(obj.getEndereco());
        entity.setCidade(obj.getCidade());
        entity.setEstado(obj.getEstado());
    }

}
