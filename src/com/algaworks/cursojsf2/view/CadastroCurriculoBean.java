package com.algaworks.cursojsf2.view;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

@ManagedBean(name="cadastroCurriculoBean")
@ViewScoped
public class CadastroCurriculoBean implements Serializable{

	private static final long serialVersionUID = 1L;
	private String vaga="A0382D";
	private String cargo="Programador Java Senior";
	private String mail ="helber@infox.com.br";
	
	public String getCargo() {
		return cargo;
	}
	
	public void setCargo(String cargo) {
		this.cargo = cargo;
	}
	
	public String getVaga() {
		return vaga;
	}
	
	public void setVaga(String vaga) {
		this.vaga = vaga;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

}
