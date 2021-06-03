package com.sistelme.sistelme_info.infraestructura.vista.resource;

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

import com.sistelme.sistelme_info.infraestructura.model.entity.CajaEmpalme;
import com.sistelme.sistelme_info.infraestructura.negocio.service.CajaEmpalmeService;
import com.sistelme.sistelme_info.infraestructura.vista.resource.util.CajaEmpalmeVo;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;


@RequestMapping("api/infraestructura")
@RestController
@Api(tags = "caja-empalme")
public class CajaEmpalmeResource {
	
	
	private final CajaEmpalmeService cajaEmpalmeService;
	
	public CajaEmpalmeResource(CajaEmpalmeService cajaEmpalmeService) {
		 this.cajaEmpalmeService = cajaEmpalmeService;
	}
	
	@PostMapping
	@ApiOperation(value = "Crear caja de empalme", notes = "Servicio para crear una nueva caja de empalme")
	@ApiResponses(value = { @ApiResponse(code = 201, message = "Caja de empalme creada correctamente"),
			@ApiResponse(code = 400, message = "Solicitud Inválida"),
			@ApiResponse(code = 304, message = "Caja de empalme ya existe")})
	public ResponseEntity<CajaEmpalme> crear(@RequestBody CajaEmpalmeVo cajaEmpalmeVo){
		
		CajaEmpalme cajaEmpalme = new CajaEmpalme();
		
		if (this.cajaEmpalmeService.getByNomenclatura(cajaEmpalmeVo.getNomenclatura()) == null) {
		cajaEmpalme.setNomenclatura(cajaEmpalmeVo.getNomenclatura());
		cajaEmpalme.setTipo(cajaEmpalmeVo.getTipo());
		cajaEmpalme.setMarca(cajaEmpalmeVo.getMarca());
		cajaEmpalme.setCoordenadasX(cajaEmpalmeVo.getCoordenadasX());
		cajaEmpalme.setCoordenadasY(cajaEmpalmeVo.getCoordenadasY());
		cajaEmpalme.setDescripcion(cajaEmpalmeVo.getDescripcion());
		cajaEmpalme.setUbicacion(cajaEmpalmeVo.getUbicacion());
		cajaEmpalme.setActivate(cajaEmpalmeVo.isActivate());
		cajaEmpalme.setUploadAt(cajaEmpalmeVo.getUploadAt());
		
		return new ResponseEntity<> (this.cajaEmpalmeService.create(cajaEmpalme), HttpStatus.CREATED);
		
	}else {
		return new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
		}
	}
	
	@PutMapping
	@ApiOperation(value = "Actualizar caja de empalme", notes = "Servicio para actualizar una nueva caja de empalme")
	@ApiResponses(value = { @ApiResponse(code = 201, message = "Caja de empalme actualizada correctamente"),
			@ApiResponse(code = 400, message = "Solicitud Inválida"),
			@ApiResponse(code = 304, message = "Caja de empalme ya existe")})
	public ResponseEntity<CajaEmpalme> actualizar(@RequestBody CajaEmpalmeVo cajaEmpalmeVo){
		CajaEmpalme cajaEmpalme = this.cajaEmpalmeService.getByNomenclatura(cajaEmpalmeVo.getNomenclatura());
		if (cajaEmpalme != null) {
			cajaEmpalme.setNomenclatura(cajaEmpalmeVo.getNomenclatura());
			cajaEmpalme.setTipo(cajaEmpalmeVo.getTipo());
			cajaEmpalme.setMarca(cajaEmpalmeVo.getMarca());
			cajaEmpalme.setCoordenadasX(cajaEmpalmeVo.getCoordenadasX());
			cajaEmpalme.setCoordenadasY(cajaEmpalmeVo.getCoordenadasY());
			cajaEmpalme.setDescripcion(cajaEmpalmeVo.getDescripcion());
			cajaEmpalme.setUbicacion(cajaEmpalmeVo.getUbicacion());
			cajaEmpalme.setActivate(cajaEmpalmeVo.isActivate());
			cajaEmpalme.setUploadAt(cajaEmpalmeVo.getUploadAt());
			
			return new ResponseEntity<> (this.cajaEmpalmeService.create(cajaEmpalme), HttpStatus.CREATED);
		}
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}
	
	@DeleteMapping("/{nomenclatura}")
	@ApiOperation(value = "eliminar caja de empalme", notes = "Servicio para eliminar una nueva caja de empalme")
	@ApiResponses(value = { @ApiResponse(code = 201, message = "Caja de empalme eliminada correctamente"),
			@ApiResponse(code = 400, message = "Solicitud Inválida"),
			@ApiResponse(code = 304, message = "Caja de empalme no eliminada")})
	public void delete(@PathVariable("nomenclatura") String nomenclatura) {
		CajaEmpalme cajaEmpalme = this.cajaEmpalmeService.getByNomenclatura(nomenclatura);
		if(cajaEmpalme != null) {
			this.cajaEmpalmeService.delete(cajaEmpalme);
		}
	}
	
	@GetMapping
	@ApiOperation(value = "Obtener todas las cajas de empalme", notes = "Servicio para obtener todas las cajas de empalme")
	@ApiResponses(value = { @ApiResponse(code = 201, message = "Cajas de empalme obtenida correctamente"),
			@ApiResponse(code = 400, message = "Solicitud Inválida"),
			@ApiResponse(code = 304, message = "Cajas de empalme no obtenidas")})
	public ResponseEntity<List<CajaEmpalme>> getAll(){
		return ResponseEntity.ok(this.cajaEmpalmeService.getAll());
	}
	
	@GetMapping("/tipo/{tipo}")
	@ApiOperation(value = "Obtener todas las cajas de empalme con el tipo", notes = "Servicio para obtener todas las cajas de empalme con el tipo")
	@ApiResponses(value = { @ApiResponse(code = 201, message = "Cajas de empalme obtenida correctamente con el tipo"),
			@ApiResponse(code = 400, message = "Solicitud Inválida"),
			@ApiResponse(code = 304, message = "Cajas de empalme no obtenidas")})
	public ResponseEntity<List<CajaEmpalme>> getByTipo(@PathVariable("tipo")String tipo){
		return ResponseEntity.ok(this.cajaEmpalmeService.getByTipo(tipo));
	}
	
	@GetMapping("/marca/{marca}")
	@ApiOperation(value = "Obtener todas las cajas de empalme con la marca", notes = "Servicio para obtener todas las cajas de empalme con la marca")
	@ApiResponses(value = { @ApiResponse(code = 201, message = "Cajas de empalme obtenida correctamente con la marca"),
			@ApiResponse(code = 400, message = "Solicitud Inválida"),
			@ApiResponse(code = 304, message = "Cajas de empalme no obtenidas")})
	public ResponseEntity<List<CajaEmpalme>>getByMarca(@PathVariable("marca")String marca ){
		return ResponseEntity.ok(this.cajaEmpalmeService.getByMarca(marca));
	}
	

}
