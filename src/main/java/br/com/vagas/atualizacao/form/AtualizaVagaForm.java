package br.com.vagas.atualizacao.form;

import br.com.vagas.model.Vaga;
import br.com.vagas.repository.VagaRepository;

public class AtualizaVagaForm {

	private String tokenId;
	private String apresentacaoDaEmpresa;
	private String nomeVaga;
	private String nivelDaVaga;
	private String skill;
	private String localidadeDeTrabalho;
	private String linkVaga;

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

	public Vaga atualizar(Long id, VagaRepository repo) {
		Vaga vaga = repo.getOne(id);
		vaga.setApresentacaoDaEmpresa(this.apresentacaoDaEmpresa);
		vaga.setLinkVaga(this.linkVaga);
		vaga.setLocalidadeDeTrabalho(this.localidadeDeTrabalho);
		vaga.setNivelDaVaga(this.nivelDaVaga);
		vaga.setNomeVaga(this.nomeVaga);
		vaga.setSkill(this.skill);
		vaga.setTokenId(this.tokenId);

		return vaga;
	}

}
