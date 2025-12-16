package com.reto.erp.Repository.luego;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.reto.erp.model.Rol;

@Repository("lineapedidoRepository")
public interface LineaPedidoRepository extends JpaRepository<Rol, Long>{

}
