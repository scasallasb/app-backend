package com.sistelme.sistelme_info.infraestructura.model.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.UpdateTimestamp;

import lombok.Data;

@Data
@Table(name="caja_de_empalme")
@Entity
public class CajaEmpalme {
	
	@Id
	@GeneratedValue(generator="system-uuid")
	@GenericGenerator(name="system-uuid", strategy="uuid2")
	private String idCajaEmpalme;
	
	
	private String tipo;
	private String nomenclatura;
	private String marca;
	
	private String descripcion;
	
	private String ubicacion; 
	
	private String coordenadasY;
	private String coordenadasX;
	
	
	private boolean isActivate;
	
	//util 
	@CreationTimestamp
	@Column(name = "created_date")
	private Date creatAt;
	
	@UpdateTimestamp
	@Column(name = "last_modified_by")
	private Date uploadAt;

}
