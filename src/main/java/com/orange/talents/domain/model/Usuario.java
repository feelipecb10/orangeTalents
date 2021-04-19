package com.orange.talents.domain.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
/**
 * TABELA USUARIO.
 */

@Entity
@Table(uniqueConstraints={@UniqueConstraint(columnNames={"email","cpf"})})
public class Usuario {	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;	
	
	@NotBlank
	@Size(max = 255)
	@Column(name = "nome")
	private String nome;
	
	@NotBlank
	@Email(message="Email inserido não é válido")
	@Size(max = 100)
	@Column(name = "email")
	private String email;
	
	@NotBlank
	@Size(max = 11)
	@Column(name = "cpf")
	private String cpf;	
	
	@NotNull
	@Column(name = "data_nascimento")
	private Date data_nascimento;
	
	@OneToMany(mappedBy = "usuario")
	private List<Endereco> lista_enderecos = new ArrayList<>();

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public Date getData_nascimento() {
		return data_nascimento;
	}

	public void setData_nascimento(Date data_nascimento) {
		this.data_nascimento = data_nascimento;
	}
	
	

	public List<Endereco> getLista_enderecos() {
		return lista_enderecos;
	}

	public void setLista_enderecos(List<Endereco> lista_enderecos) {
		this.lista_enderecos = lista_enderecos;
	}

	@Override
	public String toString() {
		return "Usuario [id=" + id + ", nome=" + nome + ", email=" + email + ", cpf=" + cpf + ", data_nascimento="
				+ data_nascimento + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Usuario other = (Usuario) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
}
