package com.reto.erp.model.luego;

import java.time.LocalDateTime;
import java.util.Objects;

import com.reto.erp.model.Usuario;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="Cliente")
public class Cliente {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) //MySQL: auto_increment
	private long id; 
	
	@Column(nullable = false) //MySQL: not null
	private String nombreFiscal;
	
	@Column(nullable = false, unique = true) //MySQL: not null
	private String cifNif;
	
	@Column(nullable = false)
	private String email;
	
	@Column(nullable = false)
	private String telefono;
	
	@Column(nullable = false)
	private String direccion;
	
	@Column(nullable = false)
	private String ciudad;
	
	@Column(nullable = false)
	private String cp;
	
	@Column(nullable = false)
	private String pais;
	
	@Column(name = "fecha_alta", nullable = false)
	private LocalDateTime fechaAlta = LocalDateTime.now();
	
	@Column(nullable = false)
	private boolean activo = true; //MySQL: default = true
	
	@ManyToOne(optional = false)  // un cliente SIEMPRE tiene un usuario
	@JoinColumn(name = "usuario_id", nullable = false) 
	private Usuario usuario;
	
	public Cliente() {}

	public Cliente(long id, String nombreFiscal, String cifNif, String email, String telefono, String direccion,
			String ciudad, String cp, String pais, LocalDateTime fechaAlta, boolean activo, Usuario usuario) {
		super();
		this.id = id;
		this.nombreFiscal = nombreFiscal;
		this.cifNif = cifNif;
		this.email = email;
		this.telefono = telefono;
		this.direccion = direccion;
		this.ciudad = ciudad;
		this.cp = cp;
		this.pais = pais;
		this.fechaAlta = fechaAlta;
		this.activo = activo;
		this.usuario = usuario;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNombreFiscal() {
		return nombreFiscal;
	}

	public void setNombreFiscal(String nombreFiscal) {
		this.nombreFiscal = nombreFiscal;
	}

	public String getCifNif() {
		return cifNif;
	}

	public void setCifNif(String cifNif) {
		this.cifNif = cifNif;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getCiudad() {
		return ciudad;
	}

	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
	}

	public String getCp() {
		return cp;
	}

	public void setCp(String cp) {
		this.cp = cp;
	}

	public String getPais() {
		return pais;
	}

	public void setPais(String pais) {
		this.pais = pais;
	}

	public LocalDateTime getFechaAlta() {
		return fechaAlta;
	}

	public void setFechaAlta(LocalDateTime fechaAlta) {
		this.fechaAlta = fechaAlta;
	}

	public boolean isActivo() {
		return activo;
	}

	public void setActivo(boolean activo) {
		this.activo = activo;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	@Override
	public int hashCode() {
		return Objects.hash(activo, cifNif, ciudad, cp, direccion, email, fechaAlta, id, nombreFiscal, pais, telefono,
				usuario);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Cliente other = (Cliente) obj;
		return activo == other.activo && Objects.equals(cifNif, other.cifNif) && Objects.equals(ciudad, other.ciudad)
				&& Objects.equals(cp, other.cp) && Objects.equals(direccion, other.direccion)
				&& Objects.equals(email, other.email) && Objects.equals(fechaAlta, other.fechaAlta) && id == other.id
				&& Objects.equals(nombreFiscal, other.nombreFiscal) && Objects.equals(pais, other.pais)
				&& Objects.equals(telefono, other.telefono) && Objects.equals(usuario, other.usuario);
	}
	
	
}