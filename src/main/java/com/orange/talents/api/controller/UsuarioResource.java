package com.orange.talents.api.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import com.orange.talents.domain.model.Usuario;
import com.orange.talents.domain.service.UsuarioService;


/**
 * CONTROLADOR REST USUARIO 
 */
@RestController
@RequestMapping("/api")
public class UsuarioResource {	
	
	@Autowired
	private UsuarioService usuarioService;
	
	@PostMapping("/usuario")
	@ResponseStatus(HttpStatus.CREATED)
	public Usuario criaUsuario(@Valid @RequestBody Usuario usuario) {		
		return usuarioService.criar(usuario);
	}
	
	@GetMapping("/busca-usuario/{usuario_id}")
	public Usuario buscaDadosUsuario(@PathVariable Long usuario_id){
		return usuarioService.buscaDadosUsuario(usuario_id);
	}

}
