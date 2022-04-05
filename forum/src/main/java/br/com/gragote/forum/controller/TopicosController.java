package br.com.gragote.forum.controller;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import br.com.gragote.forum.controller.dto.TopicoDto;
import br.com.gragote.forum.controller.form.TopicoForm;
import br.com.gragote.forum.controller.repository.CursoRepository;
import br.com.gragote.forum.model.Topico;
import br.com.gragote.forum.repository.TopicoRepository;

@RestController
@RequestMapping("/topicos")
public class TopicosController {
	
	@Autowired
	private TopicoRepository topicoRepository;
	
	@Autowired
	private CursoRepository cursoRepository;
	
	@GetMapping
	public List<TopicoDto> listagem(String nomeCurso) {
		List<Topico> res;
		
		if(nomeCurso == null) {
			List<Topico> topicos = topicoRepository.findAll();
			res = topicos;
		} else {
			List<Topico> topicos = topicoRepository.findByCursoNome(nomeCurso);
			res = topicos;
		}
		
		return TopicoDto.converter(res);
	};
	
	@PostMapping
	public ResponseEntity<TopicoDto> cadastrar(@RequestBody TopicoForm form, UriComponentsBuilder uriBuilder) {
		Topico topico = form.converter(cursoRepository);
		topicoRepository.save(topico);
		
		URI uri = uriBuilder.path("/topicos/{id}").buildAndExpand(topico.getId()).toUri();
		
		return ResponseEntity.created(uri).body(new TopicoDto(topico));
	}
};
