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

import com.sistelme.sistelme_info.usuarios.model.entity.Usuario;
import com.sistelme.sistelme_info.usuarios.negocio.service.UsuarioService;
import com.sistelme.sistelme_info.usuarios.vista.resource.util.UsuarioVo;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
@CrossOrigin(origins = "http://localhost:4200",allowedHeaders = "*")
@RestController
@RequestMapping("api/usuario")
@Api(tags = "usuario")
public class UsuarioResource {

	private final UsuarioService usuarioService;
	
	public UsuarioResource(UsuarioService usuarioService) {
		this.usuarioService= usuarioService;
	}
	
	@ApiOperation(value = "Crear Cliente", notes = "Servicio para crear un nuevo cliente")
	@ApiResponses(value = { @ApiResponse(code = 201, message = "Cliente creado correctamente"),
			@ApiResponse(code = 400, message = "Solicitud Inválida"),
			@ApiResponse(code = 304, message = "Cliente ya existe")})
	@PostMapping
	public ResponseEntity<Usuario> CreateUser(@RequestBody UsuarioVo usuarioVo){
		Usuario usuario = new Usuario();
		if (this.usuarioService.findByIdentificacion(usuarioVo.getIdentificationUser())==null) {	
		usuario.setCodigoUser(usuarioVo.getCodigoUser());
		usuario.setNContrato(usuarioVo.getNContrato());
		usuario.setNombreUser(usuarioVo.getNombreUser());
		usuario.setApellidoUser(usuarioVo.getApellidoUser());
		usuario.setIdentificationUser(usuarioVo.getIdentificationUser());	
		usuario.setTelefonoUser(usuarioVo.getTelefonoUser());
		usuario.setDepartamentoUser(usuarioVo.getDepartamentoUser());
		usuario.setMunicipioUser(usuarioVo.getMunicipioUser());
		usuario.setDireccionUser(usuarioVo.getDireccionUser());
		usuario.setCoordenadasX(usuarioVo.getCoordenadasX());
		usuario.setCoordenadasY(usuarioVo.getCoordenadasY());
		usuario.setEmailUser(usuarioVo.getEmailUser());
		usuario.setBarrioUser(usuarioVo.getBarrioUser());
		usuario.setEstratoUser(usuarioVo.getEstratoUser());
		usuario.setHaveContract(usuarioVo.getHaveContract());
		usuario.setIsInstalled(usuarioVo.getIsInstalled());
		
		return new ResponseEntity <> (this.usuarioService.create(usuario), HttpStatus.CREATED);
		}else {
			return new ResponseEntity <>(HttpStatus.NOT_MODIFIED);
		}
		
		} 
	 
	
	@PutMapping("identificacion/{identificacion}")
	@ApiOperation(value = "Actualizar Cliente", notes = "Servicio para actualizar un cliente")
	@ApiResponses(value = { @ApiResponse(code = 201, message = "Cliente actualizado correctamente"),
			@ApiResponse(code = 404, message = "Cliente no encontrado") })
	public ResponseEntity<Usuario> updateUsuario(@PathVariable("identificacion") String id,@RequestBody UsuarioVo usuarioVo  ){
		Usuario usuario = this.usuarioService.findById(id);
		if (usuario == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}else {
			usuario.setCodigoUser(usuarioVo.getCodigoUser());
			usuario.setNombreUser(usuarioVo.getNombreUser());
			usuario.setApellidoUser(usuarioVo.getApellidoUser());
			usuario.setNContrato(usuarioVo.getNContrato());
			usuario.setIdentificationUser(usuarioVo.getIdentificationUser());
			usuario.setTelefonoUser(usuarioVo.getTelefonoUser());
			usuario.setDepartamentoUser(usuarioVo.getDepartamentoUser());
			usuario.setMunicipioUser(usuarioVo.getMunicipioUser());
			usuario.setDireccionUser(usuarioVo.getDireccionUser());
			usuario.setCoordenadasX(usuarioVo.getCoordenadasX());
			usuario.setCoordenadasY(usuarioVo.getCoordenadasY());
			usuario.setEmailUser(usuarioVo.getEmailUser());
			usuario.setBarrioUser(usuarioVo.getBarrioUser());
			usuario.setEstratoUser(usuarioVo.getEstratoUser());
			usuario.setHaveContract(usuarioVo.getHaveContract());
			usuario.setIsInstalled(usuarioVo.getIsInstalled());
			return new ResponseEntity <> (this.usuarioService.update(usuario), HttpStatus.ACCEPTED);
		
		}
	}
	
