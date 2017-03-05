package com.algaworks.titulos.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.algaworks.titulos.model.StatusTitulo;
import com.algaworks.titulos.model.Titulo;
import com.algaworks.titulos.repository.Titulos;

@Controller
@RequestMapping("/titulos")
public class TituloController {
	
	@Autowired
	public Titulos titulos;

	@GetMapping("/novo")
	public ModelAndView novo() {
		ModelAndView mv = new ModelAndView("cadastro-titulo");
		mv.addObject(new Titulo());
		return mv;
	}
	
	@PostMapping("/novo")
	public ModelAndView salvar(@Validated Titulo titulo, Errors errors) {
		ModelAndView mv = new ModelAndView("cadastro-titulo");
		
		if (errors.hasErrors()) {
			return mv;
		}
		
		titulos.save(titulo);
		
		mv.addObject("mensagem", "Título salvo com sucesso!");
		return mv;
	}
	
	@ModelAttribute("todosStatusTitulo")
	public List<StatusTitulo> todosStatusTitulo() {
		return Arrays.asList(StatusTitulo.values());
	}
	
	@RequestMapping
	public ModelAndView pesquisar() {
		ModelAndView mv = new ModelAndView("pesquisa-titulos");
		mv.addObject("titulos", titulos.findAll());
		return mv;
	}
}
