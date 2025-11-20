package com.reto.erp.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.reto.erp.model.UsuarioDepartamentoRol;
import com.reto.erp.model.UsuarioDepartamentoRolId;

@Repository("udrRepository")
public interface UsuarioDepartamentoRolRepository extends JpaRepository<UsuarioDepartamentoRol, UsuarioDepartamentoRolId>{

}
