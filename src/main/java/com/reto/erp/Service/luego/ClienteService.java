package com.reto.erp.Service.luego;

import java.util.List;

import com.reto.erp.model.luego.Cliente;

public interface ClienteService {
	
	List<Cliente> findAll();
    
	Cliente findById(Long id);
    
	Cliente save(Cliente cliente);
    
	void deleteById(Long id);
}
