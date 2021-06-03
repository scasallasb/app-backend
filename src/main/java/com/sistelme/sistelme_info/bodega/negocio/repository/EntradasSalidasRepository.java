package com.sistelme.sistelme_info.bodega.negocio.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sistelme.sistelme_info.bodega.model.entity.EntradasSalidas;

public interface EntradasSalidasRepository extends JpaRepository<EntradasSalidas, String> {
	public EntradasSalidas findByCodigo(String codigo);
	public List <EntradasSalidas> findByNombre(String nombre);
}
