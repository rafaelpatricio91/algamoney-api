package com.rafa.algamoney.api.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rafa.algamoney.api.model.Lancamento;
import com.rafa.algamoney.api.model.Pessoa;
import com.rafa.algamoney.api.repository.LancamentoRepository;
import com.rafa.algamoney.api.repository.PessoaRepository;
import com.rafa.algamoney.api.service.exception.PessoaInexistenteOuInativaException;

@Service
public class LancamentoService {
	
	@Autowired
	private LancamentoRepository lancamentos;
	@Autowired
	private PessoaRepository pessoas;
	
	public Lancamento salvar(Lancamento lancamento) {
		
		Pessoa pessoa = pessoas.findOne(lancamento.getPessoa().getCodigo() );
		
		if (pessoa == null || pessoa.isInativo()) {
			throw new PessoaInexistenteOuInativaException();
		}
		 
		return lancamentos.save(lancamento);
	}

}
