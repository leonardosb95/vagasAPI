package br.com.vagas.controller.dto;

import org.springframework.data.domain.Page;

import br.com.vagas.model.PerfilLinkedin;

public class PerfilLinkedinDto {

	private Long id;
	private String perfilLinkedin;

	public PerfilLinkedinDto(PerfilLinkedin perfilLinkedin) {
		this.id = perfilLinkedin.getId();
		this.perfilLinkedin = perfilLinkedin.getPerfilLinkedin();

	}

	public String getPerfilLinkedin() {
		return perfilLinkedin;
	}

	public void setPerfilLinkedin(String perfilLinkedin) {
		this.perfilLinkedin = perfilLinkedin;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public static Page<PerfilLinkedinDto> converter(Page<PerfilLinkedin> perfis) {
		return perfis.map(PerfilLinkedinDto::new);
	}

}
