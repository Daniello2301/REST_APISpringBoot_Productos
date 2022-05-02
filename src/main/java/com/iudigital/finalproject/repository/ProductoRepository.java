package com.iudigital.finalproject.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import com.iudigital.finalproject.domain.Producto;

@Service
public interface ProductoRepository extends CrudRepository<Producto, Integer> {

}
