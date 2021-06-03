package com.sistelme.sistelme_info.infraestructura.vista.resource.util;

import java.util.Date;

import lombok.Data;

@Data
public class CajaEmpalmeVo {
	
	private String idCajaEmpalme;
	
	private String tipo;
	private String nomenclatura;
	private String marca;
	
	private String descripcion;
	
	private String ubicacion; 
	
	private String coordenadasY;
	private String coordenadasX;
	
	
	private boolean isActivate;
	
	private Date creatAt;
	private Date uploadAt;
	
}
