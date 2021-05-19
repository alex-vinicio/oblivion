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
@Table(name = "propietario_table")
public class Propietario {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long ciPropietario;
	
	private String celularPropietario;
	private Date fechaUpdatePropietario;
	private Boolean estadoPropietario;
	public Long getCiPropietario() {
		return ciPropietario;
	}
	public void setCiPropietario(Long ciPropietario) {
		this.ciPropietario = ciPropietario;
	}
	public String getCelularPropietario() {
		return celularPropietario;
	}
	public void setCelularPropietario(String celularPropietario) {
		this.celularPropietario = celularPropietario;
	}
	public Date getFechaUpdatePropietario() {
		return fechaUpdatePropietario;
	}
	public void setFechaUpdatePropietario(Date fechaUpdatePropietario) {
		this.fechaUpdatePropietario = fechaUpdatePropietario;
	}
	public Boolean getEstadoPropietario() {
		return estadoPropietario;
	}
	public void setEstadoPropietario(Boolean estadoPropietario) {
		this.estadoPropietario = estadoPropietario;
	}
	
	
	
}
