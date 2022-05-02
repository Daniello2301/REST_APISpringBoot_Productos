package com.iudigital.finalproject.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.iudigital.finalproject.domain.Usuario;
import com.iudigital.finalproject.service.UsuarioService;

@RestController
@RequestMapping(value = "usuario")
@CrossOrigin("*")
public class UsuarioController {
	
	@Autowired
	private UsuarioService usuarioService;

	@PostMapping
	@ResponseStatus(HttpStatus.NO_CONTENT)
    @PreAuthorize("hasAuthority('ADMIN')")
	public void crearUsuario(@RequestBody Usuario usuario) {
		
		usuarioService.crearUsuario(usuario);

	}

	@PreAuthorize("hasAuthority('ADMIN')")
	@GetMapping
	public List<Usuario> listarUsuarios() {

		return usuarioService.listarUsuarios();

	}
	
	@GetMapping("/{id}")
	@PreAuthorize("hasAuthority('ADMIN')")
	public Usuario usuarioById(@PathVariable("id") Integer id) {
		
		return usuarioService.usuarioById(id);
		
	}
	
	@PutMapping()
	@ResponseStatus(HttpStatus.NO_CONTENT)
	@PreAuthorize("hasAuthority('ADMIN')")
	public void actualizarUsuario(@RequestBody Usuario usuario) {
		
		usuarioService.actualizarUsuario(usuario);
		
	}
	
	@DeleteMapping("/{id}")
	@PreAuthorize("hasAuthority('ADMIN')")
	public void borrarUsuarioById(@PathVariable Integer id) {
		
		usuarioService.borrarUsuarioById(id);
		
	}
}