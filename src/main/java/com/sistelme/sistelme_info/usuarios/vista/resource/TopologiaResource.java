package com.sistelme.sistelme_info.usuarios.vista.resource;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sistelme.sistelme_info.usuarios.model.entity.Topologia;
import com.sistelme.sistelme_info.usuarios.model.entity.Usuario;
import com.sistelme.sistelme_info.usuarios.negocio.service.TopologiaService;
import com.sistelme.sistelme_info.usuarios.negocio.service.UsuarioService;
import com.sistelme.sistelme_info.usuarios.vista.resource.util.TopologiaVo;
@CrossOrigin(origins = "http://localhost:4200",allowedHeaders = "*")
@RestController
@RequestMapping("api/topologia")
public class TopologiaResource {
	
	
	
	private final TopologiaService topologiaService;
	private final UsuarioService usuarioService;
	public TopologiaResource(TopologiaService topologiaService, UsuarioService usuarioService) {
		 this.topologiaService=topologiaService;
		 this.usuarioService=usuarioService;
	}
	
	@PostMapping
	public ResponseEntity <Topologia> createTopologia(@RequestBody TopologiaVo topologiaVo){
		
		Usuario usuario = usuarioService.findByIdentificacion(topologiaVo.getUsuario().getIdentificationUser());
		Topologia topologia = new Topologia();
		
		topologia.setUsuario(usuario);
		
		topologia.setOLT(topologiaVo.getOLT());
		topologia.setPuerto(topologiaVo.getPuerto());
		topologia.setRamal(topologiaVo.getRamal());
		topologia.setCircuito(topologiaVo.getCircuito());
		topologia.setNAP(topologiaVo.getNAP());
		
		return new ResponseEntity<>(this.topologiaService.create(topologia), HttpStatus.CREATED);
		
	}
	
	
	@PutMapping("/{userIdentificacion}")
	public ResponseEntity <Topologia> updateTopologia(@PathVariable("userIdentificacion") String userId,@RequestBody TopologiaVo topologiaVo){
		
		Usuario usuario= this.usuarioService.findByIdentificacion(userId);
		Topologia topologia = new Topologia();
		if (usuario == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		
		else {
			
			topologia.setUsuario(usuario);
			
			topologia.setOLT(topologiaVo.getOLT());
			topologia.setPuerto(topologiaVo.getPuerto());
			topologia.setRamal(topologiaVo.getRamal());
			topologia.setCircuito(topologiaVo.getCircuito());
			topologia.setNAP(topologiaVo.getNAP());
			
			return new ResponseEntity<>(this.topologiaService.create(topologia), HttpStatus.CREATED);
					
		}
		
	}
	
	@DeleteMapping("/{identificacion}")
	void eliminarTopologia(@PathVariable("identificacion") String identificationUser) {
		Usuario usuario = this.usuarioService.findByIdentificacion(identificationUser);
			Topologia topologia = this.topologiaService.findByUsario(usuario);
			if (topologia != null) {
				this.topologiaService.delete(topologia);;
			}
		
	}
	
	@GetMapping("/{identificacion}")
	public ResponseEntity<Topologia> findByUserIdentification(@PathVariable("identificacion") String identificationUser){
		Usuario usuario = this.usuarioService.findByIdentificacion(identificationUser);
		Topologia topologia = this.topologiaService.findByUsario(usuario);
		if (topologia!= null) {
			return ResponseEntity.ok(topologia);
		}else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
	@GetMapping
	public ResponseEntity <List<Topologia>> findAll(){
		return  ResponseEntity.ok(this.topologiaService.findAll());
		
	} 
	
}
