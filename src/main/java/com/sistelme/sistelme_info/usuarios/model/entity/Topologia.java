package com.sistelme.sistelme_info.usuarios.model.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Data;

@Data
@Entity
@Table(name= "topologia")
public class Topologia {

	@Id
	@GeneratedValue(generator="system-uuid")
	@GenericGenerator(name="system-uuid", strategy="uuid2")
	private String idTopologia;
	@OnDelete(action = OnDeleteAction.CASCADE)	
	@ManyToOne(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
	@JsonIgnoreProperties(value={"topologia", "hibernateLazyInitializer", "handler"})
	private Usuario usuario;
	
	private String OLT;
	private String puerto;
	private String troncal;
	private String ramal;
	private String circuito;
	private String NAP;
	
}
