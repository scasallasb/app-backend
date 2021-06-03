package com.sistelme.sistelme_info.usuarios.model.entity;


import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Data;

@Entity
@Table(name="servicio_instalado")
@Data
public class ServicioInstalado {
	
	@Id
	@GeneratedValue(generator="system-uuid")
	@GenericGenerator(name="system-uuid", strategy="uuid2")
	private String idServicioInstalado;
	
	
	private String ip;
	private String macOnt;
	private String macTvBox;
	
	private String drop;
	private String utp;
	private String cable_av;
	
	@ManyToOne(fetch = FetchType.EAGER,cascade = CascadeType.ALL)
	@JsonIgnoreProperties(value={"servicio_instalado", "hibernateLazyInitializer", "handler"})
	private InstalacionServicio instalacionServicio;
}



