package com.reto.erp.Service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.reto.erp.Repository.FacturaRepository;
import com.reto.erp.Service.FacturaService;
import com.reto.erp.model.Factura;

public class FacturaServiceImpl implements FacturaService{
	@Autowired
	private FacturaRepository facturaRepository;
	
	@Override
	public List<Factura> findAll() {
		return facturaRepository.findAll();
	}

	@Override
	public Factura findById(Long id) {
		return facturaRepository.findById(id).orElse(null);
	}

	@Override
	public Factura save(Factura factura) {
		return facturaRepository.save(factura);
	}

	@Override
	public void deleteById(Long id) {
		facturaRepository.deleteById(id);
	}

}
