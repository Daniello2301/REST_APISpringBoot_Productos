package com.iudigital.finalproject.domain;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "pedidos")
public class Pedido {

	/************************* ATTRIBUTES ************************************************/
	@Id
	@Column(name = "pedido_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer pedidoId;
	
	
	private LocalDateTime fechaCreacion;
	
	@ManyToOne
	@JoinColumn(name = "producto_id") //Connection to Producto table
	private Producto productoId;

	private int cantidad;
	
	@ManyToOne
	@JoinColumn(name = "usuario_id")// Connetion to Usuario table for get id Usuario
	private Usuario ususarioId;

	
	/*********************** GETTERS AND SETTERS ****************************************************/
	public Integer getPedidoId() {
		return pedidoId;
	}

	public void setPedidoId(Integer pedidoId) {
		this.pedidoId = pedidoId;
	}

	public LocalDateTime getFechaCreacion() {
		return fechaCreacion;
	}

	public void setFechaCreacion(LocalDateTime fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}

	public Producto getProductoId() {
		return productoId;
	}

	public void setProductoId(Producto productoId) {
		this.productoId = productoId;
	}

	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	public Usuario getUsusarioId() {
		return ususarioId;
	}

	public void setUsusarioId(Usuario ususarioId) {
		this.ususarioId = ususarioId;
	}
	
	
	
	
}
