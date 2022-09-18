package com.medworks.medline.controller;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.validation.Valid;

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

import com.medworks.medline.domain.repository.UsersRepository;
import com.medworks.medline.model.Users;

import java.util.Optional;

@RestController
@RequestMapping("/users")
public class UsuariosController {

	@PersistenceContext
	private EntityManager manager;

	private UsersRepository usersRepository;

	public UsuariosController(UsersRepository usersRepository) {
		super();
		this.usersRepository = usersRepository;
	}

	@GetMapping
	public List<Users> listar() {
		return usersRepository.findAll();

	}

	@GetMapping("/{userId}")
	public ResponseEntity<Users> buscarUsuario(@PathVariable Long userId) {
		Optional<Users> user = usersRepository.findById(userId);

		if(user.isPresent()) {
			return ResponseEntity.ok(user.get());
		}
		return ResponseEntity.notFound().build(); // RETORNA O ERRO 404 CASO O USER NAO SEJA ENCONTRADO

	}
	
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Users adicionar(@Valid @RequestBody Users user) {
		return usersRepository.save(user);
	}
	
	@PutMapping("/{userId}")
	public ResponseEntity<Users> update(@PathVariable Long userId ,@Valid @RequestBody Users user){
		if(!usersRepository.existsById(userId)) {
			return ResponseEntity.notFound().build();
		}
		
		user.setId(userId);
		user = usersRepository.save(user);
		return ResponseEntity.ok(user);
	}
	
	@DeleteMapping("/{userId}")
	public ResponseEntity<Void> delete(@PathVariable Long userId){
		if(!usersRepository.existsById(userId)) {
			return ResponseEntity.notFound().build();
		}
		
		usersRepository.deleteById(userId);
		
		return ResponseEntity.noContent().build();
	}
	
	
}