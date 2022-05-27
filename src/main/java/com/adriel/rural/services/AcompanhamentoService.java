package com.adriel.rural.services;

import java.util.List;

import com.adriel.rural.models.Acompanhamento;
import com.adriel.rural.repositories.AcompanhamentoRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AcompanhamentoService {
    
    @Autowired
    private AcompanhamentoRepository acompanhamentoRepository;

    public List<Acompanhamento> findAll(){
        return acompanhamentoRepository.findAll();
    }

    public Acompanhamento findById(Long id){
        return acompanhamentoRepository.findById(id).get();
    }

    public Acompanhamento save(Acompanhamento obj){
        return acompanhamentoRepository.save(obj);
    }

    public void deleteById(Long id){
        acompanhamentoRepository.deleteById(id);
    }

    public Acompanhamento update(Long id, Acompanhamento obj){
        Acompanhamento entity = acompanhamentoRepository.getById(id);
        updateData(entity, obj);
        return acompanhamentoRepository.save(entity);
    }

    private void updateData(Acompanhamento entity, Acompanhamento obj){
        entity.setAnimal(obj.getAnimal());
        entity.setDataRealizado(obj.getDataRealizado());
        entity.setAltura(obj.getAltura());
        entity.setPeso(obj.getPeso());
        entity.setVermifugado(obj.isVermifugado());
    }
    
}
