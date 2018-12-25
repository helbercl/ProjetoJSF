package com.algaworks.cursojsf2;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.component.html.HtmlCommandButton;
import javax.faces.component.html.HtmlInputSecret;
import javax.faces.component.html.HtmlInputText;
import javax.faces.component.html.HtmlPanelGrid;

//@ManagedBean(name="olamundo") configurado no arquivo xml faces-config para mostrar como funcionava anterioremente

public class OlaMundoBean implements Serializable {

	private static final long serialVersionUID = 1L;
	private String login;
	private String password;
	private String resposta = null;
	
	private HtmlInputText ipt_login;
	private HtmlInputSecret ipt_password;
	private HtmlCommandButton botao;

	public OlaMundoBean() {
		// TODO Auto-generated constructor stub
	}

	public void impress() {
		manipularComponentes();
		resposta = "OlaMundo para " + login + " com password " + password;
	}

//	public void calculate() {
//		Integer resultado = num1 + num2;
//		resposta = resultado.toString();
//	}

	public void clean() {
		login = null;
		password = null;
		resposta = null;
	}

	public void manipularComponentes() {
		if (this.ipt_login.isDisabled()
				&& this.ipt_password.isDisabled()) {
			this.botao.setStyle("");
			this.ipt_login.setDisabled(false);
			this.ipt_password.setDisabled(false);
		}else {
			this.ipt_login.setDisabled(true);
			this.ipt_password.setDisabled(true);
			this.botao.setStyle("background-color:red; color:white");
		}

		
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login.toUpperCase();
	}

	public String getResposta() {
		return resposta;
	}

	public void setResposta(String resposta) {
		this.resposta = resposta;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password.toUpperCase();
	}



	public HtmlCommandButton getBotao() {
		return botao;
	}

	public void setBotao(HtmlCommandButton botao) {
		this.botao = botao;
	}

	public HtmlInputText getIpt_login() {
		return ipt_login;
	}

	public void setIpt_login(HtmlInputText ipt_login) {
		this.ipt_login = ipt_login;
	}

	public HtmlInputSecret getIpt_password() {
		return ipt_password;
	}

	public void setIpt_password(HtmlInputSecret ipt_password) {
		this.ipt_password = ipt_password;
	}

}
