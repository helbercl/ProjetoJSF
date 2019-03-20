package com.algaworks.cursojsf2.view;

import java.io.Serializable;
import java.util.Calendar;

import javax.faces.application.FacesMessage;
import javax.faces.application.FacesMessage.Severity;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

@ManagedBean(name = "formularioMensagem")
@SessionScoped
public class FormularioMensagensBean implements Serializable {

	private static final long serialVersionUID = 1L;

	private String nome;
	private String mail;
	private String senha;

	public void cadastrar() {
		if (this.getNome() == "" || this.getNome() == null || this.getNome().length() < 10) {
			this.adicionarMensagem("frm_tabelas:opl_nome", FacesMessage.SEVERITY_ERROR, "Nome Incompleto",
					"Favor informar seu nome completo.");
		}
		if (this.hojeDiaDescanso()) {
			this.adicionarMensagem(null, FacesMessage.SEVERITY_WARN, "Hoje é dia de descanso.",
					"Não pode trabalahr nesshar nesse dia");
		}
	}

	private boolean hojeDiaDescanso() {
		boolean isHolliday = Calendar.getInstance().get(Calendar.DAY_OF_WEEK) == (Calendar.SATURDAY)
				|| Calendar.getInstance().get(Calendar.DAY_OF_WEEK) == (Calendar.SUNDAY);
		return isHolliday;
	}

	private void adicionarMensagem(String clientId, Severity severity, String summary, String detail) {
       FacesContext context = FacesContext.getCurrentInstance();//Objeto que contem o estado de cada requisição.
       FacesMessage message = new FacesMessage(severity,summary,detail);
       context.addMessage(clientId, message);
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

}
