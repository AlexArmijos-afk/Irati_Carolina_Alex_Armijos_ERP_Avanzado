package com.reto.erp.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.reto.erp.model.Rol;

@Repository("movimientostockRepository")
public interface MovimientoStockRepository extends JpaRepository<Rol, Long>{

}
