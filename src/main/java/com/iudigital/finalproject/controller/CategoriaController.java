package com.iudigital.finalproject.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
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

import com.iudigital.finalproject.domain.Categoria;
import com.iudigital.finalproject.service.CategoriaService;

@RestController
@RequestMapping(value ="categoria")
@CrossOrigin("*")
public class CategoriaController {
	
	@Autowired
	private CategoriaService categoriaService;

	@PostMapping
	@ResponseStatus(HttpStatus.NO_CONTENT)
    @PreAuthorize("hasAuthority('ADMIN')")
	public void crearCategoria(@RequestBody Categoria categoria) {

		categoriaService.crearCategoria(categoria);

	}

	@GetMapping
	public List<Categoria> listarUsuarios() {

		return categoriaService.listarCategorias();

	}
	
	@GetMapping("/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public Categoria categoriaById(@PathVariable("id") int id) {
		
		return categoriaService.categoriaById(id);
		
	}
	
	@PutMapping()
	@ResponseStatus(HttpStatus.NO_CONTENT)
	@PreAuthorize("hasAuthority('ADMIN')")
	public void actualizarCategoria(Categoria categoria) {
		
		categoriaService.actualizarCategoria(categoria);
	}
	
	@DeleteMapping("/{id}")
	@PreAuthorize("hasAuthority('ADMIN')")
	public void borrarById(@PathVariable("id") int id) {
		
		categoriaService.borrarById(id);
	}
	
	
}

