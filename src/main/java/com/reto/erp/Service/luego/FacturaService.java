package com.reto.erp.Service.luego;

import java.util.List;

import com.reto.erp.model.luego.Factura;

public interface FacturaService {

	List<Factura> findAll();
    
	Factura findById(Long id);
    
	Factura save(Factura factura);
    
	void deleteById(Long id);
}
