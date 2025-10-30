package com.reto.erp.model;

import java.io.Serializable;
import java.util.Objects;

import jakarta.persistence.Embeddable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
//Clase para clave compuesta de la relacion triple usuario rol y departamento, porque la PK esta compuesta por mas de un campo que 
//a su vez son FK por lo que hacen referencia a otras tablas

@Embeddable
public class UsuarioDepartamentoRolId implements Serializable{
	
	@ManyToOne
	@JoinColumn(name= "usuario_id") //mismo nombre en la tabla de la relación triple en BBDD 
	private Usuario usuario;
	
	@ManyToOne
	@JoinColumn(name= "departamento_id") //mismo nombre en la tabla de la relación triple en BBDD 
    private Departamento departamento;
	
	@ManyToOne
	@JoinColumn(name= "rol_id") //mismo nombre en la tabla de la relación triple en BBDD 
    private Rol rol;
	
	public UsuarioDepartamentoRolId() {
		super();
	}

	public UsuarioDepartamentoRolId(Usuario usuario, Departamento departamento, Rol rol) {
		super();
		this.usuario = usuario;
		this.departamento = departamento;
		this.rol = rol;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public Departamento getDepartamento() {
		return departamento;
	}

	public void setDepartamento(Departamento departamento) {
		this.departamento = departamento;
	}

	public Rol getRol() {
		return rol;
	}

	public void setRol(Rol rol) {
		this.rol = rol;
	}

	
	
	// IMPORTANTE: equals y hashCode
	//JPA los usa internamente. JPA---> es una dependencia que usamos(ver en el pom.xml) su id es este "spring-boot-starter-data-jpa"
	
	
	//Para comparar dos claves compuestas por contenido, no por referencia
	@Override
	public int hashCode() {
		return Objects.hash(departamento, rol, usuario);
	}

	//Para usar la clave en estructuras Hash(mapas y cosas asi) que JPA usa internamente
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		UsuarioDepartamentoRolId other = (UsuarioDepartamentoRolId) obj;
		return Objects.equals(departamento, other.departamento) && Objects.equals(rol, other.rol)
				&& Objects.equals(usuario, other.usuario);
	}
	

	
	
	
    
    
}
