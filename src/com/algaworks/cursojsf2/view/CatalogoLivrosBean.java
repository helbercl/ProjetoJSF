package com.algaworks.cursojsf2.view;

import java.io.Serializable;
import java.lang.ProcessBuilder.Redirect;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.NoneScoped;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;

import com.algaworks.cursojsf2.model.Livros;
import com.sun.org.apache.regexp.internal.recompile;

@ManagedBean(name = "catalogolivros")
//@RequestScoped
@SessionScoped
//@ViewScoped
//@ApplicationScoped
//@NoneScoped

public class CatalogoLivrosBean implements Serializable {

	private static final long serialVersionUID = 1L;
	private Livros livro;
	private List<Livros> livros;

	public CatalogoLivrosBean() {
		this.livro = new Livros();
		this.livros = new ArrayList<Livros>();

	}

	public void inserir() {
		this.livros.add(this.livro);
		this.livro = new Livros();
	}

	public String obterAjuda() {
		if (this.livros.isEmpty()) {
			return "help/help?faces-redirect=true";
		} else {
			return "help/help_phone?faces-redirect=true";
		}

	}

	@PostConstruct
	public void inicializar() {
		System.out.println("Inicializando as " + new Date().getTime());
	}

	@PreDestroy
	public void finalizar() {
		System.out.println("Finalizando as " + new Date().getTime());
	}

	public Livros getLivro() {
		return livro;
	}

	public void setLivro(Livros livro) {
		this.livro = livro;
	}

	public List<Livros> getLivros() {
		return livros;
	}

	public void setLivros(List<Livros> livros) {
		this.livros = livros;
	}

}
