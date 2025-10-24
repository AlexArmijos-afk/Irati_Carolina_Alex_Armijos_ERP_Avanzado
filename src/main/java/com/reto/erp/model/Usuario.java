package com.reto.erp.model;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;

public class Usuario {
	private int idUsuario; 
	private String usuario;
	private String correo;
	private String contrasena;
	private String fotoPerfil;
	private LocalDate fechaAlta;
	private LocalDate fechaBaja;
	private Estado estado;
	private LocalDateTime ultimoIngreso;
	private int intentosFallidos;
	//private ArrayList<Rol> roles = new ArrayList<Rol>();
	
	public Usuario() {
	}
	
	public Usuario(int idUsuario, String usuario, String correo, String contrasena, String fotoPerfil, LocalDate fechaAlta, LocalDate fechaBaja, Estado estado,
			LocalDateTime ultimoIngreso, int intentosFallidos) {
		super();
		this.idUsuario = idUsuario;
		this.usuario = usuario;
		this.correo = correo;
		this.contrasena = contrasena;
		this.fotoPerfil = fotoPerfil;
		this.estado = estado;
		this.intentosFallidos = intentosFallidos;
	}
	/*
	public void agregarRol(Rol roles) {
		this.roles.add(roles);
	}
	*/
	public int getIdUsuario() {
		return idUsuario;
	}
	
	public void setIdUsuario(int idUsuario) {
		this.idUsuario = idUsuario;
		
	}
	public String getUsuario() {
		return usuario;
	}
	
	public void setUsuario(String usuario) {
		this.usuario = usuario;
		
	}
	public String getCorreo() {
		return correo;
	}
	public void setCorreo(String correo) {
		this.correo = correo;
		
	}
	public String getContrasena() {
		return contrasena;
		
	}
	public void setContrasena(String contrasena) {
		this.contrasena = contrasena;
		
	}
	public String getFotoPerfil() {
		return fotoPerfil;
		
	}
	public void setFotoPerfil(String fotoPerfil) {
		this.fotoPerfil = fotoPerfil;
		
	}
	public Estado getEstado() {
		return estado;
	}
	
	public void setEstado(Estado estado) {
		this.estado = estado;
	}
	
	public int getIntentosFallidos() {
		return intentosFallidos;
		
	}
	public void setIntentosFallidos(int intentosFallidos) {
		this.intentosFallidos = intentosFallidos;
	}
	
	public void setFechaAlta() {
		this.fechaAlta = LocalDate.now();
	}
	
	public LocalDate getFechaAlta() {
		return fechaAlta;
	}
	
	public void setFechaBaja(LocalDate fechaBaja) {
		this.fechaBaja= fechaBaja;
	}
	
	public LocalDate getFechaBaja() {
		return fechaBaja;
	}
	public void setUltimoIngreso() {
		this.ultimoIngreso= LocalDateTime.now();
	}
	public LocalDateTime getUltimoIngreso() {
		return ultimoIngreso;
	}
/*
	public ArrayList<Rol> getRoles() {
		return roles;
	}

	public void setRoles(ArrayList<Rol> roles) {
		this.roles = roles;
	}
*/
}
