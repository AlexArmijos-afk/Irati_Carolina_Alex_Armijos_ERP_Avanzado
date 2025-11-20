package com.reto.erp.Service.Impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.reto.erp.Repository.DepartamentoRepository;
import com.reto.erp.Repository.RolRepository;
import com.reto.erp.Repository.UsuarioDepartamentoRolRepository;
import com.reto.erp.Repository.UsuarioRepository;
import com.reto.erp.Service.UsuarioService;
import com.reto.erp.model.Departamento;
import com.reto.erp.model.Rol;
import com.reto.erp.model.Usuario;
import com.reto.erp.model.UsuarioDepartamentoRol;
import com.reto.erp.model.UsuarioDepartamentoRolId;

@Service("usuarioServiceImpl")
public class UsuarioServiceImpl implements UsuarioService{
	@Autowired
	@Qualifier("usuarioRepository")
	UsuarioRepository usuariorepository;

	@Autowired
    @Qualifier("rolRepository")
	RolRepository rolRepository;

    @Autowired
    @Qualifier("departamentoRepository")
    DepartamentoRepository departamentoRepository;

    @Autowired
    @Qualifier("udrRepository")
    UsuarioDepartamentoRolRepository urdRepository;
	
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
	
	public Usuario crearUsuarioConRolYDepartamento(Long usuarioId, Long rolId, Long departamentoId) {
		Usuario usuario = buscarUsuario(usuarioId);
		
	    Rol rol = rolRepository.findById(rolId)
	            .orElseThrow(() -> new RuntimeException("Rol no encontrado"));

	    Departamento departamento = departamentoRepository.findById(departamentoId)
	            .orElseThrow(() -> new RuntimeException("Departamento no encontrado"));

	    //Crear la clave compuesta
	    UsuarioDepartamentoRolId id = new UsuarioDepartamentoRolId(usuario, departamento, rol);

	    //Crear la entidad intermedia y guardar
	    UsuarioDepartamentoRol urd = new UsuarioDepartamentoRol();
	    urd.setId(id);
	    urdRepository.save(urd);

	    //(Opcional) mantener coherencia en memoria
	    //usuario.getRolesDepartamentos().add(urd);

	    return usuario;
	}
	
	//Asignar a un usuario existente un rol y un departamento existentes.
    public void asignarRolYDepartamento(Long usuarioId, Long rolId, Long departamentoId) {

        //Obtener las entidades existentes
        Usuario usuario = usuariorepository.findById(usuarioId)
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));

        Rol rol = rolRepository.findById(rolId)
                .orElseThrow(() -> new RuntimeException("Rol no encontrado"));

        Departamento departamento = departamentoRepository.findById(departamentoId)
                .orElseThrow(() -> new RuntimeException("Departamento no encontrado"));

        //Crear la clave compuesta
        UsuarioDepartamentoRolId id = new UsuarioDepartamentoRolId(usuario, departamento, rol);

        //Crear la entidad intermedia
        UsuarioDepartamentoRol urd = new UsuarioDepartamentoRol();
        urd.setId(id);

        //Guardar en la base de datos
        urdRepository.save(urd);
    }

}
