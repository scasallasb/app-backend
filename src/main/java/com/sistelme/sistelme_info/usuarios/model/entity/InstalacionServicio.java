package com.sistelme.sistelme_info.usuarios.model.entity;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.hibernate.annotations.GenericGenerator;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Data;

@Data
@Table(name="instalacion_servicio")
@Entity
public class InstalacionServicio {

	@Id
	@GeneratedValue(generator="system-uuid")
	@GenericGenerator(name="system-uuid", strategy="uuid2")
	private String idInstalacionServicio;
	
	
	private int cantidad;
	private String concepto;
	private int v_unidad;
	private int v_total;
	@ManyToOne(fetch = FetchType.EAGER)
	@JsonIgnoreProperties(value={"instalacion_servicio", "hibernateLazyInitializer", "handler"})
	private Instalacion instalacion;
	
	@OneToMany(mappedBy="servicio_instalado",fetch = FetchType.EAGER,cascade=CascadeType.ALL,orphanRemoval=true)
	@JsonIgnoreProperties(value={"instalacion-servicio", "hibernateLazyInitializer", "handler"})
	@Transient 
	private Set<ServicioInstalado> servicioInstalado;
	
}
