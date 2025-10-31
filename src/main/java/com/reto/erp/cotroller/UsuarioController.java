package com.reto.erp.cotroller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.reto.erp.model.Usuario;

@Controller
@RequestMapping("/erp")
public class UsuarioController {
	// variable para llamar a inicio.html
	final String inicio = "inicio";

	// variable para llamar a iniciarSesion.html
	final String iniciarSesion = "iniciarSesion";

	// variable para llamar a iniciarSesion.html
	final String nuevoUsuario = "nuevoUsuario";

	@GetMapping("/bienvenido")
	public String bienvenida() {
		return inicio;
	}

	@GetMapping("iniciarSesion")
	public String iniciarSesion() {
		return iniciarSesion;
	}

	@GetMapping("registrarUsuario")
	public String registrarUsu(Model model) {
		model.addAttribute("usuario", new Usuario());
		return nuevoUsuario;
	}
	
	

}
