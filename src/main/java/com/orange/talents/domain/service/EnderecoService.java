package com.orange.talents.domain.service;

import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.beans.BeanUtils;

import com.orange.talents.api.model.EnderecoInput;
import com.orange.talents.domain.model.Endereco;
import com.orange.talents.domain.model.Usuario;
import com.orange.talents.domain.repository.EnderecoRepository;
import com.orange.talents.domain.repository.UsuarioRepository;
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
		
		System.out.println("EnderecoInput: " +enderecoInput.toString());
		
		Endereco endereco = modelMapper.map(cepService.getCep(enderecoInput.getCep()), Endereco.class);	
		
		System.out.println("Endereco: " +endereco.toString());
		
		BeanUtils.copyProperties(endereco, enderecoInput);	
		
		System.out.println("EnderecoFinal: " +endereco.toString());
		
		Optional<Usuario> usuario = usuarioRepository.findById(endereco.getUsuario().getId());
		
		if(usuario.isPresent()) {
			endereco.setUsuario(usuario.get());
		}else {
			return ResponseEntity.status(400).build();
		}
		
		return ResponseEntity.status(201).body(enderecoRepository.save(endereco));
	}
}
