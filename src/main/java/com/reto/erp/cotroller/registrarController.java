package com.reto.erp.cotroller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
@RequestMapping("erp")
public class registrarController {
	//variable para llamar a registro.html
	final String registar = "registro";
	
	
	
	@GetMapping("registrar")
	public String registrarUsu(@RequestParam String param) {
		
		return registar;
	}
	
}
