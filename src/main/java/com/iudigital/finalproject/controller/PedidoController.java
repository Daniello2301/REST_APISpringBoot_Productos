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

import com.iudigital.finalproject.domain.Pedido;
import com.iudigital.finalproject.domain.Producto;
import com.iudigital.finalproject.domain.Usuario;
import com.iudigital.finalproject.service.PedidoService;

@RestController
@RequestMapping(value = "pedido")
@CrossOrigin("*")
public class PedidoController {
	
	@Autowired
	private PedidoService pedidoService;
	
	
	/****************** USIN ALL METHOD FROM SERVICE PEDIDO APPLYING NOTATIONS*******/
	@PostMapping()
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void crearPedido(@RequestBody Pedido pedido) {
		
		pedidoService.crearPedido(pedido);
	}
	
	
	@GetMapping()
	public List<Pedido> listarPedidos(){
		
		return pedidoService.listarPedidos();
	}
	
	@GetMapping("/{pedidoId}")
	public Pedido pedidoById(@PathVariable("pedidoId") Integer pedidoId) {
		
		return pedidoService.pedidoByID(pedidoId);
		
	}
		
	
	@DeleteMapping("/{pedidoId}")
	@PreAuthorize("hasAuthority('ADMIN')")// Unique user can eliminate pedido
	public void borrarById(@PathVariable("pedidoId") Integer pedidoId) {
		
		pedidoService.borrarById(pedidoId);
	}
	
	@DeleteMapping()
	@PreAuthorize("hasAuthority('ADMIN')")// The Admin User in unique that eliminate all pedidos
	public void borrarTodo() {
		
		pedidoService.borrarTodo();
	}
	
	@GetMapping("/usuario/{ususarioId}")// Add /usuario for difference with path default 
	public List<Pedido> pedidosByUsurio(@PathVariable("ususarioId") Usuario usuarioId){
		
		return pedidoService.pedidoByUserId(usuarioId);
	}

	/**/
	@GetMapping("/producto/{productoId}")// Add /producto for difference with path default
	public List<Pedido> pedidosByProducto(@PathVariable("productoId") Producto productoId){
		
		return pedidoService.pedidoByProductoId(productoId);
	}
	
	

	@PutMapping()
	@ResponseStatus(HttpStatus.NO_CONTENT)// Response if user send empty petition
	public void actualizarPedido(@RequestBody Pedido pedido) {
		
		pedidoService.actualizaPedido(pedido);
	}
}









