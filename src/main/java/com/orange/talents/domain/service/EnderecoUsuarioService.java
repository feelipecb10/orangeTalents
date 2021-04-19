package com.orange.talents.domain.service;

import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.orange.talents.api.model.EnderecoViaCepModel;
import com.orange.talents.domain.model.Endereco;
import com.orange.talents.domain.model.Usuario;
import com.orange.talents.domain.repository.EnderecoRepository;
import com.orange.talents.domain.repository.UsuarioRepository;
import com.orange.talents.integracao.cep.CepService;

@Service
public class EnderecoUsuarioService {
	
	@Autowired
	private EnderecoRepository enderecoRepository;	
	
	@Autowired
	private UsuarioRepository usuarioRepository;
	
	@Autowired
	private CepService cepService;
	
	@Autowired
	private ModelMapper modelMapper;
	
	public ResponseEntity<Endereco> criar(Endereco endereco) {		
		
		EnderecoViaCepModel enderecoViaCep = cepService.getCep(endereco.getCep());
		
		endereco.setCidade(enderecoViaCep.getLocalidade());
		endereco.setBairro(enderecoViaCep.getBairro());
		endereco.setUf(enderecoViaCep.getUf());
		endereco.setComplemento(enderecoViaCep.getComplemento());
		endereco.setLogradouro(enderecoViaCep.getLogradouro());		
		
		Optional<Usuario> usuario = usuarioRepository.findById(endereco.getUsuario().getId());
		
		if(usuario.isPresent()) {
			endereco.setUsuario(usuario.get());
		}else {
			return ResponseEntity.status(400).build();
		}
		
		return ResponseEntity.status(201).body(enderecoRepository.save(endereco));
	}
}
