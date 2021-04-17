package com.orange.talents.domain.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.orange.talents.domain.model.Endereco;
import com.orange.talents.domain.repository.EnderecoRepository;

@Service
public class EnderecoUsuarioService {
	
	@Autowired
	private EnderecoRepository enderecoRepository;	
	
	public Endereco criar(Endereco endereco) {
		return enderecoRepository.save(endereco);
	}

}
