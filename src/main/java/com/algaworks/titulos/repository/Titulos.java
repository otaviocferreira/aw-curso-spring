package com.algaworks.titulos.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.algaworks.titulos.model.Titulo;

public interface Titulos extends JpaRepository<Titulo, Long> {

}
