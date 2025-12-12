package com.reto.erp.Service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.reto.erp.Repository.ClienteRepository;
import com.reto.erp.Service.ClienteService;
import com.reto.erp.model.Cliente;

public class ClienteServiceImpl implements ClienteService{

	@Autowired
	private ClienteRepository clienteRepository;
	
	@Override
	public List<Cliente> findAll() {
		return clienteRepository.findAll();	//recoger todos los clientes de la bbdd
	}

	@Override
	public Cliente findById(Long id) {
		return clienteRepository.findById(id).orElse(null);	//buscar cliente por ID, sino lo encuentra, devuelve null
	}

	@Override
	public Cliente save(Cliente cliente) {
		return clienteRepository.save(cliente);
	}

	@Override
	public void deleteById(Long id) {
		clienteRepository.deleteById(id);
	}

}
