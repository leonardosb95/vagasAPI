package br.com.vagas.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import br.com.vagas.model.Candidato;
@Repository
public interface CandidatoRepository extends JpaRepository<Candidato, Long> {


	List<Candidato> findById(String nome);

	Page<Candidato> findByNomeCompleto(String candidato, Pageable paginacao);
	
	@Query(value = "SELECT TOP 10 * FROM CANDIDATO CONT_SKILLS ORDER BY 1 DESC",nativeQuery = true)
	List<Candidato> busca10();

	
	

	
	

}
