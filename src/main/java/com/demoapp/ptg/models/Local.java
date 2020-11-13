package com.demoapp.ptg.models;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.Digits;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "LOCAL", uniqueConstraints = {@UniqueConstraint(columnNames = {"id", "nome"})})
public class Local implements Serializable  {


	/**
	 * 
	 */
	private static final long serialVersionUID = 7708339377775777115L;


	@Id
	@NotNull
	private Integer id;

	
	private String nome;
	
	@NotNull
	@Min(1)
	@Max(5)
	private Integer avaliacao;
	
	private String comentario;
	

	/*
	 * Construtor padrão
	 */
	public Local() {
		
	}
	
	
	public Local(Integer id, String nome, Integer avaliacao, String comentario) {
		super();
		this.id = id;
		this.nome = nome;
		this.avaliacao = avaliacao;
		this.comentario = comentario;
	}


	public long getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	public String getNome() {
		return nome;
	}


	public void setNome(String nome) {
		this.nome = nome;
	}


	public Integer getAvaliacao() {
		return avaliacao;
	}


	public void setAvaliacao(Integer avaliacao) {
		this.avaliacao = avaliacao;
	}


	public String getComentario() {
		return comentario;
	}


	public void setComentario(String comentario) {
		this.comentario = comentario;
	}
	
	

	
}
