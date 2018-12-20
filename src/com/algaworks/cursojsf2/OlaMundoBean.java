package com.algaworks.cursojsf2;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;

@ManagedBean(name="olamundo")
public class OlaMundoBean implements Serializable{

	private static final long serialVersionUID = 1L;
	private String name;
	private String resposta=null;
	
	public OlaMundoBean() {
		// TODO Auto-generated constructor stub
	}

	public String impress() {	
		resposta= "OlaMundo para " + name;
		return resposta.toString() ;
		
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name.toUpperCase();
	}

	public String getResposta() {
		return resposta;
	}

	public void setResposta(String resposta) {
		this.resposta = resposta;
	}
	
	



}
