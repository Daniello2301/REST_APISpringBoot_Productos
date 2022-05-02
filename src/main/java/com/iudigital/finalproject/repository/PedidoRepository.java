package com.iudigital.finalproject.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.iudigital.finalproject.domain.Pedido;
import com.iudigital.finalproject.domain.Producto;
import com.iudigital.finalproject.domain.Usuario;

@Repository
public interface PedidoRepository extends CrudRepository<Pedido, Integer>{

	/********* ADD METHOD USING QUERY FOR GET PEDIDOS WITH USUARIO ID ***************/
	@Query("SELECT p FROM Pedido p WHERE p.ususarioId = ?1")
	List<Pedido> findByUserId(Usuario usuarioId);
	
	/*********** METHOD QITH QUERY GET PEDIDOS WITH PRODUCTO ID ********************/
	@Query("SELECT p FROM Pedido p WHERE p.productoId = ?1")
	List<Pedido> findByProductoId(Producto productoId);
	
}