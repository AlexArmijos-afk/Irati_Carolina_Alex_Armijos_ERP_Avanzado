package com.reto.erp.Service.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.reto.erp.Repository.DepartamentoRepository;
import com.reto.erp.Service.DepartamentoService;
import com.reto.erp.model.Departamento;

@Service("departamentoServiceImpl")
public class DepartamentoServiceImpl implements DepartamentoService{
	
	@Autowired
	@Qualifier("departamentoRepository")
	DepartamentoRepository departamentorepository;
	
	@Override
	public Departamento aniadirDepartamento(Departamento departamento) {
		return departamentorepository.save(departamento);
	}
	
}
