package com.sistelme.sistelme_info.usuarios.negocio.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.sistelme.sistelme_info.usuarios.model.entity.Instalacion;
import com.sistelme.sistelme_info.usuarios.model.entity.Usuario;


public interface InstalacionRepository extends JpaRepository <Instalacion, String>{

	@Query("Select i from Instalacion i where i.usuario =:usuario")
	public List<Instalacion> findByUsuario(Usuario usuario );
	
	public Instalacion findByIdInstalacion(String idInstalacion);
	
}
