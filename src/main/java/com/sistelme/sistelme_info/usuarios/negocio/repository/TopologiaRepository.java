package com.sistelme.sistelme_info.usuarios.negocio.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.sistelme.sistelme_info.usuarios.model.entity.Topologia;
import com.sistelme.sistelme_info.usuarios.model.entity.Usuario;

public interface TopologiaRepository extends JpaRepository <Topologia, String>{

	@Query("Select t from Topologia t where t.usuario =:usuario")
	public Topologia findByUsuario(Usuario usuario );

	public Topologia findByIdTopologia(String idTopologia );
}
