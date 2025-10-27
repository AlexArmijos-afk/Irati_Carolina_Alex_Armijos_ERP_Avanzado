package com.reto.erp.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "usuario_departamento_rol") // nombre exacto de la tabla en la BD
@IdClass(UsuarioDepartamentoRolId.class)
public class UsuarioDepartamentoRol {
	
	@Id
    private Long usuarioId;

    @Id
    private Long departamentoId;

    @Id
    private Long rolId;

    @ManyToOne
    @JoinColumn(name = "usuarioId", insertable = false, updatable = false)// columna en esta tabla (UsuarioDepartamentoRol) que actúa como FK.
    private Usuario usuario;

    @ManyToOne
    @JoinColumn(name = "departamentoId", insertable = false, updatable = false)
    private Departamento departamento;

    @ManyToOne
    @JoinColumn(name = "rolId", insertable = false, updatable = false)
    private Rol rol;
	
	
}
