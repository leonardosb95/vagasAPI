package br.com.vagas.controller;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import br.com.vagas.atualizacao.form.AtualizaCandidatoForm;
import br.com.vagas.controller.dto.CandidatoDto;
import br.com.vagas.controller.dto.VagaDto;
import br.com.vagas.controller.form.CandidatoForm;
import br.com.vagas.controller.form.VagaForm;
import br.com.vagas.model.Candidato;
import br.com.vagas.model.Vaga;
import br.com.vagas.repository.CandidatoRepository;
import br.com.vagas.repository.VagaRepository;
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping("/candidato")
public class CandidatoController {

	@Autowired
	private CandidatoRepository candidatoRepository;
	
	@Autowired 
	VagaRepository vagaRepository;

	@GetMapping
	@Cacheable(value = "listaDeCandidatos")
	public Page<CandidatoDto> lista(@RequestParam(required = false) String candidato,
			@PageableDefault(sort = "id", direction = Direction.DESC, page = 0, size = 10) Pageable paginacao) {

		if (candidato == null) {
			Page<Candidato> candidatos = candidatoRepository.findAll(paginacao);
			return CandidatoDto.converter(candidatos);
		} else {
			Page<Candidato> candidatos = candidatoRepository.findByNomeCompleto(candidato, paginacao);
			return CandidatoDto.converter(candidatos);
		}
	}

	@GetMapping("/skills")
	public List<Candidato> buscaSkills(){
		List<Vaga> vagas =vagaRepository.findAll();
		List<Candidato> candidatos=candidatoRepository.findAll();
		
		
		
		
		int cont=0;
		for (int i = 0; i < vagas.size(); i++) {
			
			for (int j = 0; j < candidatos.size(); j++) {
				
				String vetSkillsCandidato[]=candidatos.get(j).getSkillCandidato().split(",");
				
				if (vagas.get(i).getSkill().contains(vetSkillsCandidato[j])) {
					cont++;
					candidatos.get(j).setContSkills(cont);
				}
			}
		}
		System.out.println("Totais de skills: "+cont);	
	
		List<Candidato> candidatos10=candidatoRepository.busca10();
		
		return candidatos10;
	}
	
	
	

	@PostMapping
	@Transactional
	@CacheEvict(value = "listaDeCandidatos", allEntries = true)
	public ResponseEntity<CandidatoDto> cadastrar(@RequestBody @Valid CandidatoForm form, UriComponentsBuilder uriBuilder) {
		Candidato candidato = form.converter(candidatoRepository);
		candidatoRepository.save(candidato);

		URI uri = uriBuilder.path("/candidatos/{id}").buildAndExpand(candidato.getId()).toUri();
		return ResponseEntity.created(uri).body(new CandidatoDto(candidato));		
	}

	@GetMapping("/{id}")
	public ResponseEntity<CandidatoDto> detalhar(@PathVariable Long id) {
		Optional<Candidato> candidato = candidatoRepository.findById(id);
		if (candidato.isPresent()) {
			return ResponseEntity.ok(new CandidatoDto(candidato.get()));
		}

		return ResponseEntity.notFound().build();
	}

	@PutMapping("/{id}")
	@Transactional
	@CacheEvict(value = "listaDeCandidatos", allEntries = true)
	public ResponseEntity<CandidatoDto> atualizar(@PathVariable Long id,
			@RequestBody @Valid AtualizaCandidatoForm form) {
		Optional<Candidato> optional = candidatoRepository.findById(id);
		if (optional.isPresent()) {
			Candidato candidato = form.atualizar(id, candidatoRepository);
			return ResponseEntity.ok(new CandidatoDto(candidato));
		}

		return ResponseEntity.notFound().build();
	}

	@DeleteMapping("/{id}")
	@Transactional
	@CacheEvict(value = "listaDeCandidatos", allEntries = true)
	public ResponseEntity<?> remover(@PathVariable Long id) {
		Optional<Candidato> optional = candidatoRepository.findById(id);
		if (optional.isPresent()) {
			candidatoRepository.deleteById(id);
			return ResponseEntity.ok().build();
		}

		return ResponseEntity.notFound().build();
	}

}
