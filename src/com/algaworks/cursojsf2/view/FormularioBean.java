package com.algaworks.cursojsf2.view;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean(name="formularioBean")

public class FormularioBean implements Serializable{
	
	private static final long serialVersionUID = 1L;
	private String nome;
	

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

}
