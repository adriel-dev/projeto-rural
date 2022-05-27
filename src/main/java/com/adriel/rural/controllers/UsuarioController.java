package com.adriel.rural.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.adriel.rural.models.Usuario;
import com.adriel.rural.services.UsuarioService;

@RestController @RequestMapping(value = "/usuarios")
public class UsuarioController {
    
    @Autowired
    private UsuarioService usuarioService;
    
    @Autowired 
    PasswordEncoder encoder;

    @GetMapping
    public List<Usuario> findAll(){
        return usuarioService.findAll();
    }

    @GetMapping(value = "/{id}")
    public Usuario findById(@PathVariable Long id){
        return usuarioService.findById(id);
    }

    @PostMapping
    public Usuario save(@RequestBody Usuario obj){
    	obj.setSenha(encoder.encode(obj.getSenha()));
        return usuarioService.save(obj);
    }

    @PutMapping(value = "/{id}")
    public Usuario update(@PathVariable Long id, @RequestBody Usuario obj){
        return usuarioService.update(id, obj);
    }

    @DeleteMapping(value = "/{id}")
    public void deleteById(@PathVariable Long id){
        usuarioService.deleteById(id);
    }

}
