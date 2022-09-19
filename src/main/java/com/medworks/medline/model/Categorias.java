package com.medworks.medline.model;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Range;

@Entity
@Table(name = "Categorias")
public class Categorias {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)

	private Integer idCategoria;
	
	@Size(max = 255)
	private String nome;
	

	private Integer idPai;
	
	
	public Categorias() {
		
	}
	
	
	
	public Categorias(Integer idCategoria, String nome, Integer idPai) {
		super();
		this.idCategoria = idCategoria;
		this.nome = nome;
		this.idPai = idPai;
	}



	public Integer getIdCategoria() {
		return idCategoria;
	}
	public void setIdCategoria(Integer idCategoria) {
		this.idCategoria = idCategoria;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public Integer getIdPai() {
		return idPai;
	}
	public void setIdPai(Integer idPai) {
		this.idPai = idPai;
	}
	@Override
	public int hashCode() {
		return Objects.hash(idCategoria);
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Categorias other = (Categorias) obj;
		return Objects.equals(idCategoria, other.idCategoria);
	}
	
	
}
