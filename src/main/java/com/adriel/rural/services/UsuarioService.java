package com.adriel.rural.services;

import java.util.List;

import com.adriel.rural.models.Usuario;
import com.adriel.rural.repositories.UsuarioRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    public List<Usuario> findAll(){
        return usuarioRepository.findAll();   
    }

    public Usuario findById(Long id){
        return usuarioRepository.findById(id).get();
    }

    public Usuario save(Usuario obj){
        return usuarioRepository.save(obj);
    }

    public void deleteById(Long id){
        usuarioRepository.deleteById(id);
    }

    public Usuario update(Long id, Usuario obj){
        Usuario entity = usuarioRepository.getById(id);
        updateData(entity, obj);
        return usuarioRepository.save(entity);
    }

    private void updateData(Usuario entity, Usuario obj) {
        entity.setLogin(obj.getLogin());
        entity.setSenha(obj.getSenha());
        entity.setDataCadastro(obj.getDataCadastro());
        entity.setProprietario(obj.getProprietario());
    }

}