package br.com.vagas.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Vaga {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String tokenId;
	private String apresentacaoDaEmpresa;
	private String nomeVaga;
	private String nivelDaVaga;
	private String skill;
	private String localidadeDeTrabalho;
	private String linkVaga;
	
	
	
	public Vaga() {

	}

	
	public Vaga(String tokenId, String apresentacaoDaEmpresa, String nomeVaga, String nivelDaVaga, String skill,
			String localidadeDeTrabalho, String linkVaga) {
		this.tokenId = tokenId;
		this.apresentacaoDaEmpresa = apresentacaoDaEmpresa;
		this.nomeVaga = nomeVaga;
		this.nivelDaVaga = nivelDaVaga;
		this.skill = skill;
		this.localidadeDeTrabalho = localidadeDeTrabalho;
		this.linkVaga = linkVaga;
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
		Vaga other = (Vaga) obj;
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


	public String getTokenId() {
		return tokenId;
	}


	public void setTokenId(String tokenId) {
		this.tokenId = tokenId;
	}


	public String getApresentacaoDaEmpresa() {
		return apresentacaoDaEmpresa;
	}


	public void setApresentacaoDaEmpresa(String apresentacaoDaEmpresa) {
		this.apresentacaoDaEmpresa = apresentacaoDaEmpresa;
	}


	public String getNomeVaga() {
		return nomeVaga;
	}


	public void setNomeVaga(String nomeVaga) {
		this.nomeVaga = nomeVaga;
	}


	public String getNivelDaVaga() {
		return nivelDaVaga;
	}


	public void setNivelDaVaga(String nivelDaVaga) {
		this.nivelDaVaga = nivelDaVaga;
	}


	public String getSkill() {
		return skill;
	}


	public void setSkill(String skill) {
		this.skill = skill;
	}


	public String getLocalidadeDeTrabalho() {
		return localidadeDeTrabalho;
	}


	public void setLocalidadeDeTrabalho(String localidadeDeTrabalho) {
		this.localidadeDeTrabalho = localidadeDeTrabalho;
	}


	public String getLinkVaga() {
		return linkVaga;
	}


	public void setLinkVaga(String linkVaga) {
		this.linkVaga = linkVaga;
	}
	

	

}
