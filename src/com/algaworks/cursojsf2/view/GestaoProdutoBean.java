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

	private Produto produto;// Produto
	private List<Produto> listProdutos;// Lista produtos gerais
	private List<Produto> listProdutosFiltrados;// Lista produto pesquisados
	private String produtoPesquisado;// Produto Pesquisado
	private Log log;// Log
	private List<Log> listLogs;// Lista logs gerais
	private Produto produtoSelecionado;// Produto selecionado para exclusão ou edição
	private Log logSelecionado;// Log selecionado para exclusão ou edição

	public GestaoProdutoBean() {
		this.listProdutos = new ArrayList<Produto>();
		this.listProdutosFiltrados = new ArrayList<Produto>();
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

	public void excluirLogs() {
		this.listLogs.remove(this.logSelecionado);
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

	public void nomePesquisaAlterado(ValueChangeEvent event) {

//		System.out.println("Evento de mudança de valor.");
//		System.out.println("Valor Atual Fabricante Pesquisar:" + this.fabricantePesquisar);
//		System.out.println("Valor Antigo Fabricante Pesquisar:" + event.getNewValue());
//		this.listProdutosFiltrados.contains(event.getNewValue());

		this.listProdutosFiltrados.clear();
		for (Produto produto : this.listProdutos) {
			if (produto.getNome()!=null && produto.getNome().toLowerCase().startsWith(event.getNewValue().toString().toLowerCase())) {
				listProdutosFiltrados.add(produto);
			}
		}

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

	public List<Produto> getListProdutosFiltrados() {
		return listProdutosFiltrados;
	}

	public String getProdutoPesquisado() {
		return produtoPesquisado;
	}
	public void setProdutoPesquisado(String produtoPesquisado) {
		this.produtoPesquisado = produtoPesquisado;
	}

}
