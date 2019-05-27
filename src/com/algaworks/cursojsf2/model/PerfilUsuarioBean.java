package com.algaworks.cursojsf2.model;
import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean(name = "perfilUsuarioBean")
@SessionScoped
//@SessionScoped
public class PerfilUsuarioBean implements Serializable {

	private static final long serialVersionUID = 1L;
	private String sexo;
	private boolean receberNovidades;
	private String[] linguagemFavoritas;

	
	public String enviar() {
		return "resposta";
	}
	
	public void inserir() {
		
		//TODO inserir dados de linguagem favorita ainda pendentes.
	}

	public String getSexo() {
		return sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}

	public boolean isReceberNovidades() {
		return receberNovidades;
	}

	public void setReceberNovidades(boolean receberNovidades) {
		this.receberNovidades = receberNovidades;
	}

	public String[] getLinguagemFavoritas() {
		return linguagemFavoritas;
	}

	public void setLinguagemFavoritas(String[] linguagemFavoritas) {
		this.linguagemFavoritas = linguagemFavoritas;
	}

	
	
}
