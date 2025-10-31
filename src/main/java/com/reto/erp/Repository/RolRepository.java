package com.reto.erp.Repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.reto.erp.model.Rol;

@Repository("rolRepository")
public interface RolRepository extends JpaRepository<Rol, Serializable>{

}
