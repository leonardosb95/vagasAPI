package br.com.vagas.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class PerfilLinkedin {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String perfilLinkedin;
	
	@OneToOne
	private Candidato candidato;

	public PerfilLinkedin() {

	}

	public PerfilLinkedin(String perfilLinkedin) {
		this.perfilLinkedin = perfilLinkedin;
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
		PerfilLinkedin other = (PerfilLinkedin) obj;
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

	public String getPerfilLinkedin() {
		return perfilLinkedin;
	}

	public void setPerfilLinkedin(String perfilLinkedin) {
		this.perfilLinkedin = perfilLinkedin;
	}

	public Candidato getCandidato() {
		return candidato;
	}

	public void setCandidato(Candidato candidato) {
		this.candidato = candidato;
	}
	

}
