package com.reto.erp.Service;

import java.util.List;

import com.reto.erp.model.Rol;

public interface RolService {
	public abstract Rol aniadirRol(Rol rol);
	public List<Rol> findAll();
	public List<Rol> findAllById(List<Long> rolesIds);
}
