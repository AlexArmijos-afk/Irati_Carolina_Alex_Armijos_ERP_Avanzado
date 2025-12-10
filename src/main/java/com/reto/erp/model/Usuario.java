package com.reto.erp.model;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinTable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;

@Entity
@Table(name="Usuario")
public class Usuario {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) //MySQL: auto_increment
	private long id; 
	
	@Column(nullable = false) //MySQL: not null
	private String nombre;
	@Column(nullable = false, unique = true)
	private String email;
	@Column(name = "password_hash", nullable = false)
	private String passwordHash;
	@Column(nullable = false)
	private boolean activo = true; //MySQL: default = true
	@Column(name = "fecha_alta", nullable = false)
	private LocalDateTime fechaAlta = LocalDateTime.now();
	
	@ManyToMany
    @JoinTable(
        name = "usuario_rol",  // nombre de la tabla intermedia
        joinColumns = @JoinColumn(name = "usuario_id"),  // columna del usuario
        inverseJoinColumns = @JoinColumn(name = "rol_id")  // columna del rol
    )
	private List<Rol> roles;

	public Usuario() {
		super();
	    this.roles = new ArrayList<>();

	}

	public Usuario(long id, String nombre, String email, String passwordHash, boolean activo, LocalDateTime fechaAlta,
			List<Rol> roles) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.email = email;
		this.passwordHash = passwordHash;
		this.activo = activo;
		this.fechaAlta = fechaAlta;
		this.roles = roles;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPasswordHash() {
		return passwordHash;
	}

	public void setPasswordHash(String passwordHash) {
		this.passwordHash = passwordHash;
	}

	public boolean isActivo() {
		return activo;
	}

	public void setActivo(boolean activo) {
		this.activo = activo;
	}

	public LocalDateTime getFechaAlta() {
		return fechaAlta;
	}

	public void setFechaAlta(LocalDateTime fechaAlta) {
		this.fechaAlta = fechaAlta;
	}

	public List<Rol> getRoles() {
		return roles;
	}

	public void setRoles(List<Rol> roles) {
		this.roles = roles;
	}

	@Override
	public int hashCode() {
		return Objects.hash(activo, email, fechaAlta, id, nombre, passwordHash, roles);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Usuario other = (Usuario) obj;
		return activo == other.activo && Objects.equals(email, other.email)
				&& Objects.equals(fechaAlta, other.fechaAlta) && id == other.id && Objects.equals(nombre, other.nombre)
				&& Objects.equals(passwordHash, other.passwordHash) && Objects.equals(roles, other.roles);
	}
	
	
	
	
}
