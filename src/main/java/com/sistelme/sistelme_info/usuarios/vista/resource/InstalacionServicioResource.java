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
import com.sistelme.sistelme_info.usuarios.model.entity.InstalacionServicio;
import com.sistelme.sistelme_info.usuarios.negocio.service.InstalacionService;
import com.sistelme.sistelme_info.usuarios.negocio.service.InstalacionServicioService;
import com.sistelme.sistelme_info.usuarios.vista.resource.util.InstalacionServicioVo;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@CrossOrigin(origins = "http://localhost:4200",allowedHeaders = "*")
@RestController
@RequestMapping("api/instalacion/instalacion-servicio")
@Api(tags = "instalacion-servicio")
public class InstalacionServicioResource {
	
	private final InstalacionServicioService instalacionServicioService;
	private final InstalacionService instalacionService;
	
	public InstalacionServicioResource(InstalacionService instalacionService,InstalacionServicioService instalacionServicioService) {
		this.instalacionServicioService= instalacionServicioService;
		this.instalacionService=instalacionService;
		
	}
	
	/**
	 * método POST
	 */
	@PostMapping
	@ApiOperation(value = "Crear servicio en instalación", notes = "Servicio para crear un nuevo servicio en instalacion")
	@ApiResponses(value = { @ApiResponse(code = 201, message = "servicio en instalación creado correctamente"),
			@ApiResponse(code = 400, message = "Solicitud Inválida") })
	public ResponseEntity<InstalacionServicio> crear(@RequestBody InstalacionServicioVo instalacionServicioVo){
		Instalacion instalacion=this.instalacionService.findById(instalacionServicioVo.getInstalacion().getIdInstalacion()); 
		if (instalacion !=null) {
			InstalacionServicio instalacionServicio = new InstalacionServicio();
			instalacionServicio.setInstalacion(instalacion);
			instalacionServicio.setCantidad(instalacionServicioVo.getCantidad());;
			instalacionServicio.setConcepto(instalacionServicioVo.getConcepto());
			instalacionServicio.setV_unidad(instalacionServicioVo.getV_unidad());
			instalacionServicio.setV_total(instalacionServicioVo.getCantidad()*instalacionServicioVo.getV_unidad());
			return  new ResponseEntity<>(this.instalacionServicioService.create(instalacionServicio),HttpStatus.CREATED);
			
		}else {
			return new ResponseEntity<InstalacionServicio>(HttpStatus.NOT_FOUND);
		}
	}
	@PutMapping
	@ApiOperation(value = "actualizar servicio en instalación", notes = "Servicio para actualizar un nuevo servicio en instalacion")
	@ApiResponses(value = { @ApiResponse(code = 201, message = "servicio en instalación creado correctamente"),
			@ApiResponse(code = 400, message = "Solicitud Inválida") })
	public ResponseEntity<InstalacionServicio> update (@RequestBody InstalacionServicioVo instalacionServicioVo){
		if (this.instalacionServicioService.findById(instalacionServicioVo.getIdInstalacion_servicio())!= null){
			InstalacionServicio instalacionServicio = new InstalacionServicio();
			instalacionServicio.setCantidad(instalacionServicioVo.getCantidad());;
			instalacionServicio.setConcepto(instalacionServicioVo.getConcepto());
			instalacionServicio.setV_unidad(instalacionServicioVo.getV_unidad());
			instalacionServicio.setV_total(instalacionServicioVo.getCantidad()*instalacionServicioVo.getV_unidad());
			return  new ResponseEntity<>(this.instalacionServicioService.create(instalacionServicio),HttpStatus.CREATED);
		}else {
			return new ResponseEntity<InstalacionServicio>(HttpStatus.NOT_MODIFIED);
			}	
		}
	
	
	@DeleteMapping("/{id}")
	@ApiOperation(value = "Eliminar servicio de instalación", notes = "Servicio para eliminar un servicio de instalación")
	@ApiResponses(value = { @ApiResponse(code = 201, message = "servicio de instalación eliminado correctamente"),
			@ApiResponse(code = 404, message = "servicio de instalación no encontrado") })
	public void delete(@PathVariable("id") String idInstalacionServicio) {	
		InstalacionServicio instalacionServicio=this.instalacionServicioService.findById(idInstalacionServicio);
		if (instalacionServicio != null) {
		this.instalacionServicioService.delete(instalacionServicio);
			}
		}
	

	@GetMapping
	@ApiOperation(value = "Listar servicios de instalación", notes = "Servicio para listar todos los servicios de instalación")
	@ApiResponses(value = { @ApiResponse(code = 201, message = "servicios de instalación"),
			@ApiResponse(code = 404, message = "servicios de instalación no encontrados") })
	public ResponseEntity< List<InstalacionServicio> > findAll(){
		return ResponseEntity.ok(this.instalacionServicioService.findAll()); 
	}
	
	@GetMapping("/{idServicioInstalacion}")
	@ApiOperation(value = "Listar un servicio de instalación", notes = "Servicio para listar un servicios de instalación con el id")
	@ApiResponses(value = { @ApiResponse(code = 201, message = "servicios de instalación"),
			@ApiResponse(code = 404, message = "servicios de instalación no encontrados") })
	public ResponseEntity<InstalacionServicio> findByIdServiceInstalacion(@PathVariable("idServicioInstalacion") String idInstalacionServicio){	
		return ResponseEntity.ok(this.instalacionServicioService.findById(idInstalacionServicio)); 
	}
	
	@GetMapping("/detail/{idInstalacion}")
	@ApiOperation(value = "Listar servicios de instalación de una orden  instalación", notes = "Servicio para listar todos los servicios de instalación de una orden de instalación")
	@ApiResponses(value = { @ApiResponse(code = 201, message = "servicios de instalación"),
			@ApiResponse(code = 404, message = "servicios de instalación no encontrados") })
	public ResponseEntity<List<InstalacionServicio>> findByIdInstalacion(@PathVariable("idInstalacion") String idInstalacion){	
		Instalacion instalacion = this.instalacionService.findById(idInstalacion);
		if (instalacion != null) {
			return ResponseEntity.ok(this.instalacionServicioService.findByInstalacion(instalacion));
		}
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}
	
}

