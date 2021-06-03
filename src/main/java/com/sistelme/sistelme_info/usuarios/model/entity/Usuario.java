package com.sistelme.sistelme_info.usuarios.model.entity;


import java.io.Serializable;
import java.util.Date;

import java.util.Set;


import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.UpdateTimestamp;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Data;

@Data
@Entity
@Table(name= "usuario")
public class Usuario implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(generator="system-uuid")
	@GenericGenerator(name="system-uuid", strategy="uuid2")
	private String idUser;
	
	//basico
	@Column(nullable = false)
	private String nombreUser;
	
	private String segundoNombreUser;
	
	@Column(nullable = false)
	private String apellidoUser;
	
	private String segundoApellidoUser;
	
	@Column(nullable = false)
	private String identificationUser;
	
	private String TipoDocumento;
	private String lugarExpedicionDocumento;
	
	private String tipo_persona;
	
	
	@Column(nullable = false)
	private String telefonoUser;
	
	private String departamentoUser;
	private String municipioUser;
	
	@Column(nullable = false)
	private String direccionUser;
	
	private String coordenadasY;
	
	private String coordenadasX;
	
	@Column(nullable = false)
	private String emailUser;
	private String barrioUser;
	
	//cartera 
	@Column(nullable = false)
	private int estratoUser;
	private String codigoUser;
	
	private String nContrato;
	
	private Boolean isInstalled;
	private Boolean haveContract;
	//util 
	@CreationTimestamp
	@Column(name = "created_date")
	private Date creatAt;
	
	@UpdateTimestamp
	@Column(name = "last_modified_by")
	private Date uploadAt;
	
	//datos tecnicos
	@JsonIgnoreProperties(value={"usuario", "hibernateLazyInitializer", "handler"})
	@OneToMany(mappedBy = "usuario",fetch = FetchType.EAGER,cascade=CascadeType.ALL,orphanRemoval = true)
	@Transient 
    private Set<Topologia> topologia;
	
	
	@JsonIgnoreProperties(value={"usuario", "hibernateLazyInitializer", "handler"})
	@OneToMany(mappedBy="usuario",fetch = FetchType.EAGER,cascade=CascadeType.ALL,orphanRemoval = true)
	@Transient 
	private Set<Instalacion> instalacion;

}

