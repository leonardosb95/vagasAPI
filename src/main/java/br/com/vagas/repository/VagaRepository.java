package br.com.vagas.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.vagas.model.Vaga;
@Repository
public interface VagaRepository extends JpaRepository<Vaga, Long> {


	List<Vaga> findById(String vaga);

	Page<Vaga> findByNomeVaga(String vaga, Pageable paginacao);
	
	Optional<Vaga> findByNomeVaga(String nomeVaga);

	
	

	
	

}
