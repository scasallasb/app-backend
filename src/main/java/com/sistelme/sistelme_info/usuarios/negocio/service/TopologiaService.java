package com.sistelme.sistelme_info.usuarios.negocio.service;

import java.util.List;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sistelme.sistelme_info.usuarios.model.entity.Topologia;
import com.sistelme.sistelme_info.usuarios.model.entity.Usuario;
import com.sistelme.sistelme_info.usuarios.negocio.repository.TopologiaRepository;



@Service
@Transactional(readOnly = true)
public class TopologiaService{
	
	 private final TopologiaRepository topologiaRepository;
	 
	 public TopologiaService (TopologiaRepository topologiaRepository) {
		 this.topologiaRepository= topologiaRepository;
	 }
	 
	 
	 @Transactional
	 public Topologia create(Topologia topologia) {
		 return this.topologiaRepository.save(topologia);
	 }
	 
	 @Transactional
	 public Topologia update(Topologia topologia) {
		 return this.topologiaRepository.save(topologia);
	 }
	 
	 @Transactional
	 public void delete(Topologia topologia) {
		 this.topologiaRepository.delete(topologia);
	 }
	 
	 @Transactional
	 public List<Topologia> findAll(){
		 return this.topologiaRepository.findAll();
	 }
	 
	 @Transactional
	 public Topologia findByUsario(Usuario usuario) {
		 return this.topologiaRepository.findByUsuario(usuario);
	 }
	 
}
