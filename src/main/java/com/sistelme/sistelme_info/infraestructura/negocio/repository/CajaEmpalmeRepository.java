package com.sistelme.sistelme_info.infraestructura.negocio.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sistelme.sistelme_info.infraestructura.model.entity.CajaEmpalme;

public interface CajaEmpalmeRepository extends JpaRepository<CajaEmpalme, String>{
	
	public List<CajaEmpalme> findByTipo(String tipo);
	
	public CajaEmpalme findByNomenclatura(String nomenclatura);
	
	public List<CajaEmpalme> findByMarca(String marca);
}
