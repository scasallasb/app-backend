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

import com.sistelme.sistelme_info.usuarios.model.entity.InstalacionServicio;
import com.sistelme.sistelme_info.usuarios.model.entity.ServicioInstalado;
import com.sistelme.sistelme_info.usuarios.negocio.service.InstalacionServicioService;
import com.sistelme.sistelme_info.usuarios.negocio.service.ServicioInstaladoService;
import com.sistelme.sistelme_info.usuarios.vista.resource.util.ServicioInstaladoVo;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@CrossOrigin(origins = "http://localhost:4200",allowedHeaders = "*")
@RestController
@RequestMapping("api/servicio-instalado")
@Api(tags = "servicio-instalado")
public class ServicioInstaladoResource {
		private final ServicioInstaladoService servicioInstaladoService;
		private final InstalacionServicioService instalacionServicioService;
		
	public ServicioInstaladoResource(ServicioInstaladoService servicioInstaladoService,InstalacionServicioService instalacionServicioService) {
		this.servicioInstaladoService= servicioInstaladoService;
		this.instalacionServicioService= instalacionServicioService;
	}
	
	@PostMapping
	@ApiOperation(value = "Crear servicio instalado", notes = "Servicio para crear un nuevo servicio instalado")
	@ApiResponses(value = { @ApiResponse(code = 201, message = "Servicio instaldo creado correctamente"),
			@ApiResponse(code = 400, message = "Solicitud Inválida") })
	public ResponseEntity<ServicioInstalado> crear(@RequestBody ServicioInstaladoVo servicioInstaladoVo){
		InstalacionServicio instalacionServicio = this.instalacionServicioService.findById(servicioInstaladoVo.getInstalacionServicio().getIdInstalacionServicio());
		if (instalacionServicio != null) {
			ServicioInstalado servicioInstalado= new ServicioInstalado();
			servicioInstalado.setInstalacionServicio(servicioInstaladoVo.getInstalacionServicio());
			servicioInstalado.setIp(servicioInstaladoVo.getIp());
			servicioInstalado.setMacOnt(servicioInstaladoVo.getMacOnt());
			servicioInstalado.setMacTvBox(servicioInstaladoVo.getMacTvBox());
			servicioInstalado.setDrop(servicioInstaladoVo.getDrop());
			servicioInstalado.setCable_av(servicioInstaladoVo.getCable_av());
			servicioInstalado.setUtp(servicioInstaladoVo.getUtp());
			return new ResponseEntity<>(this.servicioInstaladoService.create(servicioInstalado),HttpStatus.ACCEPTED);
			
		}
		return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
	}
	
	@PutMapping
	@ApiOperation(value = "Actualizar servicio instalado", notes = "Servicio para actualizar un nuevo servicio instalado")
	@ApiResponses(value = { @ApiResponse(code = 201, message = "instalación actualizada correctamente"),
			@ApiResponse(code = 400, message = "Solicitud Inválida") })
	public ResponseEntity<ServicioInstalado > actualizar(@RequestBody ServicioInstaladoVo servicioInstaladoVo){
		
	  if (this.servicioInstaladoService.findByIdInstalacionServicio(servicioInstaladoVo.getIdServicioInstalado())!= null) {
		  ServicioInstalado servicioInstalado= new ServicioInstalado();
		  servicioInstalado.setInstalacionServicio(servicioInstaladoVo.getInstalacionServicio());
		  servicioInstalado.setIp(servicioInstaladoVo.getIp());
		  servicioInstalado.setMacOnt(servicioInstaladoVo.getMacOnt());
		  servicioInstalado.setMacTvBox(servicioInstaladoVo.getMacTvBox());
		  servicioInstalado.setMacTvBox(servicioInstaladoVo.getMacTvBox());
		  servicioInstalado.setDrop(servicioInstaladoVo.getDrop());
		  servicioInstalado.setCable_av(servicioInstaladoVo.getCable_av());
	      servicioInstalado.setUtp(servicioInstaladoVo.getUtp());
		  return new ResponseEntity<>(this.servicioInstaladoService.create(servicioInstalado),HttpStatus.ACCEPTED);
		  
	  }
	  return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
	}
	
	@DeleteMapping("/{id}")
	@ApiOperation(value = "Eliminar servicio de instalación", notes = "Servicio para eliminar un servicio de instalación")
	@ApiResponses(value = { @ApiResponse(code = 201, message = "servicio de instalación eliminado correctamente"),
			@ApiResponse(code = 404, message = "servicio de instalación no encontrado") })
	public void borrar(@PathVariable("id") String idInstalacionServico) {
		ServicioInstalado servicioInstalado= this.servicioInstaladoService.findByIdInstalacionServicio(idInstalacionServico);
		if (servicioInstalado != null) {
			this.servicioInstaladoService.delete(servicioInstalado);
		}
	}

		
	@GetMapping
	@ApiOperation(value = "Listar servicios instalados", notes = "Servicio para listar todos los servicios instalados")
	@ApiResponses(value = { @ApiResponse(code = 201, message = "servicios instalados"),
			@ApiResponse(code = 404, message = "servicios instalados no encontrados") })
	public ResponseEntity< List<ServicioInstalado>> findAll ( ){
		return ResponseEntity.ok(this.servicioInstaladoService.findAll());
	}
}









