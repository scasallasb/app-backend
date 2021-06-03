package com.sistelme.sistelme_info.usuarios.negocio.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sistelme.sistelme_info.usuarios.model.entity.Usuario;
import com.sistelme.sistelme_info.usuarios.negocio.repository.UsuarioRepository;

@Service
@Transactional(readOnly= true)
public class UsuarioService {
	
	private final UsuarioRepository usuarioRepository;
	
	
	public UsuarioService(UsuarioRepository  usuarioRepository) {
		this.usuarioRepository= usuarioRepository;
	}
	
	@Transactional
	public Usuario create(Usuario usuario) {
		return this.usuarioRepository.save(usuario);
	}
	
	@Transactional
	public Usuario update(Usuario usuario) {
		return this.usuarioRepository.save(usuario);
	}
	@Transactional
	public void delete(Usuario usuario) {
		this.usuarioRepository.delete(usuario);
	}
	
	@Transactional
	public Usuario findById(String  id ) {
		return this.usuarioRepository.findByIdUser(id);
		
	}
	@Transactional
	public Usuario findByIdentificacion(String identificationUser) {
		return this.usuarioRepository.findByIdentificationUser(identificationUser);
		
	}
	
	@Transactional
	public List <Usuario> findByCodigo(String codigo){
		return this.usuarioRepository.findByCodigoUser(codigo);
	}
	@Transactional
	public List <Usuario> findByNombre(String nombre){
		return this.usuarioRepository.findByNombreUser(nombre);
	}
	@Transactional 
	public List<Usuario> findByApellido(String apellido){
		return this.usuarioRepository.findByApellidoUser(apellido);
	}
	
	@Transactional
	public List<Usuario> findAll(){
		return this.usuarioRepository.findAll();
	}
}
