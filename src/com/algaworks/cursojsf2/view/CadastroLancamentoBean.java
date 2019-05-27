package com.algaworks.cursojsf2.view;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.application.FacesMessage.Severity;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import org.hibernate.Session;
import org.hibernate.criterion.Order;

import com.algaworks.cursojsf2.model.Lancamentos;
import com.algaworks.cursojsf2.model.Pessoas;
import com.algaworks.cursojsf2.model.TipoLancamento;
import com.algaworks.cursojsf2.service.GestaoPessoas;
import com.algaworks.cursojsf2.util.HibernateUtil;

//Anotações Bean do pacote javax.faces
@ManagedBean
@ViewScoped

//Controle de tela
public class CadastroLancamentoBean implements Serializable {

	private static final long serialVersionUID = 1L;
	private Lancamentos lancamento;// variavel que preenche o lançamento
	private GestaoPessoas gestaoPessoas;
	private List<Lancamentos> lancamentos;
	private List<Pessoas> pessoas;
	private FacesMessage message;
	private FacesContext context;

	public CadastroLancamentoBean() {
		lancamento = new Lancamentos();
		gestaoPessoas = new GestaoPessoas();
		lancamentos = new ArrayList<Lancamentos>();
	}

	@SuppressWarnings("unchecked")
	@PostConstruct
	private void init() {  
       Session session = HibernateUtil.getSession();		   
       this.pessoas=session.createCriteria(Pessoas.class).addOrder(Order.asc("nome")).list();
       session.close();     
    		   
	}

	// Retorna arrays de enu
	public TipoLancamento[] getTipoLancamentos() {
		return TipoLancamento.values();

	}

	// variavel que receberá os valores de cada lançamento / objeto lancamento
	public Lancamentos getLancamento() {
		return lancamento;
	}

	// variavel para trazer a lista de pessoas
	public List<Pessoas> getGestaoPessoas() {
		return gestaoPessoas.listarPessoas();
	}

	// variavel para trazer a lista de lancamentos ArrayList
	public List<Lancamentos> getLancamentos() {
		return lancamentos;
	}

	public void gravar() {
		try {
			lancamentos.add(lancamento);
			gerarMensagens(null, FacesMessage.SEVERITY_INFO, "Inserido com Sucesso!",
					"Inserido com Sucesso o Lançamento!");
			lancamento = new Lancamentos();
		} catch (Exception e) {
			e.getMessage();
		}
	}

	private void gerarMensagens(String clientId, Severity severity, String summary, String detail) {
		context = FacesContext.getCurrentInstance();// traz o estado de cada requisição;
		message = new FacesMessage(severity, summary, detail);// Classe que trata as mensagens de erros
		context.addMessage(clientId, message);
	}

}
