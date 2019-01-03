package com.algaworks.cursojsf2.view;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.NoneScoped;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;
import javax.faces.event.ActionEvent;
import javax.faces.event.ValueChangeEvent;

import com.algaworks.cursojsf2.model.Produto;

/*Quando não definimos o escopo por padrão é definido o @RequestScoped assim o objeto é substituido.
 O tempo de vida do request � uma requisição. Cada clique em um botão , por exemplo, é uma requisição.*/

//@ApplicationScoped //escopo de aplicação - compartilha dados - é por aplicação .
//@SessionScoped /*escopo de sessão - por usuario- não compartilha dados - tem tempo de timeout - cada usuario tem seus dados*/
/*Novos escopos - view , request e none 
 *objetos com escopo longo podem precisar ser serializados - Serialização escreve o estado atual do objeto em bytes
 *para possivel transmissão por rede.
 * */

/* Tempo de vida menor que sessão. 
SessionScoped (inicio da sessão ate parar de usar o sistema ou a sessão expirar(Longo)
o viewscoped dura enquanto a tela está sendo utilizada(tempo mais curto e sem compartilhar dados) - 
não compartilha dados de outros usuarios- mas é um escopo de tela.
*/
//@RequestScoped 
/*Escopo padrão caso não informe.A cada requisição é inicializado e fechado o tempo de vida ..Muito curto*/
//@NoneScoped
/*Não tem tempo de vida nenhum. Por demanda. Menos usado.*/
@ManagedBean(name = "gestaoproduto")
@ViewScoped
public class GestaoProdutoBean implements Serializable {

	private static final long serialVersionUID = 1L;

	private Produto produto;
	private List<Produto> produtos;
	private String fabricantePesquisar;
	private Log eventos;
	private List<Log> logs;

	public GestaoProdutoBean() {
		this.produtos = new ArrayList<Produto>();
		this.produto = new Produto();
		this.logs = new ArrayList<Log>();
	}

	public void incluir() {
		this.produtos.add(this.produto);
		this.produto = new Produto();
	}
	
	public void verificarInclusao(ActionEvent event) {
		
		System.out.println("Verificando ..");
		if ("".equals(this.produto.getFabricante())) {
			System.out.println("Incluindo ..");
			this.produto.setFabricante("Sem Fabricate");
		}
		eventos.setDataEvento(new Date());
		eventos.setMetodo(event.getComponent().getId());
		logs.add(eventos);
	}

	public void pesquisar() {
		System.out.println("Pesquisando....");
	}

	public void fabricantePesquisaAlterado(ValueChangeEvent event) {
        if (this.produto.getFabricante().equalsIgnoreCase("")) {
			this.produto.setFabricante("Sem Fabricante");
		}
		this.fabricantePesquisar = event.getNewValue().toString();
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

//    @PostConstruct // chama o metodo após construtor do objeto - inicializar algum recurso
//	public void inicializar() {
//		System.out.println("Inicializou bean");
//	}
//    @PreDestroy //o metodo será chamado momentos antes de um managed bean ser distruido .. Objeto ser removido.
//    public void finalizar() {
//    	System.out.println("Finalizando Bean!");
//    }
	public String getFabricantePesquisar() {
		return fabricantePesquisar;
	}

	public void setFabricantePesquisar(String fabricante) {
		this.fabricantePesquisar = fabricante;
	}

	public Log getEventos() {
		return eventos;
	}

	public void setEventos(Log eventos) {
		this.eventos = eventos;
	}

}
