package com.sistelme.sistelme_info.usuarios.vista.resource.util;

import java.util.Date;

import com.sistelme.sistelme_info.usuarios.model.entity.Usuario;

import lombok.Data;

@Data
public class InstalacionVo {
    private String idInstalacion;
    private String observaciones;
	private Date fechaProgramada;
	private Date fechaInstalacion;
	private Usuario usuario;
}
