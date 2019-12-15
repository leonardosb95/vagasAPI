package br.com.vagas.controller.dto;

import org.springframework.data.domain.Page;

import br.com.vagas.model.Vaga;

public class VagaDto {

	private Long id;
	private String tokenId;
	private String apresentacaoDaEmpresa;
	private String nomeVaga;
	private String nivelDaVaga;
	private String skill;
	private String localidadeDeTrabalho;
	private String linkVaga;

	public VagaDto(Vaga vaga) {
		this.id = vaga.getId();
		this.tokenId = vaga.getTokenId();
		this.apresentacaoDaEmpresa = vaga.getApresentacaoDaEmpresa();
		this.nomeVaga = vaga.getNomeVaga();
		this.nivelDaVaga = vaga.getNivelDaVaga();
		this.skill = vaga.getSkill();
		this.localidadeDeTrabalho = vaga.getLocalidadeDeTrabalho();
		this.linkVaga = vaga.getLinkVaga();
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

	public static Page<VagaDto> converter(Page<Vaga> vagas) {
		return vagas.map(VagaDto::new);
	}

}
