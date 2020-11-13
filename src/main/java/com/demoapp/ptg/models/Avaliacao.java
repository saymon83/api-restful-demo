package com.demoapp.ptg.models;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name = "AVALIACAO", uniqueConstraints = {@UniqueConstraint(columnNames = {"valor", "comentario"})})
public class Avaliacao {
	@Id
	private Integer valor;
	
	
	private String comentario;

	public Avaliacao(Integer valor, String comentario) {
		super();
		this.valor = valor;
		this.comentario = comentario;
	}

	public Avaliacao() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Integer getValor() {
		return valor;
	}

	public void setValor(Integer valor) {
		this.valor = valor;
	}

	public String getComentario() {
		return comentario;
	}

	public void setComentario(String comentario) {
		this.comentario = comentario;
	}


}
