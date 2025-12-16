package com.reto.erp.Service;

import com.reto.erp.model.Usuario;

public interface UsuarioService {

	public abstract Usuario aniadirUsuario(Usuario usuario);

	public abstract Long buscarIdUsuario(Usuario usuario);
	
	public abstract Usuario buscarUsuario(Long id);
	
	public void eliminarUsuario(Long id);
	
	public Usuario buscarPorEmail(String email);
	
}
