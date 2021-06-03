package com.sistelme.sistelme_info.usuarios.vista.resource.util;

import com.sistelme.sistelme_info.usuarios.model.entity.Usuario;

import lombok.Data;

@Data
public class TopologiaVo {
	
	private String idTopologia;
	private Usuario usuario;	
	private String OLT;
	private String puerto;
	private String Ramal;
	private String circuito;
	private String NAP;
	private String ONT;
}
