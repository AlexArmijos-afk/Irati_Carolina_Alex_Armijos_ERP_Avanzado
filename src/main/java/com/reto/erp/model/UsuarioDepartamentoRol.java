package com.reto.erp.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name="UsuarioDepartamentoRol")
public class UsuarioDepartamentoRol {
	
	private Usuario usuario;
	
	private Departamento departamento;
	
	private Rol rol;
	
	
}
