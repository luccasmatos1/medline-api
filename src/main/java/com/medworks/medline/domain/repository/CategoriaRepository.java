package com.medworks.medline.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.medworks.medline.model.Categorias;

@Repository
public interface CategoriaRepository extends JpaRepository<Categorias, Integer>{
	
}






