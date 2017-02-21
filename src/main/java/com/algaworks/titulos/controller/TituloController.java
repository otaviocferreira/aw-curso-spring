package com.algaworks.titulos.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/titulos")
public class TituloController {

	@GetMapping("/novo")
	public String novo() {
		return "cadastro-titulo";
	}
}
