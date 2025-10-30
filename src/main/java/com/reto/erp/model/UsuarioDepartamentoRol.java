package com.reto.erp.model;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
//Esta seria la tabla que se crea en la BBDD pero es necesaria la clase UsuarioDepartamentoRolId 
//que modela la clave primaria compuesta

@Entity
@Table(name = "usuario_departamento_rol") // nombre exacto de la tabla en la BD
public class UsuarioDepartamentoRol {
	
	@EmbeddedId
    private UsuarioDepartamentoRolId id;
	
	//Aqui se tendrian que agregar mas atributos si la relacion triple los requiere como: fecha_alta o algo por el estilo

	public UsuarioDepartamentoRol() {
		super();
	}

	public UsuarioDepartamentoRol(Usuario usuario, Departamento departamento,Rol rol ) {
		super();
		this.id = new UsuarioDepartamentoRolId(usuario, departamento, rol);
	}

	public UsuarioDepartamentoRolId getId() {
		return id;
	}

	public void setId(UsuarioDepartamentoRolId id) {
		this.id = id;
	}
	
	
	// Métodos de acceso delegados para facilitar el uso
    public Usuario getUsuario() {
        return id.getUsuario();
    }
    
    public Rol getRol() {
        return id.getRol();
    }
    
    public Departamento getDepartamento() {
        return id.getDepartamento();
    }
	
	
	
}
