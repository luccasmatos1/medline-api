package com.medworks.medline.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.medworks.medline.domain.repository.FiliaisRepository;
import com.medworks.medline.model.Filiais;

@Service
public class CadFiliaisService {
	
	@Autowired
	FiliaisRepository filiaisRepository;
	
	
	public CadFiliaisService(FiliaisRepository filiaisRepository) {
		super();
		this.filiaisRepository = filiaisRepository;
	}

	public Filiais salvar(Filiais filial) {
		return filiaisRepository.save(filial);
	}
	
	public void excluir(Integer filialId) {
		filiaisRepository.findById(filialId);
	}
}
