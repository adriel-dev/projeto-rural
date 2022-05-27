package com.adriel.rural.services;

import java.util.List;

import com.adriel.rural.models.Proprietario;
import com.adriel.rural.repositories.ProprietarioRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProprietarioService {
    
    @Autowired
    private ProprietarioRepository proprietarioRepository;

    public List<Proprietario> findAll(){
        return proprietarioRepository.findAll();
    }

    public Proprietario findById(Long id){
        return proprietarioRepository.findById(id).get();
    }

    public Proprietario save(Proprietario obj){
        return proprietarioRepository.save(obj);
    }

    public void deleteById(Long id){
        proprietarioRepository.deleteById(id);
    }

    public Proprietario update(Long id, Proprietario obj){
        Proprietario entity = proprietarioRepository.getById(id);
        updateData(entity, obj);
        return proprietarioRepository.save(entity);
    }

    private void updateData(Proprietario entity, Proprietario obj) {
        entity.setNome(obj.getNome());
        entity.setSobrenome(obj.getSobrenome());
        entity.setDataDeNascimento(obj.getDataDeNascimento());
    }

}
