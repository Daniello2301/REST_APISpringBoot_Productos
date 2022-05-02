package com.iudigital.finalproject.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.iudigital.finalproject.domain.Usuario;
import com.iudigital.finalproject.repository.UsuarioRepository;

@Service
public class UsuarioService {

	@Autowired
	private UsuarioRepository usuarioRepository;
	@Autowired
	private BCryptPasswordEncoder passwordEncoder;
	
	
	/******************* Crear Usuario ***************************************/
	public List<Usuario> listarUsuarios() {
		
		return (List<Usuario>) usuarioRepository.findAll();
		
	}
	
	/******************** Listar Usuario ***********************************************/
	
	public void crearUsuario(Usuario usuario) {
		
		usuario.setPassword(passwordEncoder.encode(usuario.getPassword()));
		usuario.setFechaCreacion(LocalDateTime.now());
		usuarioRepository.save(usuario);
		
	}
	
	
	/********************** Buscar Usuario Por Id *****************************************/
	public Usuario usuarioById(Integer id) {
		
		return usuarioRepository.findById(id).get();
	}
	
	
	/********************** Eliminar Usuario Por Id *****************************************/
	public void borrarUsuarioById(Integer id) {
		
		usuarioRepository.deleteById(id);
		
	}
	
	
	/********************** Actualizar Usuario ***********************************************/
	public void actualizarUsuario(Usuario usuario) {
		
		usuario.setFechaCreacion(LocalDateTime.now());
		usuarioRepository.save(usuario);
		
	}
	
}