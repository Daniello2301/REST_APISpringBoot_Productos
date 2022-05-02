package com.iudigital.finalproject.security.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.iudigital.finalproject.domain.Usuario;
import com.iudigital.finalproject.repository.UsuarioRepository;

@Service
public class UserService implements UserDetailsService  {

	@Autowired
	private UsuarioRepository usuarioRepository;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		Usuario usuario = usuarioRepository.findByEmail(username);
		
		if (usuario == null) {
			throw new UsernameNotFoundException("usuario.no.existe");
		}
		
		List<SimpleGrantedAuthority> roles = new ArrayList<>();
		roles.add(new SimpleGrantedAuthority(usuario.getRole().getNombre()));
		
		UserDetails userDetails = new User(usuario.getEmail(), usuario.getPassword(), roles);
		
		return userDetails;
		
	}

}