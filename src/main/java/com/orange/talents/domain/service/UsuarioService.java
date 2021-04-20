package com.orange.talents.domain.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.orange.talents.domain.model.Usuario;
import com.orange.talents.domain.repository.UsuarioRepository;
import com.orange.talents.exception.DomainException;

@Service
public class UsuarioService {
	
	@Autowired
	private UsuarioRepository usuarioRepository;
	
	public Usuario criar(Usuario usuario) {
		
		if (usuarioRepository.findByEmail(usuario.getEmail()).isPresent()) {
			throw new DomainException("email já existe");
		}
		
		if(usuarioRepository.findByCpf(usuario.getCpf()).isPresent()) {
			throw new DomainException("CPF já existe");
		}			
		
		return usuarioRepository.save(usuario);
	}	
	
	public Usuario buscaDadosUsuario(String cpf) {	
		
		var usuario = usuarioRepository.findByCpf(cpf);
		
		if(usuario.isPresent()) {
			return usuario.get();
		}else {
			throw new DomainException("Nenhum usuário encontrado com este CPF");
		}		
		
	}
	
	

}
