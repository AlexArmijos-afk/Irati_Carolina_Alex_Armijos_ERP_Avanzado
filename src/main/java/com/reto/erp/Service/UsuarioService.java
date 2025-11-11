package com.reto.erp.Service;

import java.util.Optional;

import com.reto.erp.model.Usuario;

public interface UsuarioService {

	public abstract Usuario aniadirUsuario(Usuario usuario);

	public abstract Long buscarIdUsuario(Usuario usuario);
	
	public abstract Usuario buscarUsuario(Long id);
	
}
