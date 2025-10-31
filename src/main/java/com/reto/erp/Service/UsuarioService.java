package com.reto.erp.Service;

import com.reto.erp.model.Usuario;

public interface UsuarioService {
	
	// Metodo literal
	public abstract Usuario aniadirUsuario(Usuario usuario);
	
	//Metodo literal pero necesito que devuelva un boolean true si esta el usuario y false si no 
	public abstract boolean buscarUsuario(Usuario usuario);
}
