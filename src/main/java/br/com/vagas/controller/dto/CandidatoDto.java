package br.com.vagas.controller.dto;

import org.springframework.data.domain.Page;

import br.com.vagas.model.Candidato;

public class CandidatoDto {

	private Long id;
	private String nickName;
	private String cpf;
	private String nomeCompleto;
	private String email;
	private String celular;
	private String skillCandidato;
	private String localDeTrabalho;

	private int contSkills = 0;

	public CandidatoDto(Candidato candidato) {
		this.id = candidato.getId();
		this.nickName = candidato.getNickName();
		this.cpf = candidato.getCpf();
		this.nomeCompleto = candidato.getNomeCompleto();
		this.email = candidato.getEmail();
		this.celular = candidato.getCelular();
		this.skillCandidato = candidato.getSkillCandidato();
		this.localDeTrabalho = candidato.getLocalDeTrabalho();
	}

	public int getContSkills() {
		return contSkills;
	}

	public void setContSkills(int contSkills) {
		this.contSkills = contSkills;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public static Page<CandidatoDto> converter(Page<Candidato> candidatos) {
		return candidatos.map(CandidatoDto::new);
	}

}
