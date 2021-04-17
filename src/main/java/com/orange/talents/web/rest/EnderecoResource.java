package com.orange.talents.web.rest;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.orange.talents.domain.model.Endereco;
import com.orange.talents.domain.repository.EnderecoRepository;

/**
 * CONTROLADOR REST ENDERECO 
 */
@RestController
@RequestMapping("/api")
public class EnderecoResource {	
	
	@Autowired
	private EnderecoRepository enderecoRepository;
	
	@PostMapping("/endereco")
	@ResponseStatus(HttpStatus.CREATED)
	public Endereco criaEndereco(@Valid @RequestBody Endereco endereco) {		
		return enderecoRepository.save(endereco);
	}

}
