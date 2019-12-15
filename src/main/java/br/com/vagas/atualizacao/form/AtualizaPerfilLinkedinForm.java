package br.com.vagas.atualizacao.form;

import br.com.vagas.model.PerfilLinkedin;
import br.com.vagas.repository.PerfilLinkedinRepository;

public class AtualizaPerfilLinkedinForm {

	private String perfilLinkedin;

	public String getPerfilLinkedin() {
		return perfilLinkedin;
	}

	public void setPerfilLinkedin(String perfilLinkedin) {
		this.perfilLinkedin = perfilLinkedin;
	}

	public PerfilLinkedin atualizar(Long id, PerfilLinkedinRepository repo) {
		PerfilLinkedin perfil = repo.getOne(id);
		perfil.setPerfilLinkedin(this.perfilLinkedin);

		return perfil;
	}

}
