package com.reto.erp.Repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.reto.erp.model.Departamento;

@Repository("departamentoRepository")
public interface DepartamentoRepository extends JpaRepository<Departamento, Serializable>{

}
