package br.com.gragote.forum.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import br.com.gragote.forum.model.Topico;

public interface TopicoRepository extends JpaRepository<Topico, Long>  {

	//findBy(nomeDaRelaçao)(campoDaRelacao)
	//pra evitar problemas de ambiguidade usar finByCurso_Nome
	Page<Topico> findByCursoNome(String nomeCurso, Pageable paginacao);
	
	/*Query personalizada
	@Query("Select t FROM Topico t WHERE t.curso.nome = :nomeCurso")
	List<Topico> procuraPorNome(@Param("nomeCurso") String nomeCurso);
	*/
}
