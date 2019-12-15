package br.com.vagas.controller.form;

import br.com.vagas.model.PerfilLinkedin;
import br.com.vagas.repository.PerfilLinkedinRepository;

public class PerfilLinkedinForm {

	private String perfilLinkedin;

	public String getPerfilLinkedin() {
		return perfilLinkedin;
	}

	public void setPerfilLinkedin(String perfilLinkedin) {
		this.perfilLinkedin = perfilLinkedin;
	}

	public PerfilLinkedin converter(PerfilLinkedinRepository repo) {
		return new PerfilLinkedin(perfilLinkedin);
	}

}
