package com.reto.erp.model;

import java.io.Serializable;

public class UsuarioDepartamentoRolId implements Serializable{
	private Long usuarioId;
    private Long departamentoId;
    private Long rolId;
	public UsuarioDepartamentoRolId(Long usuarioId, Long departamentoId, Long rolId) {
		super();
		this.usuarioId = usuarioId;
		this.departamentoId = departamentoId;
		this.rolId = rolId;
	}
	public UsuarioDepartamentoRolId() {
		super();
	}
    
    
}
