package com.orange.talents.api.model;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.orange.talents.domain.model.Usuario;

public class EnderecoInput {
	
	@NotBlank
	@Size(max = 10)
	private String cep;	
	
	@NotNull	
	private int numero;	
	
	@Size(max = 100)	
	private String logradouro;	
	
	@Size(max = 100)	
	private String complemento;	
	
	@Size(max = 50)	
	private String bairro;	
	
	@Size(max = 50)	
	private String cidade;	
	
	@Size(max = 2)	
	private String uf;
	
	@NotNull
	private Usuario usuario;

	public String getLogradouro() {
		return logradouro;
	}

	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public String getComplemento() {
		return complemento;
	}

	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String getUf() {
		return uf;
	}

	public void setUf(String uf) {
		this.uf = uf;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	@Override
	public String toString() {
		return "EnderecoInput [cep=" + cep + ", numero=" + numero + ", logradouro=" + logradouro + ", complemento="
				+ complemento + ", bairro=" + bairro + ", cidade=" + cidade + ", uf=" + uf + ", usuario=" + usuario
				+ "]";
	}
	
	
}
