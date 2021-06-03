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

import com.sistelme.sistelme_info.usuarios.model.entity.Instalacion;
import com.sistelme.sistelme_info.usuarios.model.entity.Usuario;
import com.sistelme.sistelme_info.usuarios.negocio.service.InstalacionService;
import com.sistelme.sistelme_info.usuarios.negocio.service.UsuarioService;
import com.sistelme.sistelme_info.usuarios.vista.resource.util.InstalacionVo;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@CrossOrigin(origins = "http://localhost:4200",allowedHeaders = "*")
@RestController
@RequestMapping("api/instalacion")
public class InstalacionResource {
	
	private final InstalacionService instalacionService;
	private final UsuarioService usuarioService;
	
	public InstalacionResource(InstalacionService instalacionService,UsuarioService usuarioService) {
		this.instalacionService=instalacionService;
		this.usuarioService= usuarioService;
	}
	
	@PostMapping
	@ApiOperation(value = "Crear instalación", notes = "Servicio para crear una nueva instalacion")
	@ApiResponses(value = { @ApiResponse(code = 201, message = "instalación creada correctamente"),
			@ApiResponse(code = 400, message = "Solicitud Inválida") })
	public ResponseEntity<Instalacion> create(@RequestBody InstalacionVo instalacionVo){
		Usuario usuario = usuarioService.findByIdentificacion(instalacionVo.getUsuario().getIdentificationUser());
		if (usuario!= null) {
			Instalacion instalacion = new Instalacion();	
			instalacion.setUsuario(usuario);
			instalacion.setFechaInstalacion(instalacionVo.getFechaInstalacion());
			instalacion.setObservaciones(instalacionVo.getObservaciones());
			return 	 new ResponseEntity <> (this.instalacionService.create(instalacion), HttpStatus.CREATED);	
		}
			return new ResponseEntity<Instalacion>(HttpStatus.NOT_FOUND);
	}
	
	@PutMapping
	public ResponseEntity<Instalacion> update(@RequestBody InstalacionVo instalacionVo){
		
		Instalacion instalacion = instalacionService.findById(instalacionVo.getIdInstalacion());
		if (instalacion != null) {
		instalacion.setIdInstalacion(instalacionVo.getIdInstalacion());
		instalacion.setObservaciones(instalacionVo.getObservaciones());
		instalacion.setFechaProgramada(instalacionVo.getFechaProgramada());
		instalacion.setFechaInstalacion(instalacionVo.getFechaInstalacion());
		instalacion.setUsuario(instalacionVo.getUsuario());
		return 	 new ResponseEntity <> (this.instalacionService.update(instalacion), HttpStatus.CREATED);	
		}else {
			return new ResponseEntity<Instalacion>(HttpStatus.NOT_FOUND);
		}
	}
	
	@DeleteMapping("/{identificacion-instalacion}")
	public void delete(@PathVariable("identificacion-instalacion") String id) {
		Instalacion instalacion = this.instalacionService.findById(id);
		if (instalacion!= null) {
		this.instalacionService.delete(instalacion);
		}
	}
	
	
	@GetMapping("identificacion/{identificacion}")
	public ResponseEntity<List<Instalacion>> findByUserIdentification(@PathVariable("identificacion") String identificationUser){
		Usuario usuario = this.usuarioService.findByIdentificacion(identificationUser);
		List<Instalacion> instalacion = this.instalacionService.findByUser(usuario);
		if (instalacion != null) {
			return ResponseEntity.ok(instalacion);
		}else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	@GetMapping("/{id}")
	public ResponseEntity<Instalacion> findById(@PathVariable("id")String idInstalacion){
		Instalacion instalacion = this.instalacionService.findById(idInstalacion);
		if (instalacion != null) {
			return ResponseEntity.ok(instalacion);
		}
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}
	
	
	@GetMapping 
	public ResponseEntity<List<Instalacion>> findAll(){
		return ResponseEntity.ok(this.instalacionService.findAll());
	}

}
