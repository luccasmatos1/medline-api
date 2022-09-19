package com.medworks.medline.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.medworks.medline.model.Filiais;

@Repository
public interface FiliaisRepository extends JpaRepository<Filiais, Integer> {

}
