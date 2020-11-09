package com.algaworks.cursojsf2.view;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;


import com.algaworks.cursojsf2.dominio.Produto;

@SuppressWarnings("deprecation")
@ManagedBean
@RequestScoped
public class OutrosEscopos implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private Produto produto;
	
	private List<Produto> produtoList;
	
	public OutrosEscopos() {
	 this.produto = new Produto();
	 this.produtoList = new ArrayList<Produto>();
	}
	
	public void gravar() {
		try {
			this.produtoList.add(produto);
			this.produto= new Produto();
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	@PostConstruct 
	private void inicializar() {
		System.out.println("Annotation PostConstruct - inicializar apśo carregar o construtor ...");
	}
	
	@PreDestroy
	private void finalizar() {
		System.out.println("Annotation predestroy chama o metodo momento antes de um escopo ser destruido ...");
	}
	
	public void setProduto(Produto produto) {
		this.produto = produto;
	}
	public Produto getProduto() {
		return produto;
	}
	
	public List<Produto> getProdutoList() {
		return produtoList;
	}

}
