package com.algaworks.cursojsf2.view;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.event.ActionEvent;
import javax.faces.event.ValueChangeEvent;

import com.algaworks.cursojsf2.model.Produto;

@ManagedBean(name = "gestaoproduto")
@SessionScoped
public class GestaoProdutoBean implements Serializable {

	private static final long serialVersionUID = 1L;

	private Produto produto;
	private List<Produto> listProdutos;
	private String fabricantePesquisar;
	private Log log;
	private List<Log> listLogs;
	private Produto produtoSelecionado;
	private Log logSelecionado;

	public GestaoProdutoBean() {
		this.listProdutos = new ArrayList<Produto>();
		this.listLogs = new ArrayList<Log>();
		this.produto = new Produto();
		this.log = new Log();
	}

	public void incluir() {
		validarCampo();
		this.listProdutos.add(this.produto);
	}

	public void clean() {
		this.produto = new Produto();
		this.log = new Log();
	}
	
	public void excluir() {
		this.listProdutos.remove(this.produtoSelecionado);
	}
	


	public void verificarInclusao(ActionEvent event) {
		validarCampo();
		logarAcoes(event);
	}

	public void logarAcoes(ActionEvent event) {
		log.setDataEvento(new Date());
		log.setMetodo(event.getComponent().getId());
		log.setComponente(event.getComponent().toString());
		listLogs.add(log);
		this.log = new Log();
	}

	private void validarCampo() {
		System.out.println("Verificando ..");
		if ("".equals(this.produto.getNome()))
			this.produto.setNome("Nome Não Informado");

		if ("".equals(this.produto.getCategoria()))
			this.produto.setCategoria("Categoria Não Informada");

		if ("".equals(this.produto.getFabricante()))

			this.produto.setFabricante("Fabricante Não Informado");

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

	public Log getLog() {
		return log;
	}

	public void setLog(Log log) {
		this.log = log;
	}

	public List<Produto> getListProdutos() {
		return listProdutos;
	}

	public void setListProdutos(List<Produto> listProdutos) {
		this.listProdutos = listProdutos;
	}

	public List<Log> getListLogs() {
		return listLogs;
	}

	public void setListLogs(List<Log> listLogs) {
		this.listLogs = listLogs;
	}

	public Produto getProdutoSelecionado() {
		return produtoSelecionado;
	}

	public void setProdutoSelecionado(Produto produtoSelecionado) {
		this.produtoSelecionado = produtoSelecionado;
	}

	public Log getLogSelecionado() {
		return logSelecionado;
	}

	public void setLogSelecionado(Log logSelecionado) {
		this.logSelecionado = logSelecionado;
	}

}
