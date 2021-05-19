																/*
 -------------------------------------------------------------------
|
| CRUDyLeaf	- A Domain Specific Language for generating Spring Boot 
|			REST resources from entity CRUD operations.
| Author: Omar S. G�mez (2020)
| File Date: Wed May 19 13:39:30 ECT 2021
| 
 -------------------------------------------------------------------
																*/
package com.oblivion.backend;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Id;	
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
	
@Entity
@Table(name = "Finca")
public class Finca {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idFinca;
	
	private Long idLugar;
	private String ciPropietario;
	private String cedulaUsuario;
	private String coordenadaXFinca;
	private String coordenadaYFinca;
	private String coordenadaZFinca;
	private Boolean estadoFinca;
	private Date fechaUpdateFinca;
	
	public Long getIdFinca() {
		return idFinca;
	}
	public void setIdFinca(Long idFinca) {
		this.idFinca = idFinca;
	}
	public Long getIdLugar() {
		return idLugar;
	}
	public void setIdLugar(Long idLugar) {
		this.idLugar = idLugar;
	}
	public String getCiPropietario() {
		return ciPropietario;
	}
	public void setCiPropietario(String ciPropietario) {
		this.ciPropietario = ciPropietario;
	}
	public String getCedulaUsuario() {
		return cedulaUsuario;
	}
	public void setCedulaUsuario(String cedulaUsuario) {
		this.cedulaUsuario = cedulaUsuario;
	}
	public String getCoordenadaXFinca() {
		return coordenadaXFinca;
	}
	public void setCoordenadaXFinca(String coordenadaXFinca) {
		this.coordenadaXFinca = coordenadaXFinca;
	}
	public String getCoordenadaYFinca() {
		return coordenadaYFinca;
	}
	public void setCoordenadaYFinca(String coordenadaYFinca) {
		this.coordenadaYFinca = coordenadaYFinca;
	}
	public String getCoordenadaZFinca() {
		return coordenadaZFinca;
	}
	public void setCoordenadaZFinca(String coordenadaZFinca) {
		this.coordenadaZFinca = coordenadaZFinca;
	}
	public Boolean getEstadoFinca() {
		return estadoFinca;
	}
	public void setEstadoFinca(Boolean estadoFinca) {
		this.estadoFinca = estadoFinca;
	}
	public Date getFechaUpdateFinca() {
		return fechaUpdateFinca;
	}
	public void setFechaUpdateFinca(Date fechaUpdateFinca) {
		this.fechaUpdateFinca = fechaUpdateFinca;
	}
	

}
