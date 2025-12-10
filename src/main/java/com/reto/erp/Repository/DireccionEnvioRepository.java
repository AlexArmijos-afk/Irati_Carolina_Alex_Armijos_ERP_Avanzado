package com.reto.erp.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.reto.erp.model.DireccionEnvio;

@Repository("direccionEnvioRepository")
public interface DireccionEnvioRepository extends JpaRepository<DireccionEnvio, Long>{

}
