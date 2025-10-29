package com.reto.erp.cotroller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;

import com.reto.erp.model.Usuario;

@Controller
@RequestMapping("/erp")
public class registrarController {
	//variable para llamar a registro.html
	final String registrar = "iniciarSesion";
		
	@GetMapping("/registrar")
	public String registrarUsu(Model model) {
		model.addAttribute("usuario", new Usuario());
		return registrar;
	}
	
}
