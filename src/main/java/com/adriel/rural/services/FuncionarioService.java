package com.adriel.rural.services;

import java.util.List;

import com.adriel.rural.models.Funcionario;
import com.adriel.rural.repositories.FuncionarioRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FuncionarioService {
    
    @Autowired
    FuncionarioRepository funcionarioRepository;

    public List<Funcionario> findAll(){
        return funcionarioRepository.findAll();
    }

    public Funcionario findById(Long id){
        return funcionarioRepository.findById(id).get();
    }

    public Funcionario save(Funcionario obj){
        return funcionarioRepository.save(obj);
    }

    public void deleteById(Long id){
        funcionarioRepository.deleteById(id);
    }

    public Funcionario update(Long id, Funcionario obj){
        Funcionario entity = funcionarioRepository.getById(id);
        updateData(entity, obj);
        return funcionarioRepository.save(entity);
    }

    private void updateData(Funcionario entity, Funcionario obj) {
        entity.setNome(obj.getNome());
        entity.setSobrenome(obj.getSobrenome());
        entity.setDataDeNascimento(obj.getDataDeNascimento());
        entity.setSalario(obj.getSalario());
        entity.setCargo(obj.getCargo());
    }

}
