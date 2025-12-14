package com.reto.erp.cotroller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

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
	final String detalleUsuario = "detalleUsuario";			//detalleUsuario.html
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
		model.addAttribute("allRoles", rolserviceimpl.findAll());
		if (usuario.getEmail() != null && usuario.getPasswordHash() != null) {
			if (!usuario.getEmail().isEmpty() || !usuario.getPasswordHash().isEmpty()) {
				Long id = usuarioserviceimpl.buscarIdUsuario(usuario);
				if(id != null) {
					usuario = usuarioserviceimpl.buscarUsuario(id);
					boolean esAdmin = usuario.getRoles()
	                         .stream()
	                         .anyMatch(r -> "admin".equals(r.getNombre()));
					model.addAttribute("esAdmin", esAdmin);
					model.addAttribute("usuario", usuario);
					return paginaPrincipal;
				}
			}		
		}
		return "redirect:/erp/errorUsuarioInexistente";
		
	}
	
	@RequestMapping("detalleUsuario")
	public String usuarioIniciado(@ModelAttribute("usuario") Usuario usuario, Model model) {
		model.addAttribute("allRoles", rolserviceimpl.findAll());
		if (usuario.getEmail() != null && usuario.getPasswordHash() != null) {
			if (!usuario.getEmail().isEmpty() || !usuario.getPasswordHash().isEmpty()) {
				Long id = usuarioserviceimpl.buscarIdUsuario(usuario);
				if(id != null) {
					usuario = usuarioserviceimpl.buscarUsuario(id);
					boolean esAdmin = usuario.getRoles()
	                         .stream()
	                         .anyMatch(r -> "admin".equals(r.getNombre()));
					model.addAttribute("esAdmin", esAdmin);
					model.addAttribute("usuario", usuario);
					return "detalleUsuario";
				}
			}		
		}
		return "redirect:/erp/errorUsuarioInexistente";
	}

//	@RequestMapping("errorUsuarioInexistente")
//	public String error() {
//		return error ;
//	}
	
	@RequestMapping("actualizarUsuario")
	public String actualizarUsuario(@ModelAttribute("usuario") Usuario usuario, Model model,@RequestParam(required = false, name = "rolesIds") List<Long> rolesIds) {
		model.addAttribute("allRoles", rolserviceimpl.findAll());
		Usuario usuarioEncontrado = usuarioserviceimpl.buscarUsuario(usuario.getId());
		usuarioEncontrado.setNombre(usuario.getNombre());
		usuarioEncontrado.setEmail(usuario.getEmail());
		usuarioEncontrado.setActivo(usuario.isActivo());
		if (rolesIds != null && !rolesIds.isEmpty()) {
	        List<Rol> roles = rolserviceimpl.findAllById(rolesIds);
	        usuarioEncontrado.setRoles(roles);
	    } else {
	        // Si no hay roles seleccionados, vaciamos la lista
	        usuarioEncontrado.setRoles(new ArrayList<>()); // o Collections.emptyList()
	    }
		Usuario u = usuarioserviceimpl.aniadirUsuario(usuarioEncontrado);
		model.addAttribute("usuario", u);
		return detalleUsuario;
		
	}
	
	@GetMapping("registrarUsuario")
	public String registrarUsu(Model model) {
	    model.addAttribute("usuario", new Usuario());
	    model.addAttribute("allRoles", rolserviceimpl.findAll());
	    return nuevoUsuario;
	}


	
	
	
	@RequestMapping("usuarioRegistrado")
	public String usuarioRegistrado(@ModelAttribute("usuario") Usuario usuario,
	                                @RequestParam(required = false, name = "rolesIds") List<Long> rolesIds) {

	    if (rolesIds != null && !rolesIds.isEmpty()) {
	        List<Rol> roles = rolserviceimpl.findAllById(rolesIds);
	        usuario.setRoles(roles);
	    }

	    usuarioserviceimpl.aniadirUsuario(usuario);
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
