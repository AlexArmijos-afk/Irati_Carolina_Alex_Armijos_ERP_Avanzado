package com.reto.erp.Service.Impl;

import java.util.Optional;

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
	public Long buscarUsuario(Usuario usuario) {
	    Optional<Usuario> usuarioEncontrado = usuariorepository.findByEmailAndPasswordHash(
	        usuario.getEmail(),
	        usuario.getPasswordHash()
	    );

	    // Si existe, devuelve el ID
	    if (usuarioEncontrado.isPresent()) {
	        return usuarioEncontrado.get().getId();
	    }

	    // Si no existe, devuelve null o lanza una excepción (según tu lógica)
	    return null;
	}


	public void eliminarUsuario(Long id){
		usuariorepository.deleteById(id);
	}
}
