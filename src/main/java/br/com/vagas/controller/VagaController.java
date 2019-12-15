package br.com.vagas.controller;

import java.net.URI;
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

import br.com.vagas.atualizacao.form.AtualizaVagaForm;
import br.com.vagas.controller.dto.VagaDto;
import br.com.vagas.controller.form.VagaForm;
import br.com.vagas.model.Vaga;
import br.com.vagas.repository.VagaRepository;

@RestController
@RequestMapping("/vaga")
public class VagaController {

	@Autowired
	private VagaRepository vagaRepository;

	@GetMapping
	@Cacheable(value = "listaDeVagas")
	public Page<VagaDto> lista(@RequestParam(required = false) String vaga,
			@PageableDefault(sort = "id", direction = Direction.DESC, page = 0, size = 10) Pageable paginacao) {

		if (vaga == null) {
			Page<Vaga> vagas = vagaRepository.findAll(paginacao);
			return VagaDto.converter(vagas);
		} else {
			Page<Vaga> vagas = vagaRepository.findByNomeVaga(vaga, paginacao);
			return VagaDto.converter(vagas);
		}
	}

	
	
	@PostMapping
	@Transactional
	@CacheEvict(value = "listaDeVagas", allEntries = true)
	public ResponseEntity<VagaDto> cadastrar(@RequestBody @Valid VagaForm form, UriComponentsBuilder uriBuilder) {
		Vaga vaga = form.converter(vagaRepository);
		vagaRepository.save(vaga);

		URI uri = uriBuilder.path("/vaga/{id}").buildAndExpand(vaga.getId()).toUri();
		return ResponseEntity.created(uri).body(new VagaDto(vaga));		
	}

	@GetMapping("/{id}")
	public ResponseEntity<VagaDto> detalhar(@PathVariable Long id) {
		Optional<Vaga> vaga = vagaRepository.findById(id);
		if (vaga.isPresent()) {
			return ResponseEntity.ok(new VagaDto(vaga.get()));
		}

		return ResponseEntity.notFound().build();
	}
	
	@GetMapping("/vagaExiste/{nomeVaga}")
	public ResponseEntity<VagaDto> vagaExiste(@PathVariable(name = "nomeVaga") String nomeVaga) {
	
			Optional<Vaga> vagas = vagaRepository.findByNomeVaga(nomeVaga);
			
			if (vagas.isPresent()) {
				return ResponseEntity.ok().build();
			}
			
			return ResponseEntity.badRequest().build();
			
	}
	
	

	@PutMapping("/{id}")
	@Transactional
	@CacheEvict(value = "listaDeVagas", allEntries = true)
	public ResponseEntity<VagaDto> atualizar(@PathVariable Long id,
			@RequestBody @Valid AtualizaVagaForm form) {
		Optional<Vaga> optional = vagaRepository.findById(id);
		if (optional.isPresent()) {
			Vaga vaga = form.atualizar(id, vagaRepository);
			return ResponseEntity.ok(new VagaDto(vaga));
		}

		return ResponseEntity.notFound().build();
	}

	@DeleteMapping("/{id}")
	@Transactional
	@CacheEvict(value = "listaDeVagas", allEntries = true)
	public ResponseEntity<?> remover(@PathVariable Long id) {
		Optional<Vaga> optional = vagaRepository.findById(id);
		if (optional.isPresent()) {
			vagaRepository.deleteById(id);
			return ResponseEntity.ok().build();
		}

		return ResponseEntity.notFound().build();
	}

}
