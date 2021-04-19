package com.orange.talents.domain.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.orange.talents.domain.model.Usuario;
import com.orange.talents.domain.repository.UsuarioRepository;

@Service
public class UsuarioService {
	
	@Autowired
	private UsuarioRepository usuarioRepository;
	
	public Usuario criar(Usuario usuario) {
		
		/*Usuario emailExistente = usuarioRepository.findByEmail(usuario.getEmail());
		Usuario cpfExistente = usuarioRepository.findByCpf(usuario.getCpf());*/
		
		/*if(emailExistente != null || cpfExistente!= null) {
			
		}*/
		
		return usuarioRepository.save(usuario);
	}	
	
	public Usuario buscaDadosUsuario(String cpf) {		
		return usuarioRepository.findByCpf(cpf);
	}
	
	

}
