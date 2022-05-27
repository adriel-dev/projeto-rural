package com.adriel.rural.security;

import java.util.Optional;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import com.adriel.rural.models.Usuario;
import com.adriel.rural.repositories.UsuarioRepository;

@Component
public class DetalhesUsuarioServiceImpl implements UserDetailsService{

	private UsuarioRepository usuarioRepository;
	
	public DetalhesUsuarioServiceImpl (UsuarioRepository repository) {
		this.usuarioRepository = repository;
	}
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Optional<Usuario> usuario = usuarioRepository.findByLogin(username);
		if(usuario.isEmpty()) {
			throw new UsernameNotFoundException("Usuário: ["+username+"] não encontrado.");
		}
		return new DetalhesUsuarioImpl(usuario);
	}
	
	
	
}
