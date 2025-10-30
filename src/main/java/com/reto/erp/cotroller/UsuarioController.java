package com.reto.erp.cotroller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;

import com.reto.erp.model.Usuario;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PathVariable;


@Controller
@RequestMapping("/erp")
public class UsuarioController {
	//variable para llamar a inicio.html
	final String inicio = "inicio";
	
	//variable para llamar a iniciarSesion.html
		final String iniciarSesion = "iniciarSesion";
		
	@GetMapping("/bienvenido")
	public String registrarUsu() {
		return inicio;
	}
	
	@GetMapping("iniciarSesion")
	public String putMethodName() {
		//TODO: process PUT request
		
		return iniciarSesion;
	}
	
}
