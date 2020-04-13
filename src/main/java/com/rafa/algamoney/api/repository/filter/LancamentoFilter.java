package com.rafa.algamoney.api.repository.filter;

import org.springframework.format.annotation.DateTimeFormat;

public class LancamentoFilter {
	
	private String descricao;
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private String dataVencimentoDe;
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private String dataVencimentoAte;
	
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public String getDataVencimentoDe() {
		return dataVencimentoDe;
	}
	public void setDataVencimentoDe(String dataVencimentoDe) {
		this.dataVencimentoDe = dataVencimentoDe;
	}
	public String getDataVencimentoAte() {
		return dataVencimentoAte;
	}
	public void setDataVencimentoAte(String dataVencimentoAte) {
		this.dataVencimentoAte = dataVencimentoAte;
	}
	
	

}
