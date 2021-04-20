package com.orange.talents.domain.service;

import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.orange.talents.api.model.EnderecoInput;
import com.orange.talents.domain.model.Endereco;
import com.orange.talents.domain.model.Usuario;
import com.orange.talents.domain.repository.EnderecoRepository;
import com.orange.talents.domain.repository.UsuarioRepository;
import com.orange.talents.exception.DomainException;
import com.orange.talents.integration.cep.CepService;

@Service
public class EnderecoService {
	
	@Autowired
	private EnderecoRepository enderecoRepository;	
	
	@Autowired
	private UsuarioRepository usuarioRepository;
	
	@Autowired
	private CepService cepService;
	
	@Autowired
	private ModelMapper modelMapper;
	
	public ResponseEntity<Endereco> criar(EnderecoInput enderecoInput) {	
		
		var viaCep = cepService.getCep(enderecoInput.getCep());
		
		Endereco endereco = modelMapper.map(viaCep, Endereco.class);			
		endereco.setNumero(enderecoInput.getNumero());
		endereco.setComplemento(enderecoInput.getComplemento());
		endereco.setCidade(viaCep.getLocalidade());	
		
		Optional<Usuario> usuario = usuarioRepository.findById(enderecoInput.getUsuario().getId());
		
		if(usuario.isPresent()) {
			endereco.setUsuario(usuario.get());
		}else {
			throw new DomainException("é necessário informar um usuário existente");
		}
		
		return ResponseEntity.status(201).body(enderecoRepository.save(endereco));
	}
}
