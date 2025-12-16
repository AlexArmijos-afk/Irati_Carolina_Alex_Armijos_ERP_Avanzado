package com.reto.erp.Service.Impl.luego;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.reto.erp.Repository.luego.PedidoRepository;
import com.reto.erp.Service.luego.PedidoService;
import com.reto.erp.model.luego.Pedido;

public class PedidoServiceImpl implements PedidoService{
	
	@Autowired
	private PedidoRepository pedidoRepository;
	
	@Override
	public List<Pedido> findAll() {
		return pedidoRepository.findAll();
	}

	@Override
	public Pedido findById(Long id) {
		return pedidoRepository.findById(id).orElse(null);
	}

	@Override
	public Pedido save(Pedido pedido) {
		return pedidoRepository.save(pedido);
	}

	@Override
	public void deleteById(Long id) {
		pedidoRepository.deleteById(id);
	}

}
