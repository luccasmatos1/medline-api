package com.medworks.medline.controller;

import java.util.List;
import java.util.Optional;

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

import com.medworks.medline.domain.repository.FiliaisRepository;
import com.medworks.medline.model.Filiais;
import com.medworks.medline.model.Users;
import com.medworks.medline.service.CadFiliaisService;

@RestController
@RequestMapping("/filiais")
public class FiliaisController {

	@Autowired
	FiliaisRepository filiaisRepository;
	@Autowired 
	CadFiliaisService cadFiliaisService;
	public FiliaisController(FiliaisRepository filiaisRepository) {
		super();
		this.filiaisRepository = filiaisRepository;
	}
	
	
	@GetMapping
	public List<Filiais> listar(){
		return filiaisRepository.findAll();
	}
	
	
	@GetMapping("/{filialId}")
	public ResponseEntity<Filiais> buscarUsuario(@PathVariable Integer filialId) {
		Optional<Filiais> filial = filiaisRepository.findById(filialId);

		if(filial.isPresent()) {
			return ResponseEntity.ok(filial.get());
		}
		return ResponseEntity.notFound().build(); // RETORNA O ERRO 404 CASO O USER NAO SEJA ENCONTRADO

	}
	
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Filiais adicionar(@Valid @RequestBody Filiais filial) {
		return cadFiliaisService.salvar(filial);
	}
	
	@PutMapping("/{filialId}")
	public ResponseEntity<Filiais> update(@Valid @PathVariable Integer filialId , @RequestBody Filiais filial){
		if(!filiaisRepository.existsById(filialId)) {
			return ResponseEntity.notFound().build();
		}
		
		filial.setIdFilial(filialId);
		cadFiliaisService.salvar(filial);
		
		
		return ResponseEntity.ok(filial);
	}
	
	@DeleteMapping("/{filialId}")
	public ResponseEntity<Void> delete(@PathVariable Integer filialId){
		if(!filiaisRepository.existsById(filialId)) {
			return ResponseEntity.notFound().build();
		}
		
		cadFiliaisService.excluir(filialId);
		
		return ResponseEntity.noContent().build();
	}
}
