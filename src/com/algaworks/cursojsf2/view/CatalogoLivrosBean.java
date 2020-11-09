package com.algaworks.cursojsf2.view;

import java.io.Serializable;
//import java.lang.ProcessBuilder.Redirect;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.faces.application.FacesMessage;
import javax.faces.application.FacesMessage.Severity;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.faces.event.ValueChangeEvent;

import com.algaworks.cursojsf2.model.Livros;
import com.algaworks.cursojsf2.util.Mensagens;

@ManagedBean(name = "catalogolivros")
// @RequestScoped
@SessionScoped
// @ViewScoped
// @ApplicationScoped
// @NoneScoped

public class CatalogoLivrosBean implements Serializable {

	private static final long serialVersionUID = 1L;
	private Livros livro;
	private Livros livroSelecionado;
	private String livroPesquisado;
	private Log log;
	private List<Livros> livrosList;
	private List<Log> logsList;
	private List<Livros> livrosPesquisados;
	private boolean showDetail;

	public CatalogoLivrosBean() {
		this.livro = new Livros();
		this.livrosList = new ArrayList<Livros>();
		this.logsList = new ArrayList<Log>();
		this.log = new Log();
		this.livrosPesquisados = new ArrayList<Livros>();
		this.showDetail = false;
		this.livroPesquisado=null;
	}

	private void validarCadastro() {

		try {
			if ("".equals(this.livro.getTitulo()) || this.livro.getTitulo() == null) {
				// this.livro.setTitulo("Titulo Não informado");
				this.adicionarMensagens("frm_catalogo_livros:ipt_titulo", FacesMessage.SEVERITY_INFO,
						"Titulo Não Informado!", "Favor , informar titulo do Livro!");
			}
			if ("".equals(this.livro.getAutores()) || this.livro.getAutores() == null) {
				// this.livro.setAutores("Autor Não Informado");
				this.adicionarMensagens("frm_catalogo_livros:ipt_autor", FacesMessage.SEVERITY_INFO,
						"Autor Não Informado!", "Favor, informar o autor do livro!");
			}
			if ("".equals(this.livro.getAssuntos()) || this.livro.getAssuntos() == null) {
				// this.livro.setAssuntos("Assunto Não Informado");
				this.adicionarMensagens("frm_catalogo_livros:ipt_assunto", FacesMessage.SEVERITY_INFO,
						"Assunto Não Informado", "Favor, informar o assunto do livro");
			}

		} catch (Exception e) {
			showDetail = true;
			this.adicionarMensagens(null, FacesMessage.SEVERITY_ERROR, e.getMessage(), e.getLocalizedMessage());

		}

	}

	public void inserir() {
		try {
			validarCadastro();
			FacesContext context = FacesContext.getCurrentInstance();
			if (!context.getMessages().hasNext()) {
				this.livrosList.add(this.livro);
				this.adicionarMensagens(null, FacesMessage.SEVERITY_INFO, "Inserido com Sucesso!",
						"Cadastro Realizado com Sucesso!");
			}
			this.livro = new Livros();
			this.livroPesquisado=null;
		} catch (Exception e) {
			showDetail = true;
			Mensagens.adicionarMensagens(null, FacesMessage.SEVERITY_ERROR, "Não foi possivel Excluir", "Erro: "+e.getMessage());
		}

	}

	public void excluir() {
		try {
			this.livrosList.remove(this.livroSelecionado);
			Mensagens.adicionarMensagens(null, FacesMessage.SEVERITY_INFO, "Excluido com Sucesso!",
					"Cadastro Excluido com Sucesso!");
			this.livro = new Livros();
			this.livroPesquisado=null;
		} catch (Exception e) {
			showDetail = true;
			Mensagens.adicionarMensagens(null, FacesMessage.SEVERITY_ERROR, "Erro: Não foi possivel excluir!",
					"Erro:" + e.getMessage());
			
		} finally {

		}

	}

	public void limpar() {
		this.livro = new Livros();
		this.livroPesquisado=null;
	}

	public void buscarLivros(ValueChangeEvent event) {
		this.livroPesquisado=event.getNewValue().toString().toLowerCase();
		System.out.println(this.livroPesquisado);
		this.livrosPesquisados.clear();
		for (Livros livros : livrosList) {
			if (!"".equalsIgnoreCase(livros.getTitulo()) && livros.getTitulo() != null
					&& livros.getTitulo().toLowerCase().startsWith(livroPesquisado)) {
				livrosPesquisados.add(livros);
			} 
		}
		this.livroPesquisado=null;
	}

	public void logarAcoes(ActionEvent event) {
		log.setDataEvento(new Date());
		log.setMetodo(event.getComponent().getId());
		log.setComponente(event.getComponent().toString());
		logsList.add(log);
		this.log = new Log();
		System.out.println(event.getComponent().getNamingContainer());
	}

	public String obterAjuda() {
		if (this.livrosList.isEmpty()) {
			return "/help/help?faces-redirect=true";
		} else {
			return "/help/help_phone?faces-redirect=true";
		}

	}

	private void adicionarMensagens(String clientId, Severity severity, String summary, String detail) {
		FacesContext context = FacesContext.getCurrentInstance();
		FacesMessage message = new FacesMessage(severity, summary, detail);
		context.addMessage(clientId, message);

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

	public Livros getLivroSelecionado() {
		return livroSelecionado;
	}

	public void setLivroSelecionado(Livros livroSelecionado) {
		this.livroSelecionado = livroSelecionado;
	}

	public String getLivroPesquisado() {
		return livroPesquisado;
	}

	public void setLivroPesquisado(String livroPesquisado) {
		this.livroPesquisado = livroPesquisado;
	}

	public Log getLog() {
		return log;
	}

	public void setLog(Log log) {
		this.log = log;
	}

	public List<Livros> getLivrosList() {
		return livrosList;
	}

	public void setLivrosList(List<Livros> livrosList) {
		this.livrosList = livrosList;
	}

	public List<Log> getLogsList() {
		return logsList;
	}

	public void setLogsList(List<Log> logsList) {
		this.logsList = logsList;
	}

	public List<Livros> getLivrosPesquisados() {
		return livrosPesquisados;
	}

	public void setLivrosPesquisados(List<Livros> livrosPesquisados) {
		this.livrosPesquisados = livrosPesquisados;
	}

	/**
	 * @return the showDetail
	 */
	public boolean isShowDetail() {
		return showDetail;
	}

	/**
	 * @param showDetail
	 *            the showDetail to set
	 */
	public void setShowDetail(boolean showDetail) {
		this.showDetail = showDetail;
	}

}
