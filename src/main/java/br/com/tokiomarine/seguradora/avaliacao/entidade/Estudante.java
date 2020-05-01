package br.com.tokiomarine.seguradora.avaliacao.entidade;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@SuppressWarnings("serial")
@Getter
@Setter
@EqualsAndHashCode
@Entity
@Table(name = "estudante")
public class Estudante implements Serializable {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotBlank(message = "O nome não pode ser vazio!")
	@Size(max = 80, message = "O nome é muito grande!")
	private String nome;
	
	@NotBlank(message = "O e-mail não pode ser vazio!")
	@Size(max = 60, message = "O e-mail é muito grande!")
	@Email(message = "O e-mail é inválido")
	private String email;
	
	private String telefone;
	
	@NotNull(message = "A matrícula é um campo obrigatório!")
	@Column(length = 6, nullable = false)
	private Long matricula;
	
	@Size(max = 80, message = "O curso é muito grande!")
	private String curso;
	
}
