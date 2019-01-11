package com.algaworks.cursojsf2.view;

import java.io.Serializable;
//import java.lang.ProcessBuilder.Redirect;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
//import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
//import javax.faces.bean.NoneScoped;
import javax.faces.bean.SessionScoped;
import javax.faces.event.ActionEvent;
//import javax.faces.bean.ViewScoped;
import javax.swing.event.ChangeEvent;

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
	private List<Livros> listLivros;
	private Livros livroSelecionado;
	private Log log;
	private List<Log> listLogs;
	

	public CatalogoLivrosBean() {
		this.livro = new Livros();
		this.listLivros = new ArrayList<Livros>();
		this.listLogs = new ArrayList<Log>();

	}
	
	private void validarCadastro() {
		if ("".equals( this.livro.getTitulo())) {
			this.livro.setTitulo("Titulo Não informado");
		}
		if ("".equals(this.livro.getAutores())) {
			this.livro.setAutores("Autor Não Informado");
		}
		if ("".equals(this.livro.getAssuntos())) {
			this.livro.setAssuntos("Assunto Não Informado");
		}
	}

	public void inserir() {
		validarCadastro();
		this.listLivros.add(this.livro);
	}
    
	public void excluir() {
		this.listLivros.remove(this.livroSelecionado);
	}
	
	public void logarAcoes(ActionEvent event) {
		log.setDataEvento(new Date());
		log.setMetodo(event.getComponent().getId());
		log.setComponente(event.getComponent().toString());
		listLogs.add(log);
		this.log = new Log();
		System.out.println(event.getComponent().getNamingContainer());
	}
	public String obterAjuda() {
		if (this.listLivros.isEmpty()) {
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
		return listLivros;
	}

	public void setLivros(List<Livros> livros) {
		this.listLivros = livros;
	}

	public Livros getLivroSelecionado() {
		return livroSelecionado;
	}
	public void setLivroSelecionado(Livros livroSelecionado) {
		this.livroSelecionado = livroSelecionado;
	}

	public Log getLog() {
		return log;
	}

	public void setLog(Log log) {
		this.log = log;
	}

	public List<Log> getListLogs() {
		return listLogs;
	}

	public void setListLogs(List<Log> listLogs) {
		this.listLogs = listLogs;
	}

}
