package com.reto.erp.Service;

import java.util.List;
import com.reto.erp.model.DireccionEnvio;

public interface DireccionEnvioService {
	
	List<DireccionEnvio> findAll();
    
	DireccionEnvio findById(Long id);
    
	DireccionEnvio save(DireccionEnvio direccionEnvio);
    
	void deleteById(Long id);
}
