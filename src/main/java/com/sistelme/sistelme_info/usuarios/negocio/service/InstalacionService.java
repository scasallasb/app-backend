package com.sistelme.sistelme_info.usuarios.negocio.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sistelme.sistelme_info.usuarios.model.entity.Instalacion;
import com.sistelme.sistelme_info.usuarios.model.entity.Usuario;
import com.sistelme.sistelme_info.usuarios.negocio.repository.InstalacionRepository;

@Service
@Transactional(readOnly = true)
public class InstalacionService {
	private final InstalacionRepository instalacionRepository ;
	
	public InstalacionService(InstalacionRepository instalacionRepository ) {
		this.instalacionRepository= instalacionRepository;
	}
	
	@Transactional
	public Instalacion create(Instalacion instalacion) {
		return this.instalacionRepository.save(instalacion);
	}
	@Transactional
	public Instalacion update(Instalacion instalacion) {
		return this.instalacionRepository.save(instalacion);
	}
	@Transactional
	public void delete(Instalacion instalacion) {
		this.instalacionRepository.delete(instalacion);
	}
	@Transactional
	public List <Instalacion> findAll(){
		return this.instalacionRepository.findAll();
	}
	@Transactional
	public List<Instalacion> findByUser(Usuario usuario){
		return this.instalacionRepository.findByUsuario(usuario);
	}
	@Transactional
	public Instalacion findById(String idInstalacion) {
		return this.instalacionRepository.findByIdInstalacion(idInstalacion);
		
	}
	
}
