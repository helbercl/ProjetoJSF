package com.algaworks.cursojsf2.model;

import java.io.Serializable;

public class Produto implements Serializable {
private String nome;
private String Fabricante;
private String categoria;

public String getNome() {
	return nome;
}
public void setNome(String nome) {
	this.nome = nome;
}
public String getFabricante() {
	return Fabricante;
}
public void setFabricante(String fabricante) {
	Fabricante = fabricante;
}
public String getCategoria() {
	return categoria;
}
public void setCategoria(String categoria) {
	this.categoria = categoria;
}
}
