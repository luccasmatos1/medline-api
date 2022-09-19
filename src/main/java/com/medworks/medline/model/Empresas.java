package com.medworks.medline.model;

import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity
public class Empresas {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) // AUTO INCREMENTA O ID DO USUARIO
	private Integer idEmpresa;
	private Integer tipo;
	private String hPage;
	private String fone;
	
	
	
	
	public Empresas() {
		
	}
	
	public Empresas(Integer idEmpresa, Integer tipo, String hPage, String fone) {
		super();
		this.idEmpresa = idEmpresa;
		this.tipo = tipo;
		this.hPage = hPage;
		this.fone = fone;
	}
	public Integer getIdEmpresa() {
		return idEmpresa;
	}
	public void setIdEmpresa(Integer idEmpresa) {
		this.idEmpresa = idEmpresa;
	}
	public Integer getTipo() {
		return tipo;
	}
	public void setTipo(Integer tipo) {
		this.tipo = tipo;
	}
	public String gethPage() {
		return hPage;
	}
	public void sethPage(String hPage) {
		this.hPage = hPage;
	}
	public String getFone() {
		return fone;
	}
	public void setFone(String fone) {
		this.fone = fone;
	}
	@Override
	public int hashCode() {
		return Objects.hash(idEmpresa);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Empresas other = (Empresas) obj;
		return Objects.equals(idEmpresa, other.idEmpresa);
	}
	
	
	
}
