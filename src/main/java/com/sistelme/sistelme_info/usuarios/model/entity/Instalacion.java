package com.sistelme.sistelme_info.usuarios.model.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.GenericGenerator;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Data;

@Data
@Entity
@Table(name = "instalacion")
public class Instalacion implements Serializable{
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(generator="system-uuid")
	@GenericGenerator(name="system-uuid", strategy="uuid2")
	private String idInstalacion;
	@CreationTimestamp
	private Date fechaProgramada;
	@Temporal(TemporalType.DATE)
	private Date fechaInstalacion;	
	
	private String vendedor;
	
	private String observaciones;
	
	private String tipoInmueble;
	
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JsonIgnoreProperties(value={"instalacion", "hibernateLazyInitializer", "handler"})
	private Usuario usuario;
	
	@OneToMany(mappedBy="instalacion-servicio",fetch = FetchType.EAGER,cascade=CascadeType.ALL,orphanRemoval=true)
	@JsonIgnoreProperties(value={"instalacion", "hibernateLazyInitializer", "handler"})
	@Transient 
	private Set<InstalacionServicio> instalacionServicio;
	}
