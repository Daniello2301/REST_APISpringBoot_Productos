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

import com.iudigital.finalproject.domain.Producto;
import com.iudigital.finalproject.service.ProductoService;

@RestController
@RequestMapping(value = "producto")
@CrossOrigin("*")
public class ProductoController {

	@Autowired
	private ProductoService productoService;

	@PostMapping
	@ResponseStatus(HttpStatus.NO_CONTENT)
	//@PreAuthorize("hasAuthority('SELLER', 'ADMIN')")
	public void crearProducto(@RequestBody Producto producto) {

		productoService.crearProducto(producto);

	}

	@GetMapping
	//@PreAuthorize("hasAuthority('SELLER', 'ADMIN')")
	public List<Producto> listarProducto() {

		return productoService.listarProductos();

	}
	
	//@PreAuthorize("hasAuthority('SELLER', 'ADMIN')")
	@GetMapping("/{id}")
	public Producto productoById(@PathVariable("id") Integer id) {
	
		return productoService.productoById(id);
	}
	
	//@PreAuthorize("hasAuthority('SELLER', 'ADMIN')")
	@PutMapping()
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void actualizarProducto(@RequestBody Producto producto) {
		
		productoService.actualizarProducto(producto);
		
	}
	
	@PreAuthorize("hasAuthority('ADMIN')")
	@DeleteMapping("/{id}")
	public void borrarById(@PathVariable("id") Integer id) {
		
		productoService.borrarById(id);
	}

}


