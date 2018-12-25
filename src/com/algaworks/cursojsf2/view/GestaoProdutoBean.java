package com.algaworks.cursojsf2.view;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.NoneScoped;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;

import com.algaworks.cursojsf2.model.Produto;

@ManagedBean(name="gestaoproduto")
/*Quando não definimos o escopo por padrão é definido o @RequestScoped assim o objeto é substituido.
 O tempo de vida do request � uma requisição. Cada clique em um botão , por exemplo, é uma requisição.*/

//@ApplicationScoped //escopo de aplicação - compartilha dados - é por aplicação .
//@SessionScoped /*escopo de sessão - por usuario- não compartilha dados - tem tempo de timeout - cada usuario tem seus dados*/
/*Novos escopos - view , request e none 
 *objetos com escopo longo podem precisar ser serializados - Serialização escreve o estado atual do objeto em bytes
 *para possivel transmissão por rede.
 * */
//@ViewScoped 
/* Tempo de vida menor que sessão. 
SessionScoped (inicio da sessão ate parar de usar o sistema ou a sessão expirar(Longo)
o viewscoped dura enquanto a tela está sendo utilizada(tempo mais curto e sem compartilhar dados) - 
não compartilha dados de outros usuarios- mas é um escopo de tela.
*/
//@RequestScoped 
/*Escopo padrão caso não informe.A cada requisição é inicializado e fechado o tempo de vida ..Muito curto*/
@NoneScoped
/*Não tem tempo de vida nenhum. Por demanda. Menos usado.*/
public class GestaoProdutoBean implements Serializable{
 
	private static final long serialVersionUID = 1L;
	
	private Produto produto ;
	private List<Produto> produtos;
	
	public GestaoProdutoBean() {
		this.produtos = new ArrayList<Produto>();
		this.produto= new Produto();
	}
	public void incluir() {
	 this.produtos.add(this.produto);
	 this.produto = new Produto();
	}

	public Produto getProduto() {
		return produto;
	}
	public List<Produto> getProdutos() {
		return produtos;
	}
	public void setProdutos(List<Produto> produtos) {
		this.produtos = produtos;
	}
    @PostConstruct // chama o metodo após construtor do objeto - inicializar algum recurso
	public void inicializar() {
		System.out.println("Inicializou bean");
	}
    @PreDestroy //o metodo será chamado momentos antes de um managed bean ser distruido .. Objeto ser removido.
    public void finalizar() {
    	System.out.println("Finalizando Bean!");
    }



}
