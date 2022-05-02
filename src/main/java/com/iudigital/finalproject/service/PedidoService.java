package com.iudigital.finalproject.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iudigital.finalproject.domain.Pedido;
import com.iudigital.finalproject.domain.Producto;
import com.iudigital.finalproject.domain.Usuario;
import com.iudigital.finalproject.repository.PedidoRepository;

@Service
public class PedidoService{
	@Autowired
	private PedidoRepository pedidoRepository;
	
	/*********** CREATE PEDIDO *********************/
	public void crearPedido(Pedido pedido) {
		pedido.setFechaCreacion(LocalDateTime.now());
		pedidoRepository.save(pedido);
	}
	
	/****************** GET ALL PEDIDOS ******************/
	public List<Pedido> listarPedidos(){
		
		return (List<Pedido>) pedidoRepository.findAll();
		
	}
	
	
	/*************** GET PEDIDO BY ID *******************/
	public Pedido pedidoByID(Integer pedidoId) {
		
		return pedidoRepository.findById(pedidoId).get();
	}
	
	
	/************* DELETE PEDIDO BY ID *********************/
	public void borrarById(Integer pedidoId) {
		
		pedidoRepository.deleteById(pedidoId);
	}
	
	/*************** DELETE ALL PEDIDOS ****************************/
	public void borrarTodo() {
		
		pedidoRepository.deleteAll();
	}
	
	/*************** GET BY ID USUARIO **********************/
	public List<Pedido> pedidoByUserId(Usuario usuarioId){
		
		return pedidoRepository.findByUserId(usuarioId);
	}
	
//	/**************** GET BY ID PRODUCTO *********************/
	public List<Pedido> pedidoByProductoId(Producto productoId){
		
		return pedidoRepository.findByProductoId(productoId);
	}
	
	
	/*************** UPDATE PEDIDO *****************************/
	public void actualizaPedido(Pedido pedido) {
		
		pedido.setFechaCreacion(LocalDateTime.now());
		pedidoRepository.save(pedido);
		
	}

}
