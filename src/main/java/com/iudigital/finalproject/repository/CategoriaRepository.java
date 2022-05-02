package com.iudigital.finalproject.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.iudigital.finalproject.domain.Categoria;

@Repository
public interface CategoriaRepository extends CrudRepository<Categoria, Integer> {

}
