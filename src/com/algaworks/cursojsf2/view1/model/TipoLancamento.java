package com.algaworks.cursojsf2.view1.model;

public enum TipoLancamento {

	RECEITA("Receita"), DESPESA("Despesa");

	private String descricao;
    //construtor
	private TipoLancamento(String descricao) {
		this.descricao = descricao;
	}
	public String getDescricao() {
		return descricao;
	}

}
