package com.sistelme.sistelme_info.bodega.vista.resource;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sistelme.sistelme_info.bodega.model.entity.EntradasSalidas;
import com.sistelme.sistelme_info.bodega.negocio.service.EntradasSalidasServices;
import com.sistelme.sistelme_info.bodega.vista.resource.util.EntradasSalidasVo;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("api/bodega/entradas-salidas")
@Api(tags = "entradas-salidas")
public class EntradasSalidasResource {
			
	
	private final EntradasSalidasServices entradasSalidasService;
	
	public EntradasSalidasResource(EntradasSalidasServices entradasSalidasService) {
		this.entradasSalidasService= entradasSalidasService;
	}
	
	@ApiOperation(value = "Crear entrada-salida", notes = "Servicio para crear una nueva entrada-salida")
	@ApiResponses(value = { @ApiResponse(code = 201, message = "Entrada-salida creada correctamente"),
			@ApiResponse(code = 400, message = "Solicitud Inválida"),
			@ApiResponse(code = 304, message = "Entrada-salida ya existe")})
	@PostMapping
	public ResponseEntity <EntradasSalidas> Create(@RequestBody EntradasSalidasVo entradasSalidasVo){
		EntradasSalidas entradasSalidas = new EntradasSalidas();
		
		entradasSalidas.setCodigo(entradasSalidasVo.getCodigo());
		entradasSalidas.setNombre(entradasSalidasVo.getNombre());
	
		
		entradasSalidas.setFecha_de_entrada(entradasSalidasVo.getFecha_de_entrada());
		entradasSalidas.setFecha_de_salida(entradasSalidasVo.getFecha_de_salida());
		
		entradasSalidas.setUbicacion(entradasSalidasVo.getUbicacion());
		
		entradasSalidas.setExistencias(entradasSalidasVo.getExistencias());
		entradasSalidas.setSaldo(entradasSalidasVo.getSaldo());
		
		entradasSalidas.setObservaciones(entradasSalidasVo.getObservaciones());
		entradasSalidas.setCodigoSistelme(entradasSalidasVo.getCodigoSistelme());
		
		return new ResponseEntity<>  (this.entradasSalidasService.create(entradasSalidas), HttpStatus.CREATED);

	}
	

	@ApiOperation(value = "Actualizar  entrada-salida", notes = "Servicio para actualizar una entrada-salida")
	@ApiResponses(value = { @ApiResponse(code = 201, message = "Entrada-salida actualizar correctamente"),
			@ApiResponse(code = 400, message = "Solicitud Inválida"),
			@ApiResponse(code = 304, message = "Entrada-salida ya existe")})
	@PutMapping
	public ResponseEntity <EntradasSalidas> Update(@RequestBody EntradasSalidasVo entradasSalidasVo){
		EntradasSalidas entradasSalidas= this.entradasSalidasService.findByCodigo(entradasSalidasVo.getCodigo());
		if(entradasSalidas!=null) {
			entradasSalidas.setCodigo(entradasSalidasVo.getCodigo());
			entradasSalidas.setNombre(entradasSalidasVo.getNombre());
		
			
			entradasSalidas.setFecha_de_entrada(entradasSalidasVo.getFecha_de_entrada());
			entradasSalidas.setFecha_de_salida(entradasSalidasVo.getFecha_de_salida());
			
			entradasSalidas.setUbicacion(entradasSalidasVo.getUbicacion());
			
			entradasSalidas.setExistencias(entradasSalidasVo.getExistencias());
			entradasSalidas.setSaldo(entradasSalidasVo.getSaldo());
			
			entradasSalidas.setObservaciones(entradasSalidasVo.getObservaciones());
			entradasSalidas.setCodigoSistelme(entradasSalidasVo.getCodigoSistelme());
			return new ResponseEntity<>(this.entradasSalidasService.create(entradasSalidas), HttpStatus.CREATED);
					
		}else {
			return new ResponseEntity <>(HttpStatus.NOT_MODIFIED);
		}
	}
	
	@ApiOperation(value = "Eliminar  entrada-salida", notes = "Servicio para eliminar una entrada-salida con código")
	@ApiResponses(value = { @ApiResponse(code = 201, message = "Entrada-salida eliminar correctamente"),
			@ApiResponse(code = 400, message = "Solicitud Inválida")})
	@DeleteMapping("/{codigo}")
	public void Delete(@PathVariable("codigo") String codigo) {
		EntradasSalidas entradaSalidas= this.entradasSalidasService.findByCodigo(codigo);
		if (entradaSalidas != null) {
			this.entradasSalidasService.delete(entradaSalidas);
		}
	}
		
		
	@GetMapping
	@ApiOperation(value = "Obtener todas las entidades entrada-salida", notes = "Servicio para obtener una entrada-salida con código")
	@ApiResponses(value = { @ApiResponse(code = 201, message = "Entrada-salida obtenida correctamente"),
			@ApiResponse(code = 400, message = "Solicitud Inválida")})
	public ResponseEntity<List<EntradasSalidas>> findAll(){
		return ResponseEntity.ok(this.entradasSalidasService.findAll());
		
	}
	
	@GetMapping("/nombre/{nombre}")
	@ApiOperation(value = "Obtener todas las entidades entrada-salida con el nombre", notes = "Servicio para obtener las entidades entrada-salida con nombre")
	@ApiResponses(value = { @ApiResponse(code = 201, message = "Entrada-salida obtenida correctamente"),
			@ApiResponse(code = 400, message = "Solicitud Inválida")})
	public ResponseEntity<List<EntradasSalidas>>findByNombre(@PathVariable("nombre")String nombre){
		return ResponseEntity.ok(this.entradasSalidasService.findByNombre(nombre))	;
	}
	
	@GetMapping("/codigo/{codigo}")
	@ApiOperation(value = "Obtener una entrada-salida con el código", notes = "Servicio para obtener una entrada-salida con código")
	@ApiResponses(value = { @ApiResponse(code = 201, message = "Entrada-salida obtenida correctamente"),
			@ApiResponse(code = 400, message = "Solicitud Inválida")})
	public ResponseEntity<EntradasSalidas> findByCodigo(@PathVariable("codigo")String codigo){
		return ResponseEntity.ok(this.entradasSalidasService.findByCodigo(codigo));
		}

}
	
	
	

