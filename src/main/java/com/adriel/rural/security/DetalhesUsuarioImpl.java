package com.adriel.rural.security;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Optional;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.adriel.rural.models.Usuario;

public class DetalhesUsuarioImpl implements UserDetails {
	
	private final Optional<Usuario> usuario;
	
	public DetalhesUsuarioImpl(Optional<Usuario> usuario) {
		this.usuario = usuario;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return new ArrayList<>();
	}

	@Override
	public String getPassword() {
		return usuario.orElse(new Usuario()).getSenha();
	}

	@Override
	public String getUsername() {
		return usuario.orElse(new Usuario()).getLogin();
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return true;
	}

}