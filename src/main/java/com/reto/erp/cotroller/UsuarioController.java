package com.reto.erp.cotroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.reto.erp.Service.Impl.DepartamentoServiceImpl;
import com.reto.erp.Service.Impl.RolServiceImpl;
import com.reto.erp.Service.Impl.UsuarioServiceImpl;
import com.reto.erp.model.Departamento;
import com.reto.erp.model.Rol;
import com.reto.erp.model.Usuario;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Controller
@RequestMapping("/erp")
public class UsuarioController {

	@Autowired
	@Qualifier("usuarioServiceImpl")
	UsuarioServiceImpl usuarioserviceimpl;

	@Autowired
	@Qualifier("rolServiceImpl")
	RolServiceImpl rolserviceimpl;

	@Autowired
	@Qualifier("departamentoServiceImpl")
	DepartamentoServiceImpl departamentoserviceimpl;

	// variable para llamar a inicio.html
	final String inicio = "inicio";

	// variable para llamar a iniciarSesion.html
	final String iniciarSesion = "iniciarSesion";

	// variable para llamar a nuevoUsuario.html
	final String nuevoUsuario = "nuevoUsuario";

	// variable para llamar a nuevoRol.html
	final String nuevoRol = "nuevoRol";

	// variable para llamar a nuevoRol.html
	final String nuevoDepartamento = "nuevoDepartamento";

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
	public String usuarioRegistrado(@ModelAttribute("usuario") Usuario usuario, Model model) {
		if (usuario.getEmail() != null) {
			if (!usuario.getEmail().isEmpty()) {
				usuarioserviceimpl.aniadirUsuario(usuario);
				model.addAttribute("usuario", new Usuario());
			}
		}
		return "redirect:/erp/registrarUsuario";
	}

	@GetMapping("registrarRol")
	public String registrarRol(Model model) {
		model.addAttribute("rol", new Rol());
		return nuevoRol;
	}

	@RequestMapping("rolRegistrado")
	public String rolRegistrado(@ModelAttribute("rol") Rol rol, Model model) {
		if (rol.getNombre() != null) {
			if (!rol.getNombre().isEmpty()) {
				rolserviceimpl.aniadirRol(rol);
				model.addAttribute("rol", new Rol());
			}
		}
		return "redirect:/erp/registrarRol";
	}

	@GetMapping("registrarDepartamento")
	public String registrarDepartamento(Model model) {
		model.addAttribute("departamento", new Departamento());
		return nuevoDepartamento;
	}

	@RequestMapping("departamentoRegistrado")
	public String departamentoRegistrado(@ModelAttribute("departamento") Departamento departamento, Model model) {
		if (departamento.getNombre() != null) {
			if (!departamento.getNombre().isEmpty()) {
				departamentoserviceimpl.aniadirDepartamento(departamento);
				model.addAttribute("departamento", new Departamento());
			}
		}
		return "redirect:/erp/registrarDepartamento";
	}

}
