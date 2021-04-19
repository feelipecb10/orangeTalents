package com.orange.talents.domain.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.orange.talents.domain.model.Endereco;
import com.orange.talents.domain.model.Usuario;
import com.orange.talents.domain.repository.EnderecoRepository;
import com.orange.talents.domain.repository.UsuarioRepository;

@Service
public class EnderecoUsuarioService {
	
	@Autowired
	private EnderecoRepository enderecoRepository;	
	
	@Autowired
	private UsuarioRepository usuarioRepository;
	
	public ResponseEntity<Endereco> criar(Endereco endereco) {
		
		Optional<Usuario> usuario = usuarioRepository.findById(endereco.getUsuario().getId());
		
		if(usuario.isPresent()) {
			endereco.setUsuario(usuario.get());
		}else {
			return ResponseEntity.status(400).build();
		}
		
		return ResponseEntity.status(201).body(enderecoRepository.save(endereco));
	}
}
