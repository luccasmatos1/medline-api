package com.medworks.medline.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.medworks.medline.model.Empresas;

@Repository
public interface EmpresasRepository extends JpaRepository<Empresas, Integer> {

}
