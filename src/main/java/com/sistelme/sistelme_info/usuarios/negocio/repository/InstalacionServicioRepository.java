package com.sistelme.sistelme_info.usuarios.negocio.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.sistelme.sistelme_info.usuarios.model.entity.Instalacion;
import com.sistelme.sistelme_info.usuarios.model.entity.InstalacionServicio;

public interface InstalacionServicioRepository extends JpaRepository<InstalacionServicio, String>{
	
	@Query("Select i from InstalacionServicio i where i.instalacion =:instalacion")
	public List<InstalacionServicio> findByInstalacion(Instalacion instalacion );
	
	public InstalacionServicio findByIdInstalacionServicio(String idInstalacionServicio);

}
