package br.com.vagas.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.vagas.model.PerfilLinkedin;
@Repository
public interface PerfilLinkedinRepository extends JpaRepository<PerfilLinkedin, Long> {


	List<PerfilLinkedin> findById(String perfil);

	Page<PerfilLinkedin> findByPerfilLinkedin(String perfil, Pageable paginacao);
	

}
