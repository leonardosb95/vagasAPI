package br.com.vagas.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Candidato {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String nickName;
	private String cpf;
	private String nomeCompleto;
	private String email;
	private String celular;
	private String skillCandidato;
	private String localDeTrabalho;
	
	@OneToOne(mappedBy = "candidato",cascade = {CascadeType.ALL})
	private PerfilLinkedin perfil;

	public Candidato() {

	}
	

	public Candidato(String nickName, String cpf, String nomeCompleto, String email, String celular,
			String skillCandidato, String localDeTrabalho) {
		this.nickName = nickName;
		this.cpf = cpf;
		this.nomeCompleto = nomeCompleto;
		this.email = email;
		this.celular = celular;
		this.skillCandidato = skillCandidato;
		this.localDeTrabalho = localDeTrabalho;
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
		Candidato other = (Candidato) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
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

}
