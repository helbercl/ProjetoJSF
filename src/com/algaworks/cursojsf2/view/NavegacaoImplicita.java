package com.algaworks.cursojsf2.view;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import com.algaworks.cursojsf2.dominio.Produto;
import com.algaworks.cursojsf2.interfaces.PadraoCrud;
@SuppressWarnings("deprecation")
@ManagedBean(name = "navegacaoImplicita")
@ViewScoped
public class NavegacaoImplicita implements Serializable,PadraoCrud {

	private static final long serialVersionUID = 1L;
	
	private Produto produto;
	private Produto produtoSelecionado;
	private List<Produto> produtoList;
	
	public NavegacaoImplicita() {
	  this.produto = new Produto();
	  produtoList = new ArrayList<Produto>();
	}
	
	public void inserir () {
		try {
			produtoList.add(produto);
			this.produto = new Produto();
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
	}
	
	@Override
	public void clean() {
		
		this.produto = new Produto();
		
	}

	@Override
	public void excluir() {
		
		try {
			produtoList.remove(this.produtoSelecionado);
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
		
	}

	@Override
	public void editar() {
		// TODO Auto-generated method stub
		
	}

	public Produto getProduto() {
		return produto;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}

	public List<Produto> getProdutoList() {
		return produtoList;
	}

	public void setProdutoList(List<Produto> produtoList) {
		this.produtoList = produtoList;
	}

	public Produto getProdutoSelecionado() {
		return produtoSelecionado;
	}

	public void setProdutoSelecionado(Produto produtoSelecionado) {
		this.produtoSelecionado = produtoSelecionado;
	}



}
