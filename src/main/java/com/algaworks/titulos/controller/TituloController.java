package com.algaworks.titulos.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.algaworks.titulos.model.Titulo;
import com.algaworks.titulos.repository.Titulos;

@Controller
@RequestMapping("/titulos")
public class TituloController {
	
	@Autowired
	public Titulos titulos;

	@GetMapping("/novo")
	public String novo() {
		return "cadastro-titulo";
	}
	
	@PostMapping("/novo")
	public ModelAndView salvar(Titulo titulo) {
		titulos.save(titulo);
		ModelAndView mv = new ModelAndView("cadastro-titulo");
		mv.addObject("mensagem", "Título salvo com sucesso!");
		return mv;
	}
}
