package com.sistelme.sistelme_info.usuarios.negocio.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sistelme.sistelme_info.usuarios.model.entity.InstalacionServicio;
import com.sistelme.sistelme_info.usuarios.model.entity.ServicioInstalado;
import com.sistelme.sistelme_info.usuarios.negocio.repository.ServicioInstaladoRepository;

@Service
@Transactional(readOnly = true)
public class ServicioInstaladoService {
	private final ServicioInstaladoRepository servicioInstaladorepository;
	
	
	public ServicioInstaladoService(ServicioInstaladoRepository servicioInstaladorepository){
		this.servicioInstaladorepository= servicioInstaladorepository;
	}
	@Transactional
	public ServicioInstalado create (ServicioInstalado servicioInstalado) {
		return this.servicioInstaladorepository.save(servicioInstalado);
	}
	
	@Transactional
	public ServicioInstalado update(ServicioInstalado servicioInstalado) {
		return this.servicioInstaladorepository.save(servicioInstalado);
	}
	@Transactional
	public void delete(ServicioInstalado servicioInstalado) {
		this.servicioInstaladorepository.delete(servicioInstalado);
	} 
	@Transactional
	public void deleteAll() {
		this.servicioInstaladorepository.deleteAll();
	} 
	@Transactional
	public List<ServicioInstalado> findAll(){
		return this.servicioInstaladorepository.findAll();
	}
	
	@Transactional
	public List<ServicioInstalado>findByInstalacionServicio(InstalacionServicio instalacionServicio) {
		return this.servicioInstaladorepository.findByInstalacionServicio(instalacionServicio);
	} 
	@Transactional
	public ServicioInstalado findByIdInstalacionServicio(String idInstalacionServico) {
		return this.findByIdInstalacionServicio(idInstalacionServico);
	}
	@Transactional
	public ServicioInstalado findByIp(String ip) {
		return this.findByIp(ip);
	}
}
