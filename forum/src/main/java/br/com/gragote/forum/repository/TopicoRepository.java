package br.com.gragote.forum.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import br.com.gragote.forum.model.Topico;

public interface TopicoRepository extends JpaRepository<Topico, Long>  {

	//findBy(nomeDaRelaçao)(campoDaRelacao)
	//pra evitar problemas de ambiguidade usar finByCurso_Nome
	List<Topico> findByCursoNome(String nomeCurso);
	
	/*Query personalizada
	@Query("Select t FROM Topico t WHERE t.curso.nome = :nomeCurso")
	List<Topico> procuraPorNome(@Param("nomeCurso") String nomeCurso);
	*/
}
