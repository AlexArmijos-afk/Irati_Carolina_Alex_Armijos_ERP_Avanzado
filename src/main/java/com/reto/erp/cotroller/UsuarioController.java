package com.reto.erp.cotroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.reto.erp.Repository.UsuarioRepository;
import com.reto.erp.Service.Impl.RolServiceImpl;
import com.reto.erp.Service.Impl.UsuarioServiceImpl;
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

	
	final String inicio = "inicio";							// inicio.html
	final String iniciarSesion = "iniciarSesion";			// iniciarSesion.html
	final String detalleUsuario = "detalleUsuario";
	final String nuevoUsuario = "nuevoUsuario";				// nuevoUsuario.html
	final String nuevoRol = "nuevoRol";						// nuevoRol.html
	final String paginaPrincipal = "paginaPrincipal";

	private String error = "error"; // error.html

	@GetMapping("/bienvenido")
	public String bienvenida() {
		return inicio;
	}

	@GetMapping("iniciarSesion")
	public String iniciarSesion(@ModelAttribute("usuario") Usuario usuario, Model model) {
		return iniciarSesion;
	}
	
	@RequestMapping("paginaPrincipal")
	public String paginaPrincipal(@ModelAttribute("usuario") Usuario usuario, Model model) {
		return paginaPrincipal;
	}
	
	@RequestMapping("detalleUsuario")
	public String usuarioIniciado(@ModelAttribute("usuario") Usuario usuario, Model model) {
		if (usuario.getEmail() != null && usuario.getPasswordHash() != null) {
			if (!usuario.getEmail().isEmpty() || !usuario.getPasswordHash().isEmpty()) {
				Long id = usuarioserviceimpl.buscarIdUsuario(usuario);
				if(id != null) {
					usuario = usuarioserviceimpl.buscarUsuario(id);
					model.addAttribute("usuario", usuario);
					return "detalleUsuario";
				}
			}		
		}
		return "redirect:/erp/errorUsuarioInexistente";
	}

	@RequestMapping("errorUsuarioInexistente")
	public String error() {
		return error ;
	}
	
	@RequestMapping("actualizarUsuario")
	public String actualizarUsuario(@ModelAttribute("usuario") Usuario usuario, Model model) {
		Usuario usuarioEncontrado = usuarioserviceimpl.buscarUsuario(usuario.getId());
		usuarioEncontrado.setNombre(usuario.getNombre());
		usuarioEncontrado.setEmail(usuario.getEmail());
		usuarioEncontrado.setActivo(usuario.isActivo());
		Usuario u = usuarioserviceimpl.aniadirUsuario(usuarioEncontrado);
		model.addAttribute("usuario", u);
		return detalleUsuario;
		
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

	

	
	
	

}
