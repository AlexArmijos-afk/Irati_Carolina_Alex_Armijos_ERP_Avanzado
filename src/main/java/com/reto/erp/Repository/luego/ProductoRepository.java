package com.reto.erp.Repository.luego;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.reto.erp.model.Rol;

@Repository("productoRepository")
public interface ProductoRepository extends JpaRepository<Rol, Long>{

}
