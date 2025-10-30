package com.reto.erp.model;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;

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
	private LocalDate fechaAlta;
	
	public Usuario() {
	}
	
	public Usuario(long id, String nombre, String email, String passwordHash, boolean activo, LocalDate fechaAlta) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.email = email;
		this.passwordHash = passwordHash;
		this.activo = activo;
		this.fechaAlta = fechaAlta;
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

	public LocalDate getFechaAlta() {
		return fechaAlta;
	}

	public void setFechaAlta(LocalDate fechaAlta) {
		this.fechaAlta = fechaAlta;
	}
}
