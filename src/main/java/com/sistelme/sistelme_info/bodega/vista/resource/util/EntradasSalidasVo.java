package com.sistelme.sistelme_info.bodega.vista.resource.util;

import java.util.Date;

import lombok.Data;
@Data
public class EntradasSalidasVo {
	private String codigo;
	private String nombre;
	private String existencias;
	private Date fecha_de_entrada;
	private Date fecha_de_salida;
	private String Ubicacion;
	private String saldo;
	private String Observaciones;
	private String codigoSistelme;
	
}
