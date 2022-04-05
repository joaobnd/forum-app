package br.com.gragote.forum.controller.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.gragote.forum.model.Curso;

public interface CursoRepository extends JpaRepository<Curso, Long>{

	Curso findByNome(String nome);
	
}
