package com.algaworks.cursojsf2.view;

import java.io.Serializable;
import java.util.Calendar;

import javax.faces.application.FacesMessage;
import javax.faces.application.FacesMessage.Severity;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

@ManagedBean(name = "formularioMensagem")
@ViewScoped
public class FormularioMensagensBean implements Serializable {

	private static final long serialVersionUID = 1L;

	private String nome;
	private String mail;
	private String senha;
	private boolean ignoreDescanso;

	public void cadastrar() {
		if (this.hojeDiaDescanso() && !this.ignoreDescanso) {
			// clientID é null quando o controle não tem componente na tela- mensagem
			// global.
			this.adicionarMensagem(null, FacesMessage.SEVERITY_WARN, "Hoje é dia de descanso.",
					"Não pode trabalhar nesse dia!");
		} else {
			if (this.getNome() == "" || this.getNome() == null || this.getNome().length() < 10) {
				this.adicionarMensagem("frm_mensagens:ipt_nome", FacesMessage.SEVERITY_ERROR, "Nome Incompleto!",
						"Favor informar seu nome completo!.");
			} else if ("".equals(this.getMail()) || this.getMail() == null) {
				this.adicionarMensagem("frm_mensagens:ipt_mail", FacesMessage.SEVERITY_ERROR, "E-mail Não informado!",
						"Favor informar seu e-mail!");
			} else if ("".equals(this.getSenha()) | this.getSenha() == null || this.getSenha().length() < 6) {
				this.adicionarMensagem("frm_mensagens:ips_senha", FacesMessage.SEVERITY_ERROR, "Senha Não Informada!",
						"Favor informar a senha !");
			}
		}
		FacesContext context = FacesContext.getCurrentInstance();
		if (!context.getMessages().hasNext()) {
			this.adicionarMensagem(null, FacesMessage.SEVERITY_INFO, "Inserido com Sucesso",
					"Dados Inseridos com Sucesso!");
		}
	}

	private boolean hojeDiaDescanso() {
		boolean isHolliday = Calendar.getInstance().get(Calendar.DAY_OF_WEEK) == (Calendar.THURSDAY)
				|| Calendar.getInstance().get(Calendar.DAY_OF_WEEK) == (Calendar.SUNDAY);
		return isHolliday;
	}

	private void adicionarMensagem(String clientId, Severity severity, String summary, String detail) {
		/*
		 * clientId - Id do componente ; severity tipos de nivel mensagem (error,warn
		 * etc...) , summary breve descrição e detail - detalhe do erro(mais
		 * explicativa)
		 */
		FacesContext context = FacesContext.getCurrentInstance(); // Objeto que contem o estado de cada requisição.
		FacesMessage message = new FacesMessage(severity, summary, detail);
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

	public boolean isIgnoreDescanso() {
		return ignoreDescanso;
	}

	public void setIgnoreDescanso(boolean ignoreDescanso) {
		this.ignoreDescanso = ignoreDescanso;
	}

}
