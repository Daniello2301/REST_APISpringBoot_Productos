package com.iudigital.finalproject.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iudigital.finalproject.domain.Categoria;
import com.iudigital.finalproject.repository.CategoriaRepository;

@Service
public class CategoriaService {

	@Autowired
	private CategoriaRepository categoriaRepository;
	
	public List<Categoria> listarCategorias() {
		
		return (List<Categoria>) categoriaRepository.findAll();
		
	}
	
	public void crearCategoria(Categoria categoria) {
		
		categoria.setFechaCreacion(LocalDateTime.now());
		categoriaRepository.save(categoria);
		
	}
	
	public Categoria categoriaById(int id) {
		
		return categoriaRepository.findById(id).get();
	}
	
	
	public void actualizarCategoria(Categoria categoria) {
		
		categoria.setFechaCreacion(LocalDateTime.now());
		categoriaRepository.save(categoria);
		
	}
	
	public void borrarById(int id) {
		
		categoriaRepository.deleteById(id);
	}
}