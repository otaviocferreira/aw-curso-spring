package com.algaworks.titulos.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.algaworks.titulos.model.Titulo;

@Controller
@RequestMapping("/titulos")
public class TituloController {

	@GetMapping("/novo")
	public String novo() {
		return "cadastro-titulo";
	}
	
	@PostMapping("/novo")
	public String salvar(Titulo titulo) {
		System.out.println(">>>" + titulo.getDescricao());
		return "cadastro-titulo";
	}
}
