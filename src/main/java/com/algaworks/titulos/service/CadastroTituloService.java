package com.algaworks.titulos.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import com.algaworks.titulos.model.StatusTitulo;
import com.algaworks.titulos.model.Titulo;
import com.algaworks.titulos.repository.Titulos;
import com.algaworks.titulos.repository.filter.TituloFilter;

@Service
public class CadastroTituloService {

	@Autowired
	public Titulos titulos;
	
	public void salvar(Titulo titulo) {
		try {
		titulos.save(titulo);
		} catch(DataIntegrityViolationException e) {
			throw new IllegalArgumentException("Formato de data inválido");
		}
	}

	public void deletar(Long codigo) {
		titulos.delete(codigo);
	}

	public String receber(Long codigo) {
		Titulo titulo = titulos.findOne(codigo);
		titulo.setStatus(StatusTitulo.RECEBIDO);
		titulos.save(titulo);
		
		return titulo.getStatus().getDescricao();
	}
	
	public List<Titulo> filtrar(TituloFilter filtro) {
		return titulos.findByDescricaoContaining(filtro.getDescricao() == null ? "%" : filtro.getDescricao());
	}
}
