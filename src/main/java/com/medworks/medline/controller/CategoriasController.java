package com.medworks.medline.controller;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.medworks.medline.domain.repository.CategoriaRepository;
import com.medworks.medline.model.Categorias;
import com.medworks.medline.model.Users;
import com.medworks.medline.service.CadCategoriasService;

@RestController
@RequestMapping("/categoria")
public class CategoriasController {

	
	@PersistenceContext
	private EntityManager manager;
	
	
	private CategoriaRepository categoriaRepository;
	@Autowired
	private CadCategoriasService cadCategoriasService;
	

	
	public CategoriasController(CategoriaRepository categoriaRepository) {
		super();
		this.categoriaRepository = categoriaRepository;
	}


	@GetMapping
	public List<Categorias> listar(){
		return categoriaRepository.findAll();
	}
	
	@GetMapping("/{catId}")
	public ResponseEntity<Categorias> buscarUsuario(@PathVariable Integer catId) {
		Optional<Categorias> idCat = categoriaRepository.findById(catId);

		if(idCat.isPresent()) {
			return ResponseEntity.ok(idCat.get());
		}
		return ResponseEntity.notFound().build(); // RETORNA O ERRO 404 CASO O USER NAO SEJA ENCONTRADO

	}
	
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Categorias adicionar(@RequestBody Categorias categoria) {
		return cadCategoriasService.salvar(categoria);
	}
	
	
	@PutMapping("/{catId}")
	public ResponseEntity<Categorias> update(@Valid @PathVariable Integer catId , @RequestBody Categorias categoria){
		if(!categoriaRepository.existsById(catId)) {
			return ResponseEntity.notFound().build();
		}
		
		categoria.setIdCategoria(catId);
		cadCategoriasService.salvar(categoria);
		
		
		return ResponseEntity.ok(categoria);
	}
	
	@DeleteMapping("/{catId}")
	public ResponseEntity<Void> delete(@PathVariable Integer catId){
		if(!categoriaRepository.existsById(catId)) {
			return ResponseEntity.notFound().build();
		}
		
		cadCategoriasService.excluir(catId);
		
		return ResponseEntity.noContent().build();
	}
	
	
	
}
