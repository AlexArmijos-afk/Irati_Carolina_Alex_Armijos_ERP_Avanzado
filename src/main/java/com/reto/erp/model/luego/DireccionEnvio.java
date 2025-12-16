package com.reto.erp.model.luego;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="DireccionEnvio")
public class DireccionEnvio {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) //MySQL: auto_increment
	private long id; 
	
	@ManyToOne(optional = false)  
	@JoinColumn(name = "pedido_id", nullable = false) 
	private Pedido pedido;
	
	@Column(nullable = false) //MySQL: not null
	private String nombreContacto;
	
	@Column(nullable = false, unique = true) //MySQL: not null
	private String direccion;
	
	@Column(nullable = false)
	private String ciudad;
	
	@Column(nullable = false)
	private String cp;
	
	@Column(nullable = false)
	private String pais;
	
	
	@Column(name = "telefono_contacto", nullable = false)
	private String telefonoContacto;
	
	public DireccionEnvio() {}

}

