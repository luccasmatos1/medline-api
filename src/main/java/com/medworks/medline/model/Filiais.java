package com.medworks.medline.model;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.hibernate.validator.constraints.Range;

@Entity
public class Filiais {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idFilial;
	
	@Column(name = "CNPJ_CPF")
	private Integer cpfCnpj;
	private String longitude;
	private String latitude;
	private String numero;
	private String complemento;
	private Double txServico;
	private Double txGerenciamento;
	private Integer tipo;
	
	
	
	public Filiais() {
		
	}
	
	public Filiais(Integer idFilial, Integer cpfCnpj, String longitude, String latitude, String numero,
			String complemento, Double txServico, Double txGerenciamento, Integer tipo) {
		super();
		this.idFilial = idFilial;
		this.cpfCnpj = cpfCnpj;
		this.longitude = longitude;
		this.latitude = latitude;
		this.numero = numero;
		this.complemento = complemento;
		this.txServico = txServico;
		this.txGerenciamento = txGerenciamento;
		this.tipo = tipo;
	}
	public Integer getIdFilial() {
		return idFilial;
	}
	public void setIdFilial(Integer idFilial) {
		this.idFilial = idFilial;
	}
	public Integer getCpfCnpj() {
		return cpfCnpj;
	}
	public void setCpfCnpj(Integer cpfCnpj) {
		this.cpfCnpj = cpfCnpj;
	}
	public String getLongitude() {
		return longitude;
	}
	public void setLongitude(String longitude) {
		this.longitude = longitude;
	}
	public String getLatitude() {
		return latitude;
	}
	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}
	public String getNumero() {
		return numero;
	}
	public void setNumero(String numero) {
		this.numero = numero;
	}
	public String getComplemento() {
		return complemento;
	}
	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}
	public Double getTxServico() {
		return txServico;
	}
	public void setTxServico(Double txServico) {
		this.txServico = txServico;
	}
	public Double getTxGerenciamento() {
		return txGerenciamento;
	}
	public void setTxGerenciamento(Double txGerenciamento) {
		this.txGerenciamento = txGerenciamento;
	}
	public Integer getTipo() {
		return tipo;
	}
	public void setTipo(Integer tipo) {
		this.tipo = tipo;
	}
	@Override
	public int hashCode() {
		return Objects.hash(idFilial);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Filiais other = (Filiais) obj;
		return Objects.equals(idFilial, other.idFilial);
	}
	
	
	
	
}
