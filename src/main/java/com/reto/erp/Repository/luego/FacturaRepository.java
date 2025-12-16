package com.reto.erp.Repository.luego;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.reto.erp.model.luego.Factura;

@Repository("facturaRepository")
public interface FacturaRepository extends JpaRepository<Factura, Long>{

}
