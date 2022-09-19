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

import com.medworks.medline.domain.repository.EmpresasRepository;
import com.medworks.medline.model.Empresas;
import com.medworks.medline.service.CadEmpresaService;

@RestController
@RequestMapping("/empresa")
public class EmpresasController {

	@PersistenceContext
	private EntityManager manager;
	
	@Autowired
	EmpresasRepository empresasRepository;
	@Autowired
	CadEmpresaService cadEmpresaService;
	
	public EmpresasController(EmpresasRepository empresasRepository) {
		super();
		this.empresasRepository = empresasRepository;
	}
	
	@GetMapping
	public List<Empresas> listar(){
		return empresasRepository.findAll();
	}
	
	@GetMapping("/{empresaId}")
	public ResponseEntity<Empresas> buscarUsuario(@PathVariable Integer empresaId) {
		Optional<Empresas> emp = empresasRepository.findById(empresaId);

		if(emp.isPresent()) {
			return ResponseEntity.ok(emp.get());
		}
		return ResponseEntity.notFound().build(); // RETORNA O ERRO 404 CASO O USER NAO SEJA ENCONTRADO

	}
	
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Empresas adicionar(@Valid @RequestBody Empresas emp) {
		return cadEmpresaService.salvar(emp);
	}
	
	@PutMapping("/{empresaId}")
	public ResponseEntity<Empresas> update(@Valid @PathVariable Integer empresaId , @RequestBody Empresas emp){
		if(!empresasRepository.existsById(empresaId)) {
			return ResponseEntity.notFound().build();
		}
		
		emp.setIdEmpresa(empresaId);
		cadEmpresaService.salvar(emp);
		
		
		return ResponseEntity.ok(emp);
	}
	
	@DeleteMapping("/{empresaId}")
	public ResponseEntity<Empresas> delete(@PathVariable Integer empresaId){
		if(!empresasRepository.existsById(empresaId)) {
			return ResponseEntity.notFound().build();
		}
		
		cadEmpresaService.excluir(empresaId);
		
		return ResponseEntity.noContent().build();
	}


	
	
	
}
