package com.reto.erp.Service;

import java.util.List;
import com.reto.erp.model.Cliente;

public interface ClienteService {
	
	List<Cliente> findAll();
    
	Cliente findById(Long id);
    
	Cliente save(Cliente cliente);
    
	void deleteById(Long id);
}
