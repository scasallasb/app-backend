package com.sistelme.sistelme_info.usuarios.vista.resource.util;

import com.sistelme.sistelme_info.usuarios.model.entity.Instalacion;

import lombok.Data;

@Data
public class InstalacionServicioVo {
	private String idInstalacion_servicio;
	private int cantidad;
	private String concepto;
	private int v_unidad;
	private int v_total;
	private Instalacion instalacion;
}
