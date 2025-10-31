package com.reto.erp.cotroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.reto.erp.Service.Impl.UsuarioServiceImpl;
import com.reto.erp.model.Usuario;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@Controller
@RequestMapping("/erp")
public class UsuarioController {
	
	@Autowired
	@Qualifier("usuarioServiceImpl")
	UsuarioServiceImpl usuarioserviceimpl;
	
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
	
	@RequestMapping("usuarioRegistrado")
	public String usuarioRegistrado(@ModelAttribute("usuario") Usuario usuario,Model model) {
		if(usuario.getEmail()!=null) {
			if (!usuario.getEmail().isEmpty()) {
				usuarioserviceimpl.aniadirUsuario(usuario);
				model.addAttribute("usuario", new Usuario());
			}
		}
		return "redirect:/erp/registrarUsuario";
	}
	
	
	

}
