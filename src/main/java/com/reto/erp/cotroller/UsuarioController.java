package com.reto.erp.cotroller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;

import com.reto.erp.model.Usuario;

@Controller
@RequestMapping("/erp")
public class UsuarioController {
	//variable para llamar a registro.html
	final String inicio = "inicio";
		
	@GetMapping("/bienvenido")
	public String registrarUsu() {
		return inicio;
	}
	
}
