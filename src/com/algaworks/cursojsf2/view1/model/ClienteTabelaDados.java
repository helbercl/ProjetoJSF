package com.algaworks.cursojsf2.view1.model;

public class ClienteTabelaDados {
  private Integer codigo;
  private String nome;
  private String cidade;
  
  public ClienteTabelaDados(Integer codigo,String nome,String cidade) {
	this.codigo=codigo;
	this.cidade=cidade;
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

public String getCidade() {
	return cidade;
}

public void setCidade(String cidade) {
	this.cidade = cidade;
}
  
}
