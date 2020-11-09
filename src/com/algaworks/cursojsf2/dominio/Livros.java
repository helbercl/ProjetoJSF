package com.algaworks.cursojsf2.dominio;

import java.io.Serializable;

public class Livros implements Serializable {

	private static final long serialVersionUID = 1L;
	private String titulo;
	private String autores;
	private String assuntos;
	
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public String getAutores() {
		return autores;
	}
	public void setAutores(String autores) {
		this.autores = autores;
	}
	public String getAssuntos() {
		return assuntos;
	}
	public void setAssuntos(String assuntos) {
		this.assuntos = assuntos;
	}
}
