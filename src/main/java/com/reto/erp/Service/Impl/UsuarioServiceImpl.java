package com.reto.erp.Service.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.reto.erp.Repository.UsuarioRepository;
import com.reto.erp.Service.UsuarioService;
import com.reto.erp.model.Usuario;

@Service("usuarioServiceImpl")
public class UsuarioServiceImpl implements UsuarioService{
	@Autowired
	@Qualifier("usuarioRepository")
	UsuarioRepository usuariorepository;

	@Override
	public Usuario aniadirUsuario(Usuario usuario) {
		return usuariorepository.save(usuario);
	}

	@Override
	public boolean buscarUsuario(Usuario usuario) {
		// TODO Auto-generated method stub
		return false;
	}

}
