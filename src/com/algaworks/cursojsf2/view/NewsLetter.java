package com.algaworks.cursojsf2.view;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.event.ActionEvent;

@ManagedBean(name = "nwslet")
@SessionScoped
public class NewsLetter implements Serializable {

	private static final long serialVersionUID = 1L;
	private String email;
	private List<String> listMail;
	private Log logs;
	private List<Log> listLogs;
	private String sucesso;

	public NewsLetter() {
		listMail = new ArrayList<String>();
		logs = new Log();
		listLogs = new ArrayList<Log>();
	}

	public void inserir() {
		try {
			this.listMail.add(this.email);
			this.logs = new Log();
			sucesso = "Sim";
		} catch (Exception e) {
			sucesso = "Nao";
		}

	}

	public void limpar() {
		this.email = null;
		this.logs = new Log();
	}

	public void logar(ActionEvent event) {
		logs.setComponente(event.getComponent().toString());
		logs.setDataEvento(new Date());
		logs.setMetodo(event.getComponent().getId());
		listLogs.add(logs);
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public List<String> getListMail() {
		return listMail;
	}

	public void setListMail(List<String> listMail) {
		this.listMail = listMail;
	}

	public Log getLogs() {
		return logs;
	}

	public void setLogs(Log logs) {
		this.logs = logs;
	}

	public List<Log> getListLogs() {
		return listLogs;
	}

	public void setListLogs(List<Log> listLogs) {
		this.listLogs = listLogs;
	}

	public String getSucesso() {
		return sucesso;
	}

	public void setSucesso(String sucesso) {
		this.sucesso = sucesso;
	}

}
