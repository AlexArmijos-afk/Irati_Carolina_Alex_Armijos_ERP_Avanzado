package com.reto.erp.Service.luego;

import java.util.List;

import com.reto.erp.model.luego.Pedido;

public interface PedidoService {
	List<Pedido> findAll();
    
	Pedido findById(Long id);
    
	Pedido save(Pedido pedido);
    
	void deleteById(Long id);
}

