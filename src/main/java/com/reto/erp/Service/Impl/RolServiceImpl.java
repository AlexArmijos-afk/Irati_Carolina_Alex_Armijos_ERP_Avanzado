package com.reto.erp.Service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.reto.erp.Repository.RolRepository;
import com.reto.erp.Service.RolService;
import com.reto.erp.model.Rol;

@Service("rolServiceImpl")
public class RolServiceImpl implements RolService{
	
	@Autowired
	@Qualifier("rolRepository")
	RolRepository rolrepository;
	
	@Override
	public Rol aniadirRol(Rol rol) {
		return rolrepository.save(rol);
	}
	@Override
	public List<Rol> findAll() {
		return rolrepository.findAll();
	}
	@Override
	public List<Rol> findAllById(List<Long> rolesIds) {
	    return rolrepository.findAllById(rolesIds);
	}


}
