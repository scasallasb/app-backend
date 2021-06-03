package com.sistelme.sistelme_info.bodega.model.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

import lombok.Data;
@Data
@Entity
@Table(name= "bodega")
public class EntradasSalidas {
	@Id
	@GeneratedValue(generator="system-uuid")
	@GenericGenerator(name="system-uuid", strategy="uuid2")
	private String idEntradasSalidas;
	
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
