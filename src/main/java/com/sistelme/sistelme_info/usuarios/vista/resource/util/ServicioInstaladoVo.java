package com.sistelme.sistelme_info.usuarios.vista.resource.util;

import com.sistelme.sistelme_info.usuarios.model.entity.InstalacionServicio;

import lombok.Data;

@Data
public class ServicioInstaladoVo {

	private String idServicioInstalado;
	
	
	private String Ip;
	private String MacOnt;
	private String MacTvBox;
	
	private String drop;
	private String utp;
	private String cable_av;
	
	private InstalacionServicio instalacionServicio;

}
