package com.sistelme.sistelme_info.usuarios.vista.resource.util;

import lombok.Data;

@Data
public class UsuarioVo {

	private String idUser;
	private String codigoUser;
	private String nombreUser;
	private String apellidoUser;
	private String identificationUser;
	private String telefonoUser;
	private String emailUser;
	
	private String direccionUser;
	private String coordenadasY;
	private String coordenadasX;

	private String departamentoUser;
	private String municipioUser;
	
	private String barrioUser;
	private int estratoUser;
	
	private String nContrato;
	
	private Boolean isInstalled;
	private Boolean haveContract;
}
