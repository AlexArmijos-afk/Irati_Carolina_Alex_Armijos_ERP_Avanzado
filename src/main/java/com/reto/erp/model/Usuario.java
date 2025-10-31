package com.reto.erp.model;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Objects;

import org.hibernate.type.descriptor.java.LocalDateTimeJavaType;
import org.hibernate.type.descriptor.jdbc.LocalDateTimeJdbcType;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
//agregue los @---
@Entity
@Table(name="Usuario")
public class Usuario {
	@Id
	private long id; 
	@Column
	private String nombre;
	@Column
	private String email;
	@Column
	private String passwordHash;
	@Column
	private boolean activo;
	@Column
	private LocalDateTime fechaAlta = LocalDateTime.now();
	
	
	
	
	public Usuario() {
		super();
	}


	public Usuario(long id, String nombre, String email, String passwordHash, boolean activo) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.email = email;
		this.passwordHash = passwordHash;
		this.activo = activo;
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

	@Override
	public int hashCode() {
		return Objects.hash(activo, email, fechaAlta, id, nombre, passwordHash);
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
				&& Objects.equals(passwordHash, other.passwordHash);
	}
	
	
}
