package com.algaworks.cursojsf2.view1.model;
public class Pessoa {
	
	private Integer codigo;
	private String nome;
	
	public Pessoa() {
		// TODO Auto-generated constructor stub
	}
	
	public Pessoa(Integer codigo,String nome) {
		this.codigo=codigo;
		this.nome=nome;
	}
	
	public Integer getCodigo() {
		return codigo;
	}
	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
 
}
