package com.reto.erp.Repository.luego;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.reto.erp.model.luego.Pedido;

@Repository("pedidoRepository")
public interface PedidoRepository extends JpaRepository<Pedido, Long>{

}
