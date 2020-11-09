package com.algaworks.cursojsf2.view;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;

@SuppressWarnings("deprecation")
@ManagedBean
public class ExercicioBean implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private int valor1,valor2,soma;
	
	public void somar() {
		this.setSoma(this.getValor1() + getValor2());		
	}

	public int getValor1() {
		return valor1;
	}

	public void setValor1(int valor1) {
		this.valor1 = valor1;
	}

	public int getValor2() {
		return valor2;
	}

	public void setValor2(int valor2) {
		this.valor2 = valor2;
	}

	public int getSoma() {
		return soma;
	}

	public void setSoma(int soma) {
		this.soma = soma;
	}
	

}
