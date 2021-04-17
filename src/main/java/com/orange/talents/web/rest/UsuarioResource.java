package com.orange.talents.web.rest;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.orange.talents.domain.model.Usuario;
import com.orange.talents.domain.repository.UsuarioRepository;


/**
 * CONTROLADOR REST USUARIO 
 */
@RestController
@RequestMapping("/api")
public class UsuarioResource {	
	
	@Autowired
	private UsuarioRepository usuarioRepository;
	
	@PostMapping("/usuario")
	@ResponseStatus(HttpStatus.CREATED)
	public Usuario criaUsuario(@Valid @RequestBody Usuario usuario) {
		
		Usuario emailExistente = usuarioRepository.findByEmail(usuario.getEmail());
		Usuario cpfExistente = usuarioRepository.findByCpf(usuario.getCpf());
		
		if(emailExistente != null || cpfExistente!= null) {
			
		}
		
		return usuarioRepository.save(usuario);
	}

}