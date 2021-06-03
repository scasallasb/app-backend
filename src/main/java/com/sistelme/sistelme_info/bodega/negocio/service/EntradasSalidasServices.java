package com.sistelme.sistelme_info.bodega.negocio.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sistelme.sistelme_info.bodega.model.entity.EntradasSalidas;
import com.sistelme.sistelme_info.bodega.negocio.repository.EntradasSalidasRepository;

@Service
@Transactional(readOnly= true)
public class EntradasSalidasServices {
	private final EntradasSalidasRepository  entradasSalidasRepository;
	
	public EntradasSalidasServices(EntradasSalidasRepository entradasSalidasRepository ) {
		this.entradasSalidasRepository=entradasSalidasRepository ;
	}
	
	@Transactional
	public EntradasSalidas create(EntradasSalidas entradasSalidas) {
		return this.entradasSalidasRepository.save(entradasSalidas);
	}
	@Transactional
	public EntradasSalidas update(EntradasSalidas entradasSalidas) {
		return this.entradasSalidasRepository.save(entradasSalidas);
	}
	 @Transactional
	 public void delete(EntradasSalidas entradasSalidas) {
		 this.entradasSalidasRepository.delete(entradasSalidas);
	 }
	 
	 @Transactional
	 public EntradasSalidas findByCodigo(String codigo) {
		 return this.entradasSalidasRepository.findByCodigo(codigo);
	 }
	 
	 @Transactional
	 public List<EntradasSalidas> findByNombre(String nombre){
		 return this.entradasSalidasRepository.findByNombre(nombre);
	 }
	 @Transactional
	 public List<EntradasSalidas> findAll(){
		 return this.entradasSalidasRepository.findAll();
	 }
}
