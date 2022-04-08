package br.com.gragote.forum.controller.form;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import br.com.gragote.forum.model.Topico;
import br.com.gragote.forum.repository.TopicoRepository;

public class AtualizacaoTopicoForm {
	
	@NotNull @NotEmpty @Size(min = 5)
	private String titulo;
	
	@NotNull @NotEmpty @Size(min = 5)
	private String mensagem;

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getMensagem() {
		return mensagem;
	}

	public void setMensagem(String mensagem) {
		this.mensagem = mensagem;
	}

	public Topico atualizar(Long id, TopicoRepository topicoRepository) {
		Topico topico = topicoRepository.getById(id);
		topico.setTitulo(this.titulo);
		topico.setMensagem(this.mensagem);
		return topico;
	}
	
	
}
