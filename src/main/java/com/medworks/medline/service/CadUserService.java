package com.medworks.medline.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.medworks.medline.domain.repository.UsersRepository;
import com.medworks.medline.model.Users;

@Service
public class CadUserService{

	 @Autowired
	 UsersRepository usersRepository;
	
	@Transactional // SE DER ERRO EM ALGUM REGISTRO NO BANCO, ELE NAO EXECUTA NADA
	public Users salvar(Users user) {
		return usersRepository.save(user);
		
	}
	
	@Transactional
	public void excluir(Long userId) {
		usersRepository.deleteById(userId);
	}

	public CadUserService(UsersRepository usersRepository) {
		
		this.usersRepository = usersRepository;
	}
	
}
