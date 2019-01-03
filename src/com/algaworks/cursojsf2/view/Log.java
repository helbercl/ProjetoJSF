package com.algaworks.cursojsf2.view;

import java.io.Serializable;
import java.util.Date;

public class Log implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String metodo;
	private Date dataEvento;

	public String getMetodo() {
		return metodo;
	}
	public void setMetodo(String metodo) {
		this.metodo = metodo;
	}
	public Date getDataEvento() {
		return dataEvento;
	}
	public void setDataEvento(Date dataEvento) {
		this.dataEvento = dataEvento;
	}

}
