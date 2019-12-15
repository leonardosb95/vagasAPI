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

import br.com.vagas.atualizacao.form.AtualizaPerfilLinkedinForm;
import br.com.vagas.controller.dto.PerfilLinkedinDto;
import br.com.vagas.controller.form.PerfilLinkedinForm;
import br.com.vagas.model.PerfilLinkedin;
import br.com.vagas.repository.PerfilLinkedinRepository;



@RestController
@RequestMapping("/perfil")
public class PerfilLinkedinController {

	@Autowired
	private PerfilLinkedinRepository perfilLinkedinRepository;

	@GetMapping
	@Cacheable(value = "listaDePerfis")
	public Page<PerfilLinkedinDto> lista(@RequestParam(required = false) String perfil,
			@PageableDefault(sort = "id", direction = Direction.DESC, page = 0, size = 10) Pageable paginacao) {

		if (perfil == null) {
			Page<PerfilLinkedin> perfils = perfilLinkedinRepository.findAll(paginacao);
			return PerfilLinkedinDto.converter(perfils);
		} else {
			Page<PerfilLinkedin> perfils = perfilLinkedinRepository.findByPerfilLinkedin(perfil, paginacao);
			return PerfilLinkedinDto.converter(perfils);
		}
	}


	@PostMapping
	@Transactional
	@CacheEvict(value = "listaDePerfis", allEntries = true)
	public ResponseEntity<PerfilLinkedinDto> cadastrar(@RequestBody @Valid PerfilLinkedinForm form, UriComponentsBuilder uriBuilder) {
		PerfilLinkedin perfil = form.converter(perfilLinkedinRepository);
		perfilLinkedinRepository.save(perfil);

		URI uri = uriBuilder.path("/perfil/{id}").buildAndExpand(perfil.getId()).toUri();
		return ResponseEntity.created(uri).body(new PerfilLinkedinDto(perfil));		
	}

	@GetMapping("/{id}")
	public ResponseEntity<PerfilLinkedinDto> detalhar(@PathVariable Long id) {
		Optional<PerfilLinkedin> perfil = perfilLinkedinRepository.findById(id);
		if (perfil.isPresent()) {
			return ResponseEntity.ok(new PerfilLinkedinDto(perfil.get()));
		}

		return ResponseEntity.notFound().build();
	}

	@PutMapping("/{id}")
	@Transactional
	@CacheEvict(value = "listaDePerfis", allEntries = true)
	public ResponseEntity<PerfilLinkedinDto> atualizar(@PathVariable Long id,
			@RequestBody @Valid AtualizaPerfilLinkedinForm form) {
		Optional<PerfilLinkedin> optional = perfilLinkedinRepository.findById(id);
		if (optional.isPresent()) {
			PerfilLinkedin perfil = form.atualizar(id, perfilLinkedinRepository);
			return ResponseEntity.ok(new PerfilLinkedinDto(perfil));
		}

		return ResponseEntity.notFound().build();
	}

	@DeleteMapping("/{id}")
	@Transactional
	@CacheEvict(value = "listaDePerfis", allEntries = true)
	public ResponseEntity<?> remover(@PathVariable Long id) {
		Optional<PerfilLinkedin> optional = perfilLinkedinRepository.findById(id);
		if (optional.isPresent()) {
			perfilLinkedinRepository.deleteById(id);
			return ResponseEntity.ok().build();
		}

		return ResponseEntity.notFound().build();
	}

}
