package com.orange.talents.api.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.orange.talents.api.model.EnderecoInput;
import com.orange.talents.domain.model.Endereco;
import com.orange.talents.domain.service.EnderecoService;

/**
 * CONTROLADOR REST ENDERECO 
 */
@RestController
@RequestMapping("/endereco")
public class EnderecoResource {	
	
	@Autowired
	private EnderecoService enderecoUsuarioService;
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public ResponseEntity<Endereco> criaEndereco(@Valid @RequestBody EnderecoInput enderecoInput) {		
		return enderecoUsuarioService.criar(enderecoInput);
	}

}
