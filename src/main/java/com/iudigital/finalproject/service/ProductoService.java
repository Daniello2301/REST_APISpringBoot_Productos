package com.iudigital.finalproject.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iudigital.finalproject.domain.Producto;
import com.iudigital.finalproject.repository.ProductoRepository;

@Service
public class ProductoService {

	
	@Autowired
	private ProductoRepository productoRepository;
	
	
	public void crearProducto(Producto producto) {
		
		producto.setFechaCreacion(LocalDateTime.now());
		productoRepository.save(producto);
		
	}
	
	public List<Producto> listarProductos() {
		
		return (List<Producto>) productoRepository.findAll();
		
	}
	
	public Producto productoById(Integer id) {
		
		return productoRepository.findById(id).get();
		
	}
	
	public void actualizarProducto(Producto producto) {
		
		producto.setFechaCreacion(LocalDateTime.now());
		productoRepository.save(producto);
		
	}
	
	public void borrarById(Integer id) {
		
		productoRepository.deleteById(id);
		
	}
}
