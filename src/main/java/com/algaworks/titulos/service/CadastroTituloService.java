package com.algaworks.titulos.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import com.algaworks.titulos.model.Titulo;
import com.algaworks.titulos.repository.Titulos;

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
}
