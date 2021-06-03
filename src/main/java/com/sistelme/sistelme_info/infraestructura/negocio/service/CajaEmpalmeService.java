package com.sistelme.sistelme_info.infraestructura.negocio.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sistelme.sistelme_info.infraestructura.model.entity.CajaEmpalme;
import com.sistelme.sistelme_info.infraestructura.negocio.repository.CajaEmpalmeRepository;

@Service
public class CajaEmpalmeService {
	private final CajaEmpalmeRepository cajaEmpalmeRepository;
	
	public CajaEmpalmeService(CajaEmpalmeRepository cajaEmpalmerepository) {
		this.cajaEmpalmeRepository=cajaEmpalmerepository;	
	}
	
	@Transactional
	public CajaEmpalme create(CajaEmpalme cajaEmpalme) {
		return this.cajaEmpalmeRepository.save(cajaEmpalme);
	}
	@Transactional
	public CajaEmpalme update(CajaEmpalme cajaEmpalme) {
		return this.cajaEmpalmeRepository.save(cajaEmpalme);
	}
	 @Transactional
	 public void delete(CajaEmpalme cajaEmpalme) {
		 this.cajaEmpalmeRepository.delete(cajaEmpalme);
	 }
	 
	 @Transactional
	 public CajaEmpalme getByNomenclatura(String nomenclatura) {
		 return this.cajaEmpalmeRepository.findByNomenclatura(nomenclatura);
	 }
	 
	 @Transactional
	 public List<CajaEmpalme> getByTipo(String tipo){
		 return this.cajaEmpalmeRepository.findByTipo(tipo);
	 }
	 
	 @Transactional
	 public List<CajaEmpalme> getByMarca(String marca){
		 return this.cajaEmpalmeRepository.findByMarca(marca);
	 }
	 
	 @Transactional
	 public List<CajaEmpalme> getAll(){
		 return this.cajaEmpalmeRepository.findAll();	 
	 }
}
