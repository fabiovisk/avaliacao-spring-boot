package br.com.tokiomarine.seguradora.avaliacao.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class EstudanteResource {
	
	@JsonProperty("nome")
	private String nome;
	
	@JsonProperty("email")
	private String email;
	
	@JsonProperty("telefone")
	private String telefone;
	
	@JsonProperty("matricula")
	private String matricula;

	@JsonProperty("curso")
	private String curso;

	public EstudanteResource() {
		super();
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getCurso() {
		return curso;
	}

	public void setCurso(String curso) {
		this.curso = curso;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getMatricula() {
		return matricula;
	}

	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}

	@Override
	public String toString() {
		return "EstudanteResource [nome=" + nome + ", matricula=" + matricula + ", telefone=" + telefone + ", curso="
				+ curso + ", email=" + email + "]";
	}
	
}
