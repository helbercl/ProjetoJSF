package com.algaworks.cursojsf2.model;

public enum TipoLancamento {

	RECEITA("Receita"), DESPESA("Despesa"),INVESTIMENTO("Investimento");

	private String descricao;
    //construtor
	private TipoLancamento(String descricao) {
		this.descricao = descricao;
	}
	public String getDescricao() {
		return descricao;
	}

}
