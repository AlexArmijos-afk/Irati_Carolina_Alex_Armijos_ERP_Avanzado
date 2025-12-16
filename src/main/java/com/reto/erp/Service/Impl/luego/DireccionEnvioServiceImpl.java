package com.reto.erp.Service.Impl.luego;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.reto.erp.Repository.luego.DireccionEnvioRepository;
import com.reto.erp.Service.luego.DireccionEnvioService;
import com.reto.erp.model.luego.DireccionEnvio;

public class DireccionEnvioServiceImpl implements DireccionEnvioService{
	
	@Autowired
	private DireccionEnvioRepository direccionEnvioRepository;
	
	@Override
	public List<DireccionEnvio> findAll() {
		return direccionEnvioRepository.findAll();
	}

	@Override
	public DireccionEnvio findById(Long id) {
		return direccionEnvioRepository.findById(id).orElse(null);
	}

	@Override
	public DireccionEnvio save(DireccionEnvio direccionEnvio) {
		return direccionEnvioRepository.save(direccionEnvio);
	}

	@Override
	public void deleteById(Long id) {
		direccionEnvioRepository.deleteById(id);
	}

}
