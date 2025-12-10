package com.reto.erp.Service.Impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.reto.erp.Repository.RolRepository;
import com.reto.erp.Repository.UsuarioRepository;
import com.reto.erp.Service.UsuarioService;
import com.reto.erp.model.Rol;
import com.reto.erp.model.Usuario;

@Service("usuarioServiceImpl")
public class UsuarioServiceImpl implements UsuarioService{
	@Autowired
	@Qualifier("usuarioRepository")
	UsuarioRepository usuariorepository;

	@Autowired
    @Qualifier("rolRepository")
	RolRepository rolRepository;

    	
    @Override
	public Usuario aniadirUsuario(Usuario usuario) {
		return usuariorepository.save(usuario);
	}

	@Override
	public Long buscarIdUsuario(Usuario usuario) {
	    Optional<Usuario> usuarioEncontrado = usuariorepository.findByEmailAndPasswordHash(
	        usuario.getEmail(),
	        usuario.getPasswordHash()
	    );

	    if (usuarioEncontrado.isPresent()) {
	        return usuarioEncontrado.get().getId();
	    }
	    return null;
	}


	public void eliminarUsuario(Long id){
		usuariorepository.deleteById(id);
	}

	@Override
	public Usuario buscarUsuario(Long id) {
		Usuario usuarioEncontrado = usuariorepository.getReferenceById(id);
		return usuarioEncontrado;
	}

	public Usuario buscarPorEmail(String email) {
	    return usuariorepository.findByEmail(email).orElse(null);
	}


	
	
	
	

}
