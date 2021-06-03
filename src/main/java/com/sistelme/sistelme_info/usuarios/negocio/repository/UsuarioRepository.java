package com.sistelme.sistelme_info.usuarios.negocio.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sistelme.sistelme_info.usuarios.model.entity.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, String>{
	public Usuario findByIdentificationUser(String identificationUser);
	
	public Usuario findByIdUser (String  idUser);
	
	public List <Usuario> findByCodigoUser(String codigoUser);
	
	public List<Usuario> findByNombreUser(String nombreUser);

	public List <Usuario> findByApellidoUser(String apellidoUser);
	
	
}
