package com.medworks.medline.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.medworks.medline.domain.repository.EmpresasRepository;
import com.medworks.medline.model.Empresas;

@Service
public class CadEmpresaService {

	@Autowired
	EmpresasRepository empresaRepository;
	
	
	@Transactional // SE DER ERRO EM ALGUM REGISTRO NO BANCO, ELE NAO EXECUTA NADA
	public Empresas salvar(Empresas emp) {
		return empresaRepository.save(emp);
		
	}
	
	@Transactional
	public void excluir(Integer empId) {
		empresaRepository.deleteById(empId);
	}
		
}
