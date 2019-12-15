package br.com.vagas.controller.form;

import br.com.vagas.model.Vaga;
import br.com.vagas.repository.VagaRepository;

public class VagaForm {

	private String nomeEmpresa;
	private String apresentacaoDaEmpresa;
	private String nomeVaga;
	private String nivelDaVaga;
	private String skill;
	private String localidadeDeTrabalho;
	private String linkVaga;

	public String getNomeEmpresa() {
		return nomeEmpresa;
	}

	public void setNomeEmpresa(String nomeEmpresa) {
		this.nomeEmpresa = nomeEmpresa;
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

	public Vaga converter(VagaRepository repo) {
		return new Vaga(nomeEmpresa, apresentacaoDaEmpresa, nomeVaga, nivelDaVaga, skill, localidadeDeTrabalho, linkVaga);
	}

}
