package com.medworks.medline.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.medworks.medline.domain.repository.CategoriaRepository;
import com.medworks.medline.model.Categorias;

@Service
public class CadCategoriasService {
	
	
	@Autowired
	private CategoriaRepository categoriaRepository;
	
	@Transactional
	public Categorias salvar(Categorias categoria) {
		return categoriaRepository.save(categoria);
		
	}
	
	@Transactional
	public void excluir(Integer idCategoria) {
		categoriaRepository.deleteById(idCategoria);
	}
	
}