	@DeleteMapping("/{identificacion}")
	@ApiOperation(value = "Eliminar Cliente", notes = "Servicio para eliminar un cliente")
	@ApiResponses(value = { @ApiResponse(code = 201, message = "Cliente eliminado correctamente"),
			@ApiResponse(code = 404, message = "Cliente no encontrado") })
	public void  deleteUsuario(@PathVariable("identificacion") String identificacion){
		Usuario usuario = this.usuarioService.findById(identificacion);
		if (usuario != null) {
			this.usuarioService.delete(usuario);
		}
	}
	
	@GetMapping 
	@ApiOperation(value = "Listar Clientes", notes = "Servicio para listar todos los clientes")
	@ApiResponses(value = { @ApiResponse(code = 201, message = "Clientes encontrados"),
			@ApiResponse(code = 404, message = "Clientes no encontrados") })
	public ResponseEntity<List<Usuario>> findAll(){
		return ResponseEntity.ok(this.usuarioService.findAll());
		
	}
	
	@GetMapping("identificacion/{identificacion}")
	@ApiOperation(value = "Listar Cliente", notes = "Servicio para listar cliente con identificacion")
	@ApiResponses(value = { @ApiResponse(code = 201, message = "Cliente encontrado"),
			@ApiResponse(code = 404, message = "Clientes no encontrado") })
	public ResponseEntity<Usuario> findbyIdentificacion(@PathVariable("identificacion") String identificacion){
		Usuario usuario = this.usuarioService.findById(identificacion);
		return ResponseEntity.ok(usuario);	
	}
	
	@GetMapping("apellido/{apellido}")
	@ApiOperation(value = "Listar Clientes por apellido", notes = "Servicio para listar clientes por apellido")
	@ApiResponses(value = { @ApiResponse(code = 201, message = "Clientes encontrados"),
			@ApiResponse(code = 404, message = "Clientes no encontrados") })
	public ResponseEntity<List<Usuario>> findbyApellido(@PathVariable("apellido") String apellidoUser){
		List <Usuario> usuario = this.usuarioService.findByApellido(apellidoUser);
		return ResponseEntity.ok(usuario);	
	}
	
	@GetMapping("nombre/{nombre}")
	@ApiOperation(value = "Listar Clientes por nombre", notes = "Servicio para listar clientes por nombre")
	@ApiResponses(value = { @ApiResponse(code = 201, message = "Clientes encontrados"),
			@ApiResponse(code = 404, message = "Clientes no encontrados") })
	public ResponseEntity<List<Usuario>> findbyNombre(@PathVariable("nombre") String nombreUser){
		List <Usuario> usuario = this.usuarioService.findByNombre(nombreUser);
		return ResponseEntity.ok(usuario);	
	}
	

	@GetMapping("codigo/{codigo}")
	@ApiOperation(value = "Listar Clientes por codigo", notes = "Servicio para listar clientes por codigo")
	@ApiResponses(value = { @ApiResponse(code = 201, message = "Clientes encontrados"),
			@ApiResponse(code = 404, message = "Clientes no encontrados") })
	public ResponseEntity<List<Usuario>> findbyCodigo(@PathVariable("codigo") String codigoUser){
		List <Usuario> usuario = this.usuarioService.findByCodigo(codigoUser);
		return ResponseEntity.ok(usuario);	
	}
	
}