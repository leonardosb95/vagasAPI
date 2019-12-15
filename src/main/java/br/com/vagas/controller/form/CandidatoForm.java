package br.com.vagas.controller.form;

import br.com.vagas.model.Candidato;
import br.com.vagas.repository.CandidatoRepository;

public class CandidatoForm {

	private String nickName;
	private String cpf;
	private String nomeCompleto;
	private String email;
	private String celular;
	private String skillCandidato;
	private String localDeTrabalho;
	private String perfilLinkedin;

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getNickName() {
		return nickName;
	}

	public void setNickName(String nickName) {
		this.nickName = nickName;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getNomeCompleto() {
		return nomeCompleto;
	}

	public void setNomeCompleto(String nomeCompleto) {
		this.nomeCompleto = nomeCompleto;
	}

	public String getCelular() {
		return celular;
	}

	public void setCelular(String celular) {
		this.celular = celular;
	}

	public String getSkillCandidato() {
		return skillCandidato;
	}

	public void setSkillCandidato(String skillCandidato) {
		this.skillCandidato = skillCandidato;
	}

	public String getLocalDeTrabalho() {
		return localDeTrabalho;
	}

	public void setLocalDeTrabalho(String localDeTrabalho) {
		this.localDeTrabalho = localDeTrabalho;
	}

	public Candidato converter(CandidatoRepository repo) {
		return new Candidato(nickName, cpf, nomeCompleto,  email,celular,skillCandidato, localDeTrabalho,perfilLinkedin);
	}

}
