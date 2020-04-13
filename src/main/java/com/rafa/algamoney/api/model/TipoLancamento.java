package com.rafa.algamoney.api.model;

public enum TipoLancamento {

	RECEITA("Receita"), DESPESA("Despesa");
	
	private String descricao;

	public String getDescricao() {
		return descricao;
	}

	private TipoLancamento(String descricao) {
		this.descricao = descricao;
	}
}
