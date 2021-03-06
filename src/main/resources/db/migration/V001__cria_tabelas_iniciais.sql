CREATE TABLE usuario(
	id BIGINT NOT NULL AUTO_INCREMENT PRIMARY KEY,
	nome VARCHAR(255) NOT NULL,
	email VARCHAR(100) NOT NULL,
	cpf VARCHAR(11) NOT NULL,
	data_nascimento DATE,
	UNIQUE KEY uk_usuario_email(email),
	UNIQUE KEY uk_usuario_cpf(cpf)
);

CREATE TABLE endereco(
	id BIGINT NOT NULL AUTO_INCREMENT PRIMARY KEY,	
	logradouro VARCHAR(100) NOT NULL,
	numero INT NOT NULL,
	complemento VARCHAR(100),
	bairro VARCHAR(50) NOT NULL,
	cidade VARCHAR(50) NOT NULL,
	uf CHAR(2) NOT NULL,
	cep VARCHAR(10),
	usuario_id BIGINT NOT NULL,
	CONSTRAINT fk_endereco_usuario FOREIGN KEY (usuario_id) REFERENCES usuario (id)
);