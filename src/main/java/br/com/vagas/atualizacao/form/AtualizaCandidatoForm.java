package br.com.vagas.atualizacao.form;

import br.com.vagas.model.Candidato;
import br.com.vagas.repository.CandidatoRepository;

public class AtualizaCandidatoForm {

	private String nickName;
	private String cpf;
	private String nomeCompleto;
	private String email;
	private String celular;
	private String skillCandidato;
	private String localDeTrabalho;

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

	public Candidato atualizar(Long id, CandidatoRepository repo) {
		Candidato candidato = repo.getOne(id);
		candidato.setCelular(this.celular);
		candidato.setCpf(this.cpf);
		candidato.setEmail(this.email);
		candidato.setLocalDeTrabalho(this.localDeTrabalho);
		candidato.setNickName(this.nickName);
		candidato.setNomeCompleto(this.nomeCompleto);
		candidato.setSkillCandidato(this.skillCandidato);

		return candidato;
	}

}
