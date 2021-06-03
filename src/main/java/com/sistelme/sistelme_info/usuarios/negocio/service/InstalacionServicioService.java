package com.sistelme.sistelme_info.usuarios.negocio.service;

import java.util.List;



import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sistelme.sistelme_info.usuarios.model.entity.Instalacion;
import com.sistelme.sistelme_info.usuarios.model.entity.InstalacionServicio;
import com.sistelme.sistelme_info.usuarios.negocio.repository.InstalacionServicioRepository;

@Service
@Transactional(readOnly = true)
public class InstalacionServicioService {
	final private InstalacionServicioRepository instalacionServicioRepository;
	
	public InstalacionServicioService(InstalacionServicioRepository instalacionRepository) {
		this.instalacionServicioRepository= instalacionRepository;
	}
	
	@Transactional
	public InstalacionServicio create(InstalacionServicio instalacionServicio) {
		return this.instalacionServicioRepository.save(instalacionServicio);
	}
	@Transactional
	public InstalacionServicio update(InstalacionServicio instalacionServicio) {
		return this.instalacionServicioRepository.save(instalacionServicio);
	}
	@Transactional
	public void delete(InstalacionServicio instalacionServicio) {
		 this.instalacionServicioRepository.delete(instalacionServicio);
	}
	
	public List<InstalacionServicio> findAll(){
		return this.instalacionServicioRepository.findAll();
	} 
	public List<InstalacionServicio> findByInstalacion(Instalacion instalacion){
		return this.instalacionServicioRepository.findByInstalacion(instalacion);
		
	}
	@Transactional
	public InstalacionServicio findById(String idInstalacionServicio) {
		return this.instalacionServicioRepository.findByIdInstalacionServicio(idInstalacionServicio);
	}
	@Transactional
	public void deleteAll() {
		 this.instalacionServicioRepository.deleteAll();
	}
	
	
}
